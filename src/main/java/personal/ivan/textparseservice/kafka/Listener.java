package personal.ivan.textparseservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import personal.ivan.textparseservice.restapi.dto.MyDTO;
import personal.ivan.textparseservice.service.MyTableService;

import java.security.InvalidParameterException;

@Service
public final class Listener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    private static int retryCounter = 0;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    MyTableService myTableService;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "kafkaTopic"
    )
    public void listen(String message, Acknowledgment ack) {
        try {
            logger.info(String.format("$$$$ => Consumed message: %s", message));
            MyDTO obj = objectMapper.readValue(message, MyDTO.class);
            myTableService.createEntity(obj);
            throw new RuntimeException();
        } catch (JsonMappingException ex) {
            System.out.println("Invalid data");
        } catch (Exception ex) {
            System.out.println("problems with network try in 2 seconds in retryTopic");
            kafkaTemplate.send("retryTopic", message);
        }
        ack.acknowledge();
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "retryTopic"
    )
    public void retry(String message, Acknowledgment ack) {
        try {
            System.out.println(message);
            MyDTO obj = objectMapper.readValue(message, MyDTO.class);
        } catch (Exception ex) {
            System.out.println("problems with network try in 2 seconds");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (retryCounter < 5) {
                retryCounter += 1;
                throw new RuntimeException();
            } else {
                retryCounter = 0;
            }
        }
        ack.acknowledge();
    }
}
