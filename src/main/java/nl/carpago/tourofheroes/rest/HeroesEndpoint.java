package nl.carpago.tourofheroes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.carpago.tourofheroes.domain.Hero;
import nl.carpago.tourofheroes.service.HeroesService;

@RestController
@RequestMapping("heroes")
public class HeroesEndpoint {
   
   @Autowired
   private HeroesService service;
   

   @RequestMapping(value = "", method = RequestMethod.GET)
   public Iterable<Hero> list() {

      return this.service.findAll();
   }
   
   @RequestMapping(value="/{id}", method=RequestMethod.GET)
   public Hero getById(@PathVariable long id){ 
      
      return this.service.findById(id);
      
   }
   
   @RequestMapping(method=RequestMethod.POST)
   public Hero insert(@RequestBody Hero heroIn) {
     
      return this.service.insert(heroIn);
   }
   
   @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
   public void deleteById(@PathVariable long id){
      
      this.service.deleteById(id);
   }
   
   @RequestMapping(value="/{id}", method=RequestMethod.PUT)
   public void putById(@PathVariable long id, @RequestBody Hero hero) {
      
      this.service.update(id, hero);
   }
}
