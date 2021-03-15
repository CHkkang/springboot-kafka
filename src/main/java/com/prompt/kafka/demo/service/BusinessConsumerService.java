package com.prompt.kafka.demo.service;

import lombok.RequiredArgsConstructor;
import org.apache.camel.Consume;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@Service
@RequiredArgsConstructor
public class BusinessConsumerService {
    private final Logger logger = LoggerFactory.getLogger(BusinessConsumerService.class);

    @Consume("kafka:192.168.50.176:9092?topic=business&groupId=business&autoOffsetReset=earliest&consumersCount=1")
    public void onMessage(String message) {
        logger.info("MessageConsumer: onMessage: message is: [" + message + "]");


    }
}
