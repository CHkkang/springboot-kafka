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

    @Override
    public String toString(){
        String business = "Business : {" + "id : " + id + "RegisterNumber : " + RegisterNumber + "name : " + name+
                "brandName : " + brandName + "openDate : " + openDate + "}";

        return business;
    }
}
