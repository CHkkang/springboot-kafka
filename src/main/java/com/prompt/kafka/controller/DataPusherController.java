package com.prompt.kafka.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.prompt.kafka.models.Business;
import com.prompt.kafka.service.BusinessService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DataPusherController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataPusherController.class);

    @Autowired
    private BusinessService businessService;

    public void saveBusiness(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Business business = objectMapper.readValue(body, Business.class);
            LOGGER.info(business.toString());
            businessService.save(business);
        } catch (JsonParseException e) {
            LOGGER.info(body + " cannot be marshalled to a business.class");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
