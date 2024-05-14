package com.example.goodfood;

import com.example.goodfood.restaurant.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class GoodfoodApplicationTests {

    @Test
    void contextLoads() {
        GoodFoodApplication.main(new String[0]);
    }
    @Test
    void testAddandListRestaurant(
            @Autowired RestaurantController controller,
            @Autowired RestaurantRepository repo) {
        Restaurant inputRestaurant = new Restaurant();
        inputRestaurant.setName("won");
        inputRestaurant.setRating(4);
        inputRestaurant.setInformation("My name is Won");
        inputRestaurant.setImagelink("https://support.rebrandly.com/hc/article_attachments/360020801793/rebrandly_url_shortener_010.png");

        BestMenu bestMenu = new BestMenu();
        bestMenu.setName("Omakase");
        bestMenu.setPrice("3dollar");

        Location location = new Location();
        location.setProvince("GangNam");
        location.setAddress("Unjuroo 134 Road");

        inputRestaurant.setBestMenu(bestMenu);
        inputRestaurant.setLocation(location);

        long beforeRestaurantCounts = repo.count();

        long index = controller.addRestaurant(inputRestaurant);
        Assertions.assertEquals(beforeRestaurantCounts + 1, repo.count());
        Restaurant checkRestaurant = repo.findById(index).orElse(null);
        Assertions.assertEquals(inputRestaurant.getName(), checkRestaurant.getName());
        Assertions.assertEquals(inputRestaurant.getRating(), checkRestaurant.getRating());
        Assertions.assertEquals(inputRestaurant.getImagelink(), checkRestaurant.getImagelink());
        Assertions.assertEquals(inputRestaurant.getInformation(), checkRestaurant.getInformation());
        Assertions.assertEquals(inputRestaurant.getBestMenu().getName(), checkRestaurant.getBestMenu().getName());
        Assertions.assertEquals(inputRestaurant.getBestMenu().getPrice(), checkRestaurant.getBestMenu().getPrice());
        Assertions.assertEquals(inputRestaurant.getLocation().getProvince(), checkRestaurant.getLocation().getProvince());
        Assertions.assertEquals(inputRestaurant.getLocation().getAddress(), checkRestaurant.getLocation().getAddress());

        Assertions.assertEquals(inputRestaurant.getORMID(), inputRestaurant.getBestMenu().getRestaurant().getORMID());
        Assertions.assertEquals(inputRestaurant.getORMID(), inputRestaurant.getLocation().getRestaurant().getORMID());

        Assertions.assertEquals(inputRestaurant.getORMID(), inputRestaurant.getId());
        Assertions.assertEquals(inputRestaurant.getBestMenu().getORMID(), inputRestaurant.getBestMenu().getId());
        Assertions.assertEquals(inputRestaurant.getLocation().getORMID(), inputRestaurant.getLocation().getId());

        inputRestaurant.setId(2);
        Assertions.assertEquals(inputRestaurant.getORMID(), 2);
        bestMenu.setId(1);
        Assertions.assertEquals(bestMenu.getORMID(), 1);
        location.setId(2);
        Assertions.assertEquals(location.getORMID(), 2);

    }
}
