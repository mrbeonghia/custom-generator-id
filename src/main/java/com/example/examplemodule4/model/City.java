package com.example.examplemodule4.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(generator = "city_id")
    @GenericGenerator(name = "city_id", strategy = "com.example.examplemodule4.StringGeneratorId")
    @Column(name = "city_id", length = 64)
    private String id;
    @NotEmpty(message = "tên không để trống")
    private String name;
    @ManyToOne
    private Country country;
    @Min(value = 1, message = "nhap lai so duong")
    private Double area;
    @Min(value = 1, message = "nhap lai so duong")
    private Long population;
    @Min(value = 1L, message = "nhap lai so duong")
    private double GDP;
    private String description;


}
