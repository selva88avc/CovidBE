package com.stackroute.authentication.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.authentication.model.Credentials;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CustomSerializer implements Serializer<Credentials> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Logger logger= LoggerFactory.getLogger(CustomSerializer.class);

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Credentials data) {
        try {
            if (data == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing Credentials to byte[]");
        }
    }

    @Override
    public void close() {
    }
}