package com.jack.restaurants.mapper;

import com.jack.restaurants.dto.RestaurantDTO;
import com.jack.restaurants.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

}
