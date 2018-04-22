package services;

/**
 * Created by alex on 12/9/2017.
 */
import entities.User;
import java.util.List;

public class LoginService {
   public String doLogin(String username, String password){
       String message = null;
       System.out.println("\n\n\n\n\n\n\nlogin is called!\n\n\n\n\n\n\n\n");
       try {
           User u = new User();
           List<User> user = u.getValidation(username, password);
           if (user.isEmpty()) {
               message = "FAILURE";
           } else {
               message = "SUCCESS";
           }
       }
       catch(Exception e) {
           message="FΑILURE";
           e.printStackTrace();
       }
    return message;
   }
}
