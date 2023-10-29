package restaurant.FoodDelivery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.FoodDelivery.Repository.IToken;

@Service
public class AuthenticationService {
@Autowired
    IToken TokenRepository;

    public String DeleteToken(String TokenNo){
        TokenRepository.deleteByTokenId(TokenNo);
        return "Token Deleted";
    }


}
