package com.stackroute.userprofile.exception;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(String msg){
        super(msg);
    }
}