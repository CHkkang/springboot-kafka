package com.prompt.kafka.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class Business {
    private List<Business> mainList;
    @Id
    private int id;
    
    private String RegisterNumber;
    private String name;
    private String brandName;
    private Date openDate;

    public List<Business> getMainList() {
        return mainList;
    }

    @Override
    public String toString(){
        String business = "Business : {" + "id : " + id + " RegisterNumber : " + RegisterNumber + " name : " + name+
                " brandName : " + brandName + " openDate : " + openDate + "}";

        return business;
    }
}
