package com.imaginnovate.dpe.services;

import com.imaginnovate.dpe.entities.ApplicationUser;
import com.imaginnovate.dpe.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Date;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public ApplicationUser getUserByUsername(String username) {
        if (username == null || username.isBlank() || username.isEmpty()) return null;
        return userRepository.findByUserName(username);
    }

    @Transactional
    public ApplicationUser createUser(String username, String firstName, String lastName, String email) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserName(username);
        applicationUser.setEmail(email);
        applicationUser.setFirstName(firstName);
        applicationUser.setLastName(lastName);
        applicationUser.setCreatedAt(new Date());
        applicationUser.setUpdatedAt(new Date());
        userRepository.persist(applicationUser);
        return applicationUser;
    }
}