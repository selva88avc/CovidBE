package com.stackroute.authentication.service;

import com.stackroute.authentication.config.JWTTokenGenerator;
import com.stackroute.authentication.exception.CredentialsNotMatchingException;
import com.stackroute.authentication.exception.UserIdNotFoundException;
import com.stackroute.authentication.model.Credentials;
import com.stackroute.authentication.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private JWTTokenGenerator tokenGenerator;
    @Override
    public Map<String,String> generateToken(Credentials credentials) {
        Credentials user = credentialsRepository.findByUsername(credentials.getUsername());
        if(credentials!=null && user.getPassword().equals(credentials.getPassword())) {
            credentials.setUserId(user.getUserId());
            return tokenGenerator.generateToken(credentials);
        } else {
            throw new CredentialsNotMatchingException("Not Matched");
        }
    }

    @Override
    public void saveCredentials(Credentials credentials) {
        Optional<Credentials> savedCredentialsOptional = credentialsRepository.findById(credentials.getUserId());
        if(savedCredentialsOptional.isPresent()) {
            Credentials savedCredentials = savedCredentialsOptional.get();
            savedCredentials.setPassword(credentials.getPassword());
            credentialsRepository.save(savedCredentials);
        } else {
            credentialsRepository.save(credentials);
        }

    }
}
