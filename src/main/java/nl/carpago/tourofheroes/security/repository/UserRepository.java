package nl.carpago.tourofheroes.security.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import nl.carpago.tourofheroes.model.security.Authority;
import nl.carpago.tourofheroes.model.security.AuthorityName;
import nl.carpago.tourofheroes.model.security.User;

/**
 * Created by stephan on 20.03.16.
 */
@Component
public class UserRepository {
   
   private List<User> userlist = new ArrayList<>();
   
   @PostConstruct
   public void setUp() {
      User user = new User();
      user.setId(3L);
      user.setUsername("rloman");
      user.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
      
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
