package nl.carpago.tourofheroes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.carpago.tourofheroes.domain.Hero;

@Repository
public interface HeroesRepository extends CrudRepository<Hero, Long> {

}
