package com.prompt.kafka.demo.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaCamelRouter{

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCamelRouter.class);

    @Bean(name = "KafkaRouteProducer")
    public RouteBuilder kafkaRouteProducer() {
        return new RouteBuilder(){
            @Override
            public void configure(){
                from("direct:kafkaRoute")
                        .setHeader(KafkaConstants.KEY, constant("Camel"))
                        .to("kafka:business?brokers=192.168.50.176:9092")
                        .bean(KafkaInputBean.class);
            }
        };
    }

    @Bean(name = "KafkaRouteConsumer")
    public RouteBuilder kafkaRouteConsumer() {
        return new RouteBuilder(){
            @Override
            public void configure(){
                from("kafka:business?brokers=192.168.50.176:9092&groupId=business&autoOffsetReset=earliest&consumersCount=1")
                        .bean(KafkaOutputBean.class);
            }
        };
    }
}
