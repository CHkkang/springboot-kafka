package com.prompt.kafka.demo.controller;

import com.prompt.kafka.demo.models.Business;
import com.prompt.kafka.demo.service.BusinessProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class KafkaController {
    @Value("${kafka.topic.my-topic}")
    String businessTopic;

    private final BusinessProducerService producer;

    KafkaController(BusinessProducerService producer) {
        this.producer = producer;
    }

    @PostMapping
    public void sendMessageToKafkaTopic(@RequestParam("name") String name) {
        this.producer.sendMessage(businessTopic, new Business());
    }
}
