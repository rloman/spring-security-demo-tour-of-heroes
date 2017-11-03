package nl.carpago.tourofheroes.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.carpago.tourofheroes.domain.Hero;
import nl.carpago.tourofheroes.repository.HeroesRepository;

@Service
@Transactional
public class HeroesService {
   
   
   @Autowired
   private HeroesRepository repository;
   
   @PostConstruct
   public void init() {
      for(int i = 0;i<5;i++) {
         Hero hero = new Hero();
         hero.setName("Hero name "+(i+1));
         this.repository.save(hero);
      }
   }
   
   public Iterable<Hero> findAll() {
      return this.repository.findAll();
   }

   public Hero findById(long id) {
      
      return this.repository.findOne(id);
   }

   public void deleteById(long id) {
      this.repository.delete(id);
   }

   public void update(long id, Hero invalue) {
      
      
      Hero victim = this.repository.findOne(id);
      if(victim != null) {
         
         victim.setName(invalue.getName());
         this.repository.save(victim);
      }
   }

   public Hero insert(final Hero heroIn) {
      
     return this.repository.save(heroIn);
   }
}
