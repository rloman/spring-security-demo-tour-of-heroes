package nl.carpago.tourofheroes.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import nl.carpago.tourofheroes.rest.HeroesEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
   
   public JerseyConfig() {
      
      register(HeroesEndpoint.class);
   }
}
