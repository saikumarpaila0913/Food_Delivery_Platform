package restaurant.FoodDelivery.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AdminId;
    private String AdminName;
    @Pattern(regexp ="^.*@admin\\.com$")
    @Column(name = "adminEmail")
    private String adminEmail;
    @Pattern(regexp ="^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$")
    private String adminPassword;
}
