package com.prompt.kafka.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Business {
    
    @Id
    private int id;
    
    private String RegisterNumber;
    private String name;
    private String brandName;
    private String openDate;

}
