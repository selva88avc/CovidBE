package com.stackroute.authentication.exception;

public class CredentialsNotMatchingException extends RuntimeException{
    public  CredentialsNotMatchingException(String msg){
        super(msg);
    }
}
