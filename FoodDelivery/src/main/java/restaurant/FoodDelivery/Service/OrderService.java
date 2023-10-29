package restaurant.FoodDelivery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.FoodDelivery.Model.FoodItem;
import restaurant.FoodDelivery.Model.Order;
import restaurant.FoodDelivery.Model.User;
import restaurant.FoodDelivery.Repository.IOrder;
import restaurant.FoodDelivery.Repository.IToken;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    IOrder OrderRepository;
    @Autowired
    IToken Token;



    public String newOrder(User user, List<FoodItem>Items){

        if(Token.existsByUserUserEmail(user.getUserEmail())){
            Order newOrder=new Order(user,Items);
            OrderRepository.save(newOrder);

            String result = Items.stream()
                    .map(FoodItem::getName)
                    .collect(Collectors.joining(", "));
            return (result+ " " + "odrer Id:" + newOrder.getOrderId().toString() + " Order Confirmed" );
        }
        return "please Signin before ordering";
    }

    public String CancleOrder(Long OrderId){
        OrderRepository.deleteByOrderId(OrderId);
        return" order cancled";
    }

}
