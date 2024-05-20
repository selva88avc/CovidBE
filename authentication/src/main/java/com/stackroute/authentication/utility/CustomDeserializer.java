package com.stackroute.authentication.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.authentication.model.Credentials;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CustomDeserializer implements Deserializer<Credentials> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    private Logger logger= LoggerFactory.getLogger(CustomDeserializer.class);

    @Override
    public Credentials deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), Credentials.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Credentials");
        }
    }

    @Override
    public void close() {
    }
}