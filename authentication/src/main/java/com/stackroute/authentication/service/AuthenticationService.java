package com.stackroute.authentication.service;

import com.stackroute.authentication.model.Credentials;

import java.util.Map;

public interface AuthenticationService {
    public Map<String,String> generateToken(Credentials credentials);

    void saveCredentials(Credentials credentials);
}
