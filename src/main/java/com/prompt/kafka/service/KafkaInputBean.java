package com.prompt.kafka.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prompt.kafka.models.Business;

import java.io.IOException;

public class KafkaInputBean {

    public void print(String body) {
        try {
            Business business = new ObjectMapper().readValue(body, Business.class);
            System.out.println("Producer -> Broker >> " + business.toString());
        } catch (JsonParseException e) {
            System.out.println(body + " cannot be marshalled to a business.class");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
