package restaurant.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.FoodDelivery.Model.User;

@Repository
public interface IUser extends JpaRepository<User,Long> {
    User findByUserEmail(String userEmail);
}
