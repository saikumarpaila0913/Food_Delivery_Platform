package restaurant.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.FoodDelivery.Model.AuthenticationToken;

@Repository
public interface IToken extends JpaRepository<AuthenticationToken,Long> {
    boolean existsByTokenId(String tokenNo);

    boolean existsByUserUserEmail(String userEmail);

    void deleteByTokenId(String tokenNo);
}
