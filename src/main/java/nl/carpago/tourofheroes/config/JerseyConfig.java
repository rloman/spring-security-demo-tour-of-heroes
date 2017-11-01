package nl.carpago.tourofheroes.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import nl.carpago.tourofheroes.rest.HeroesEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
   
   public JerseyConfig() {
      
      register(HeroesEndpoint.class);
      
   }
   
   @Bean
   public CorsFilter corsFilter() {
      
       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       CorsConfiguration config = new CorsConfiguration();
       
       config.setAllowCredentials(true);
       config.addAllowedOrigin("*");
       config.addAllowedHeader("*");
       config.addAllowedMethod("OPTIONS");
       config.addAllowedMethod("GET");
       config.addAllowedMethod("POST");
       config.addAllowedMethod("PUT");
       config.addAllowedMethod("DELETE");
       source.registerCorsConfiguration("/**", config);
       
       return new CorsFilter(source);
   }
   
}
