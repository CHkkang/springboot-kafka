package com.prompt.kafka.demo.service;

import com.prompt.kafka.demo.models.Business;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class BusinessConsumerService {

    @Value("${kafka.topic.business-topic}")
    private String businessTopic;

    private final Logger logger = LoggerFactory.getLogger(BusinessProducerService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = {"${kafka.topic.business-topic}"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> businessConsumerRecord) {
        try {
            Business business = objectMapper.readValue(businessConsumerRecord.value(), Business.class);
            logger.info("topic:{} partition:{} -> {}",
                    businessConsumerRecord.topic(),
                    businessConsumerRecord.partition(),
                    business.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
