package com.prompt.kafka.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prompt.kafka.controller.DataPusherController;
import com.prompt.kafka.models.Business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class KafkaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataPusherController.class);

    public void print(String body) {
        try {
            Business business = new ObjectMapper().readValue(body, Business.class);
            LOGGER.info("Producer -> Broker >> " + business.toString());
        } catch (JsonParseException e) {
            LOGGER.error(body + " cannot be marshalled to a business.class");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
