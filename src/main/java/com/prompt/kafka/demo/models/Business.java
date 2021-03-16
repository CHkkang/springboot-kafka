package com.prompt.kafka.demo.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
public class Business{
    @Id
    private int id;
    
    private String register;
    private String name;
    private String brandName;
    private Date openDate;

}
