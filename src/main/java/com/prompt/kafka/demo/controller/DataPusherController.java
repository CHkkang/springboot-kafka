package com.prompt.kafka.demo.controller;

import com.prompt.kafka.demo.models.Business;
import com.prompt.kafka.demo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DataPusherController {

    @Autowired
    private BusinessService businessService;

    public Long save(@RequestBody Business business){
        return businessService.save(business);
    }
}
