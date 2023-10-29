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
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String tokenId;
    private LocalDateTime TokenCreationTime;

    @OneToOne
    @JoinColumn(name = "Fk_User")
    User user;

   public  AuthenticationToken(User newUser){
       this.tokenId= UUID.randomUUID().toString();
       this.TokenCreationTime=LocalDateTime.now();
       this.user=newUser;
   }








}
