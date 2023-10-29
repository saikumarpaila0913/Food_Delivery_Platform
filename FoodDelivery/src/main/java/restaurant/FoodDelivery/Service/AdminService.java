package restaurant.FoodDelivery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.FoodDelivery.Model.*;
import restaurant.FoodDelivery.Repository.IAaccess;
import restaurant.FoodDelivery.Repository.IAdmin;
import restaurant.FoodDelivery.Repository.IFoodItem;
import restaurant.FoodDelivery.Repository.IOrder;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    IAdmin AdminRepository;
    @Autowired
    IAaccess adminAccess;
    @Autowired
    IFoodItem IFoodItem;

    @Autowired
    AuthenticationService authenticationservice;
    @Autowired
    IOrder OrderRepository;


    //adminSignUp
    public String SignUp(Admin admin){
        Admin existingAdmin=AdminRepository.findByAdminEmail(admin.getAdminEmail());
        if(existingAdmin.getAdminEmail()!=null) return "Email already exists";

        AdminRepository.save(admin);
        return "account created";
    }


    //AdminSignIn

    public String AdminSignIn(String Email,String Password){
        Admin existingAdmin=AdminRepository.findByAdminEmail(Email);
        if(existingAdmin.getAdminEmail()==null) return "Admin doesn't exists";
        else if(existingAdmin.getAdminPassword() != Password) return "invalid credentials";
        AdminAccess Token =new AdminAccess(existingAdmin);
        adminAccess.save(Token);
        return Token.getTokenId();
    }


    //adminUpdate
    public Admin UpdateAdmin(Admin admin){
        Admin existingadmin=AdminRepository.findByAdminEmail(admin.getAdminEmail());
        existingadmin.setAdminName(admin.getAdminName());

        existingadmin.setAdminPassword(admin.getAdminPassword());


        AdminRepository.save(existingadmin);
        return existingadmin;
    }


    public String AddFoodItem(FoodItem items){
        IFoodItem.save(items);

        return "added";
    }

    public List<FoodItem> getFoodItems(){
        return IFoodItem.findAll();
    }
    public String DeleteItem(Long Id){
        IFoodItem.deleteById(Id);
        return "Deleted";
    }

    public FoodItem UpdateItem(FoodItem Item){
        FoodItem existingItem= IFoodItem.findByFoodId(Item.getFoodId());
        existingItem.setName(Item.getName());
        existingItem.setDescription(Item.getDescription());
        existingItem.setPrice(Item.getPrice());
        return existingItem;

    }

    public String RemoveToken(String TokenNo){
        return authenticationservice.DeleteToken(TokenNo);
    }

    public Optional<Order> GetOrderById(Long Id){
        return OrderRepository.findById(Id);
    }
}
