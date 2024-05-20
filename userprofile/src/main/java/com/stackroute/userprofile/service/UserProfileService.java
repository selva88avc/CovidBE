package com.stackroute.userprofile.service;

import com.stackroute.userprofile.model.Credentials;
import com.stackroute.userprofile.model.User;
import com.stackroute.userprofile.model.UserProfile;
import com.stackroute.userprofile.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String,Credentials> kafkaTemplate;

    private Logger logger= LoggerFactory.getLogger(UserProfileService.class);
    private String topic="credtopic";
    /*
    Method to trigger kafka send
     */
    public User saveProfile(UserProfile userProfile) {
        // Send location using kafka send() providing appropriate topic name
        User user = getUser(userProfile);
        User savedUser = userRepository.save(user);
        this.logger.info("successfully saved");
        kafkaTemplate.send(topic, getCredentials(userProfile,savedUser.getId()));
        this.logger.info("credentials sent");
        return savedUser;
    }

    private static Credentials getCredentials(UserProfile userProfile, Integer id) {
        return new Credentials(id,userProfile.getUsername(),userProfile.getPassword());
    }
    private static User getUser(UserProfile userProfile) {
       User user = new User();
       user.setFirstName(userProfile.getFirstName());
       user.setLastName(userProfile.getLastName());
       user.setEmail(userProfile.getEmail());
       user.setAddress1(userProfile.getAddress1());
       user.setAddress2(userProfile.getAddress2());
       user.setCity(userProfile.getCity());
       return user;
    }

    private static User updateUserValues(UserProfile userProfile, User user) {
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setEmail(userProfile.getEmail());
        user.setAddress1(userProfile.getAddress1());
        user.setAddress2(userProfile.getAddress2());
        user.setCity(userProfile.getCity());
        return user;
    }

    public User updateProfile(UserProfile userProfile, Integer id) {
        User user = userRepository.findById(id).get();
        User updatedUser = updateUserValues(userProfile,user);
        User savedUser = userRepository.save(updatedUser);
        this.logger.info("successfully updated");
        kafkaTemplate.send(topic, getCredentials(userProfile,savedUser.getId()));
        this.logger.info("credentials sent");
        return savedUser;
    }
}
