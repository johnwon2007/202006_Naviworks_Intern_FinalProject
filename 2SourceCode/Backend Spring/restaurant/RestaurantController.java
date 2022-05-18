package com.example.goodfood.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RepositoryRestController
public class RestaurantController {
    @Autowired RestaurantRepository repo;

    @RequestMapping(value="/restaurants", method = RequestMethod.POST)
    public @ResponseBody long addRestaurant(@RequestBody Restaurant restaurant){
        restaurant.getBestMenu().setRestaurant(restaurant);
        restaurant.getLocation().setRestaurant(restaurant);
        repo.save(restaurant);
        return restaurant.getORMID();
    }
}
