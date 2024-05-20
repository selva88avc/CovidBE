package com.stackroute.authentication.config;

import com.stackroute.authentication.model.Credentials;
import java.util.Map;

public interface JWTTokenGenerator {

    Map<String, String> generateToken(Credentials user);
}
