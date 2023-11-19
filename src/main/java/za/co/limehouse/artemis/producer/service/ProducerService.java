package za.co.limehouse.artemis.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import za.co.limehouse.artemis.producer.controller.ProducerController;

@Service
public class ProducerService {

    Logger log = LoggerFactory.getLogger(ProducerService.class);
    JmsTemplate jmsTemplate;


    public ProducerService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String msg) {
        // will create queue if it does not exist
        jmsTemplate.convertAndSend("springboot", msg);
        log.info("Sent msg:" + msg);
    }


}
