package nl.carpago.tourofheroes.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero implements Serializable {
   
   private static final long serialVersionUID = -5381333016442974025L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   
   private String name;
   
   public long getId() {
      return id;
   }
   
   public void setId(long id) {
      this.id = id;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
}
