package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.ApplicationUser;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<ApplicationUser> {

   public ApplicationUser findByUserName(String username){
        return find("userName = ?1",username).firstResult();
    }

}