package com.prompt.kafka.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Builder
@Table(name = "business")
public class Business{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="register_number", unique = true, nullable = false)
    private String registerNumber;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="brand_name", nullable = false)
    private String brandName;

    @Column(name="open_date", nullable = false)
    private Date openDate;

    public Business() {

    }
}
