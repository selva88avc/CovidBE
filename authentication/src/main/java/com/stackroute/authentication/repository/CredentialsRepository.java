package com.stackroute.authentication.repository;

import com.stackroute.authentication.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials,Integer> {
    public Credentials findByUsername(String username);
}
