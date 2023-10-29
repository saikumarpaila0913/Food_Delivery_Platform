package restaurant.FoodDelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restaurant.FoodDelivery.Model.FoodItem;
import restaurant.FoodDelivery.Model.User;
import restaurant.FoodDelivery.Service.OrderService;

import java.util.List;

@RestController
public class OrderController {
@Autowired
    OrderService Orderservice;

    @PostMapping("/Order")
    public String newOrder(@RequestBody User user, @RequestBody List<FoodItem> Items){
      return   Orderservice.newOrder(user,Items);
    }

    @DeleteMapping("/Order")
    public String CancelOrder(@RequestBody Long Id){
        return Orderservice.CancleOrder(Id);
    }



}
