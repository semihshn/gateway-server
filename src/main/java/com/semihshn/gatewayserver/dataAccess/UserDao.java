package com.semihshn.gatewayserver.dataAccess;

import com.semihshn.gatewayserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
