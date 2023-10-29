package restaurant.FoodDelivery.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AdminAccess {



    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String TokenId;
    private LocalDateTime TokenCreationTime;

    @OneToOne
    @JoinColumn(name = "Fk_Admin")
    Admin admin;

    public  AdminAccess(Admin newAdmin){
        this.TokenId= UUID.randomUUID().toString();
        this.TokenCreationTime=LocalDateTime.now();
        this.admin=newAdmin;
    }




}
