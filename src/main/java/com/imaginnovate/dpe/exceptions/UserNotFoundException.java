package com.imaginnovate.dpe.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("User not found");
    }
}

