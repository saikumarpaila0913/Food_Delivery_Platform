package restaurant.FoodDelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.FoodDelivery.Model.Order;
import restaurant.FoodDelivery.Model.User;
import restaurant.FoodDelivery.Service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/user/signUp")
    public String UserSignUp(@RequestBody  User user){
        return userService.SignUp(user);
    }

    @PostMapping("/user/signin")
    public String UsersignIn(  @RequestBody String Email, @RequestBody String password){
        return userService.UserSignIn(Email,password);
    }

    @PutMapping("/user/update")
    public User UserUpdate(@RequestBody User user){
        return userService.UpdateUser(user);
    }

    @GetMapping("/order/History")
    public List<Order> OrderHistory(@RequestBody String Email){
        return userService.OrderHistory(Email);
    }
}
