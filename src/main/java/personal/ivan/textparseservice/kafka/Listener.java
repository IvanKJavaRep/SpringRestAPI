package personal.ivan.textparseservice.kafka;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import personal.ivan.textparseservice.restapi.dto.MyDTO;
import personal.ivan.textparseservice.service.MyTableService;

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
            Thread.sleep(500);
            MyDTO obj = objectMapper.readValue(message, MyDTO.class);
            myTableService.createEntity(obj);
        } catch (Exception ex) {
            System.out.println("problems with network try in 2 seconds");
            if (retryCounter < 5) {
                retryCounter += 1;
                kafkaTemplate.send("retryTopic", message);
            } else {
                retryCounter = 0;
            }
        }
        ack.acknowledge();
    }
}
