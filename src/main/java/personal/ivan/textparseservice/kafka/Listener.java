package personal.ivan.textparseservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class Listener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "kafkaTopic"
    )
    public void listen(String message) {
        logger.info(String.format("$$$$ => Consumed message: %s", message));
    }
}
