package com.jack.restaurants.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    @Id
    private int id;
    private String name;
    private String address;
    private String city;
    private String description;
}
