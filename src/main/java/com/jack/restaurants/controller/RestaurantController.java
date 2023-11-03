package com.jack.restaurants.controller;


import com.jack.restaurants.dto.RestaurantDTO;
import com.jack.restaurants.entity.Restaurant;
import com.jack.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(){
        List<RestaurantDTO> restaurantDTOList = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantAdded = restaurantService.addRestaurant(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);

    }

    @GetMapping("getById/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer id){
        return restaurantService.getRestaurantById(id);
    }




}
