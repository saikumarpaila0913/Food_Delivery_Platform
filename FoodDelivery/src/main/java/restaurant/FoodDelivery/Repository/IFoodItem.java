package restaurant.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.FoodDelivery.Model.FoodItem;

public interface IFoodItem extends JpaRepository<FoodItem,Long> {




    FoodItem findByFoodId(Long id);
}
