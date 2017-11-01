package nl.carpago.tourofheroes.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import nl.carpago.tourofheroes.domain.Hero;


@Path("heroes")
@Component
@CrossOrigin
public class HeroesEndpoint {
   
   private List<Hero> heroes = new ArrayList<>();
   
   @PostConstruct
   public void init() {
      for(int i = 0;i<5;i++) {
         Hero hero = new Hero();
         hero.setId(Double.valueOf(Math.random()* 1000).intValue());
         hero.setName("Hero name "+hero.getId());
         this.heroes.add(hero);
      }
      
   }
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response list() {
      // Iterable<Adres> result = this.adresService.findAll();

      return Response.ok(this.heroes).build();
   }

}
