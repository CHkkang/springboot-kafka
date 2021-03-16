package com.prompt.kafka.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prompt.kafka.demo.models.Business;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/message")
public class KafkaController {

    @Autowired
    CamelContext camelContext;

    @Autowired
    @Qualifier("KafkaRouteProducer")
    RouteBuilder kafkaRouteProducer;

    @Autowired
    @Qualifier("KafkaRouteConsumer")
    RouteBuilder kafkaRouteConsumer;

    @EndpointInject(uri = "direct:kafkaRoute")
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

    /**
     * POST a business, send it as a message to Kafka.
     *
     * @param business
     *            the {@link Business} to be posted.
     */
    @PostMapping
    public void producer(@RequestBody Business business) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            kafkaProducer.sendBody("direct:kafkaRoute", mapper.writeValueAsString(business));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
