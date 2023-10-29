package restaurant.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.FoodDelivery.Model.Order;

import java.util.List;

@Repository
public interface IOrder extends JpaRepository<Order,Long> {
    void deleteByOrderId(Long orderId);

    List<Order> findAllByUserUserEmail(String email);
}
