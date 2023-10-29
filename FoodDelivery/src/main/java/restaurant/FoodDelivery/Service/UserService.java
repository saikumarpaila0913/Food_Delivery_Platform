package restaurant.FoodDelivery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.FoodDelivery.Model.AuthenticationToken;
import restaurant.FoodDelivery.Model.Order;
import restaurant.FoodDelivery.Model.User;
import restaurant.FoodDelivery.Repository.IOrder;
import restaurant.FoodDelivery.Repository.IToken;
import restaurant.FoodDelivery.Repository.IUser;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUser UserRepository;
    @Autowired
    IToken TokenRepository;

    @Autowired
    IOrder OrderRepository;

    //signup

    public String SignUp(User user){
        User existingUser=UserRepository.findByUserEmail(user.getUserEmail());
        if(existingUser.getUserId()!=null) return "Email already exists";

        UserRepository.save(user);
        return "account created";
    }

    //signin

    public String UserSignIn(String Email,String Password){
        User existingUser=UserRepository.findByUserEmail(Email);
        if(existingUser.getUserEmail()==null) return "User doesn't exists";
        else if(existingUser.getUserPassword() != Password) return "invalid credentials";
        AuthenticationToken Token =new AuthenticationToken(existingUser);
        TokenRepository.save(Token);
        return Token.getTokenId();
    }

    //update user details
    public User UpdateUser(User user){
        User existingUser=UserRepository.findByUserEmail(user.getUserEmail());
          existingUser.setUserName(user.getUserName());
          existingUser.setUserGender(user.getUserGender());
          existingUser.setUserPassword(user.getUserPassword());


          UserRepository.save(existingUser);
          return existingUser;
    }

    public List<Order> OrderHistory(String Email){
       return OrderRepository.findAllByUserUserEmail(Email);
    }
}
