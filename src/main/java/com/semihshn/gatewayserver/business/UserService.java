package com.semihshn.gatewayserver.business;

import com.semihshn.gatewayserver.dataAccess.UserDao;
import com.semihshn.gatewayserver.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        return userDao.save(user);
    }

    public Optional<User> findByUsername(String username)
    {
        return userDao.findByUsername(username);
    }

    public List<User> findAllUsers()
    {
        return userDao.findAll();
    }

}
