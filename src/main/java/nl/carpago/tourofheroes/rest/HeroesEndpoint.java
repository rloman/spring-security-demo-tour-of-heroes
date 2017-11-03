package nl.carpago.tourofheroes.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.carpago.tourofheroes.domain.Hero;
import nl.carpago.tourofheroes.security.repository.HeroesRepository;

@RestController
@RequestMapping("heroes")
public class HeroesEndpoint {
   
   @Autowired
   private HeroesRepository repository;
   

   @RequestMapping(value = "", method = RequestMethod.GET)
   public Iterable<Hero> list() {

      return this.repository.findAll();
   }
   
   @RequestMapping(value="{id}", method=RequestMethod.GET)
   public Hero getById(@PathParam("id") long id){ 
      
      return this.repository.findById(id);
      
   }

}
