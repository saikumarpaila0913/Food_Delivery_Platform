package restaurant.FoodDelivery.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "fk_User")
    User user;

    @OneToMany
    @JoinColumn(name = "Fk_Item")
    List<FoodItem> Item;
    public Order(User user, List<FoodItem> Items){
        this.user=user;
        this.Item=Items;
    }

}
