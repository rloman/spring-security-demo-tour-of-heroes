package nl.carpago.tourofheroes.security.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import nl.carpago.tourofheroes.model.security.Authority;
import nl.carpago.tourofheroes.model.security.AuthorityName;
import nl.carpago.tourofheroes.model.security.User;

@Component
public class UserRepository {
   
   private List<User> userlist = new ArrayList<>();
   
   @PostConstruct
   public void setUp() {
      User user = new User();
      user.setId(3L);
      user.setUsername("<your user id>");
      user.setPassword("<set password here based on bcrypt using: https://www.dailycred.com/article/bcrypt-calculator");
      
      Authority a = new Authority();
      a.setId(3L);
      a.setName(AuthorityName.ROLE_ADMIN);
      a.setUsers(Arrays.asList(user));
      
      user.setAuthorities(Arrays.asList(a));
      
      this.userlist.add(user);
   }
   
    public User findByUsername(String username) {
       for(User element : this.userlist) {
          if(element.getUsername().equals(username)) {
             return element;
          }
       }
       
       return null;
    }
}
