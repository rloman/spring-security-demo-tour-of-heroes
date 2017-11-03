package nl.carpago.tourofheroes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
   
   @RequestMapping(value="/{id}", method=RequestMethod.GET)
   public Hero getById(@PathVariable Long id){ 
      
      return this.repository.findById(id);
      
   }
   
   @RequestMapping(method=RequestMethod.POST)
   public Hero insert(@RequestBody Hero heroIn) {
     
      return this.repository.insert(heroIn);
   }
   
   @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
   public void deleteById(@PathVariable Long id){
      
      this.repository.deleteById(id);
   }
   
   @RequestMapping(value="/{id}", method=RequestMethod.PUT)
   public void putById(@PathVariable("id") Long id, @RequestBody Hero hero){
      
      this.repository.update(id, hero);
   }
}
