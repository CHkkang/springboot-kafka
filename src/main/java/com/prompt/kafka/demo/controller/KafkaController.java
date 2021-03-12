package com.prompt.kafka.demo.controller;

import com.prompt.kafka.demo.models.Business;
import com.prompt.kafka.demo.service.BusinessConsumerService;
import com.prompt.kafka.demo.service.BusinessProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class KafkaController {

    private final BusinessProducerService producerService;
    private final BusinessConsumerService consumerService;

    @PostMapping("/kafka")
    public void sendMessage(@RequestParam(value = "message") String message){
        System.out.println(message);
        this.producerService.send(message);
    }

    @GetMapping("/receive_message")
    public void receiveMessage(@RequestParam(value = "message") String message){
        System.out.println(message);
        this.consumerService.onMessage(message);
    }
}
