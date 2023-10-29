package restaurant.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.FoodDelivery.Model.Admin;

@Repository
public interface IAdmin extends JpaRepository<Admin,Long> {
    Admin findByAdminEmail(String adminEmail);
}
