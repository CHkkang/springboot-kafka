package com.prompt.kafka.demo.builder;

import org.apache.camel.Consume;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;

public class KafkaBuilder {

    //producer
    @Bean(name = "KafkaRouteProducer")
    public RouteBuilder kafkaRouteProducer() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:kafkaRoute")
                        .to("kafka:192.168.50.176:9092?topic=business&groupId=business&autoOffsetReset=earliest&consumersCount=1");
            }
        };
    }

    //consumer
    @Consume("kafka:192.168.50.176:9092?topic=business&groupId=business&autoOffsetReset=earliest&consumersCount=1")
    public RouteBuilder kafkaRouteConsumer() {
        return new RouteBuilder() {
            public void configure() {
                from("kafka:192.168.50.176:9092?topic=business&groupId=business&autoOffsetReset=earliest&consumersCount=1");
            }
        };
    }
}
