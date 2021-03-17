package com.prompt.kafka.router;

import com.prompt.kafka.controller.DataPusherController;
import com.prompt.kafka.service.KafkaService;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaCamelRouter{

    @Bean(name = "KafkaRouteProducer")
    public RouteBuilder kafkaRouteProducer() {
        return new RouteBuilder(){
            @Override
            public void configure(){
                from("direct:kafkaRoute")
                        .setHeader(KafkaConstants.KEY, constant("Camel"))
                        .to("kafka:{{kafka.topic}}?brokers={{kafka.host}}:{{kafka.port}}")
                        .bean(KafkaService.class, "print");
            }
        };
    }

    @Bean(name = "KafkaRouteConsumer")
    public RouteBuilder kafkaRouteConsumer() {
        return new RouteBuilder(){
            @Override
            public void configure(){
                from("kafka:{{kafka.topic}}?brokers={{kafka.host}}:{{kafka.port}}" +
                        "&groupId={{kafka.group-id}}" +
                        "&autoOffsetReset={{kafka.auto-offset-reset}}" +
                        "&consumersCount=1")
                        .bean(DataPusherController.class, "save");
            }
        };
    }
}
