package restaurant.FoodDelivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.FoodDelivery.Model.Admin;
import restaurant.FoodDelivery.Model.FoodItem;
import restaurant.FoodDelivery.Model.Order;
import restaurant.FoodDelivery.Service.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
   @Autowired
    AdminService adminService;


   @PostMapping("/admin/SignUp")
    public String AdminSignup(@RequestBody Admin admin){
     return adminService.SignUp(admin);
   }

   @PostMapping("/admin/signin")
    public String AdminSignin(@RequestBody String Email,@RequestBody String Password){
       return adminService.AdminSignIn(Email,Password);
   }

   @PutMapping("/admin/Update")
    public Admin UpdateAdmin(@RequestBody Admin admin){
       return adminService.UpdateAdmin(admin);
   }

   @PostMapping("/admin/FoodItem")
    public String addFoodItem(@RequestBody FoodItem Item){
       return adminService.AddFoodItem(Item);
   }

   @PutMapping("/admin/FoodItem")
    public FoodItem UpdateItem(@RequestBody FoodItem Item){
       return adminService.UpdateItem(Item);
   }

   @GetMapping("/admin/AllItems")
    public List<FoodItem> GetAllItems(){
       return adminService.getFoodItems();
   }

   @DeleteMapping("/admin/FoodItem")
    public String DeleteItem(@RequestBody Long Id){
       return adminService.DeleteItem(Id);
   }

   @DeleteMapping("/User/Token")
    public String removeToken(@RequestBody String Token){
       return adminService.RemoveToken(Token);
   }

   @GetMapping("/Order/Id")
    public Optional<Order> GetOrderById(@RequestBody Long Id){
       return adminService.GetOrderById(Id);
   }


}
