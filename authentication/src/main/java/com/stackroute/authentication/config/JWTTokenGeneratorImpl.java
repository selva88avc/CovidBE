package com.stackroute.authentication.config;

import com.stackroute.authentication.model.Credentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator {

    /**
     * To get the property values
     */
    @Value("${jwt.secret}")
    private String secret;

    @Value("${app.jwttoken.message}")
    private String message;

    @Override
    public Map<String, String> generateToken(Credentials user) {
        String jwtToken = "";
        /*
         * Generate JWT token and store in String jwtToken
         */
        long expiry = 30_000_00;
        Map<String, Object> userdata = new HashMap<>();

        userdata.put("id", user.getUserId());
        userdata.put("username", user.getUsername());
        jwtToken = Jwts.builder().setClaims(userdata)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiry))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        Map<String, String> jwtTokenMap = new HashMap<>();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", message);
        return jwtTokenMap;
    }
}
