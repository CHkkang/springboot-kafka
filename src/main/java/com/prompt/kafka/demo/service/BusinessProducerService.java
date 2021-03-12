package com.prompt.kafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class BusinessProducerService {
    private static Logger logger = LoggerFactory.getLogger(BusinessProducerService.class);
    private static final String TOPIC = "business";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        System.out.println("hi producer!");
        kafkaTemplate.send(TOPIC, message);
        logger.info("MessageProducer: send: message is: [" + message + "]");

    }
}
