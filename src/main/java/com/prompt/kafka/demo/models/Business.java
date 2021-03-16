package com.prompt.kafka.demo.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Builder
@Table(name = "business")
public class Business{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="register_number", nullable = false)
    private String registerNumber;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="brand_name", nullable = false)
    private String brandName;

    @Column(name="open_date", nullable = false)
    private Date openDate;
}
