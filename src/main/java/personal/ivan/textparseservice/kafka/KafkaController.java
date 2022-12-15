package personal.ivan.textparseservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public final class KafkaController {
    @Autowired
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam String message) {
        System.out.println("ggggggggggggg");
        producerService.sendMessage(message);

    }
}