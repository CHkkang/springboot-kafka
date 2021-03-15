package com.prompt.kafka.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prompt.kafka.demo.builder.KafkaBuilder;
import com.prompt.kafka.demo.service.BusinessConsumerService;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.management.Notification;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
@RestController("/message")
public class KafkaController {
    ObjectMapper mapper = new ObjectMapper();

    CamelContext camelContext;

    @Autowired
    @Qualifier("KafkaRouteProducer")
    RouteBuilder kafkaRouteProducer;

    @Autowired
    @Qualifier("KafkaRouteConsumer")
    RouteBuilder kafkaRouteConsumer;

    @EndpointInject
    ProducerTemplate kafkaProducer;

    ConsumerTemplate kafkaConsumer;

    @PostConstruct
    public void setup() {
        try {
            camelContext.addRoutes(kafkaRouteProducer);
            camelContext.addRoutes(kafkaRouteConsumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response) {
        try {
            kafkaProducer.sendBody("direct:kafkaRoute", "This is a message from the /message route!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response, @RequestBody Notification notification) {
        try {
            kafkaProducer.sendBody("direct:kafkaRoute", mapper.writeValueAsString(notification));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
