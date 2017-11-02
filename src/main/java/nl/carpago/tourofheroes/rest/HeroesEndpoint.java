package nl.carpago.tourofheroes.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.carpago.tourofheroes.domain.Hero;

@RestController
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
   

   @RequestMapping(value = "heroes", method = RequestMethod.GET)
   public Iterable<Hero> list() {
      // Iterable<Adres> result = this.adresService.findAll();

      return this.heroes;
   }

}
