package com.prompt.kafka.demo.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
@Service
public class BusinessProducerService {

    private static final Logger logger = LoggerFactory.getLogger(BusinessProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public BusinessProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object o) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, o);
        future.addCallback(result -> logger.info("topic:{} partition:{}", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> logger.error("message：{}", ex.getMessage()));
    }
}
