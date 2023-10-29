package restaurant.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.FoodDelivery.Model.AdminAccess;

public interface IAaccess extends JpaRepository<AdminAccess,Long> {
}
