package com.prompt.kafka.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Business implements Serializable {

    private static final long serialVersionUID = 1907569777241442102L;


    @Id
    private int id;
    
    private String RegisterNumber;
    private String name;
    private String brandName;
    private Date openDate;

    @Override
    public String toString(){
        String business = "Business : {" + "id : " + id + " RegisterNumber : " + RegisterNumber + " name : " + name+
                " brandName : " + brandName + " openDate : " + openDate + "}";

        return business;
    }
}
