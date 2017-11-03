package nl.carpago.tourofheroes.security.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import nl.carpago.tourofheroes.domain.Hero;

@Repository
public class HeroesRepository {
   
   
   private Map<Long, Hero> heroes = new HashMap<Long, Hero>();
   
   @PostConstruct
   public void init() {
      for(int i = 0;i<5;i++) {
         Hero hero = new Hero();
         hero.setId(Double.valueOf(Math.random()* 10000).intValue());
         hero.setName("Hero name "+hero.getId());
         this.heroes.put(hero.getId(), hero);
      }
      
   }
   
   public Iterable<Hero> findAll() {
      return this.heroes.values();
   }

   public Hero findById(long id) {
      
      return this.heroes.get(id);
   }

   public void deleteById(Long id) {
      this.heroes.remove(id);
   }

   public void update(Long id, Hero invalue) {
      
      Hero hero = this.heroes.get(id);
      hero.setName(invalue.getName());
      
      
   }

   public Hero insert(final Hero heroIn) {
      
      long id = Double.valueOf(Math.random() * 10000).longValue();
      Hero hero = new Hero();
      hero.setId(id);
      hero.setName(heroIn.getName());
      
      this.heroes.put(id, hero);
      
      return hero;
      
   }

}
