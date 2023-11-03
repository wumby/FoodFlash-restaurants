package com.jack.restaurants.service;


import com.jack.restaurants.dto.RestaurantDTO;
import com.jack.restaurants.entity.Restaurant;
import com.jack.restaurants.mapper.RestaurantMapper;
import com.jack.restaurants.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants(){
        List<Restaurant> restaurantList = restaurantRepo.findAll();

        return restaurantList.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO)
                .collect(Collectors.toList());

    }
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantAdded){
        Restaurant restaurantToAdd =  RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantAdded);
        restaurantRepo.save(restaurantToAdd);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantToAdd);

    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
