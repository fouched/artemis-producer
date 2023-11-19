package za.co.limehouse.artemis.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.limehouse.artemis.producer.service.ProducerService;

@RestController
public class ProducerController {

    Logger log = LoggerFactory.getLogger(ProducerController.class);

    ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "queue/sendMessage")
    public void sendMessage(@RequestParam("msg") String msg) {
        log.debug("Sending msg:" + msg);
        producerService.sendMessage(msg);
    }
}
