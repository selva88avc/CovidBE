package com.stackroute.authentication.config;


import com.stackroute.authentication.model.Credentials;
import com.stackroute.authentication.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @Autowired
    AuthenticationService authenticationService;

    private Logger logger= LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics="credtopic",groupId="cred-group")
    public void saveCredentials(Credentials credentials){
        this.logger.info(credentials.toString());
        authenticationService.saveCredentials(credentials);
    }

}
