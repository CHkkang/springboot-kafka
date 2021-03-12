package com.prompt.kafka.demo.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class BusinessConsumerService {
    private final Logger logger = LoggerFactory.getLogger(BusinessProducerService.class);

    @KafkaListener(topics = "business", groupId = "business")
    public void onMessage(String message) {
        logger.info("MessageConsumer: onMessage: message is: [" + message + "]");
    }
}
