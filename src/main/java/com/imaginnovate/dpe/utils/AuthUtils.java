package com.imaginnovate.dpe.utils;

import com.imaginnovate.dpe.entities.ApplicationUser;
import com.imaginnovate.dpe.exceptions.UserNotFoundException;

import com.imaginnovate.dpe.services.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;


import java.security.Principal;
import java.security.Security;

@RequestScoped
public class AuthUtils {

    @Inject
    private UserService userService;
    @Context
    SecurityContext securityContext;

public ApplicationUser getLoggedInUser() throws UserNotFoundException{
    Principal principal = securityContext.getUserPrincipal();
    String username= principal.getName();
    System.out.println("debug username: "+username);
    ApplicationUser applicationUser = userService.getUserByUsername(username);
    if(applicationUser == null)
        throw new UserNotFoundException();
    return applicationUser;
}
}
