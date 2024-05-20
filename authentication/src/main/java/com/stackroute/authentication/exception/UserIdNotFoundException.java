package com.stackroute.authentication.exception;

public class UserIdNotFoundException extends RuntimeException{
    public  UserIdNotFoundException(String msg){
        super(msg);
    }
}