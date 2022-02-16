package com.fender.authorizeservice.service;

import com.fender.authorizeservice.dal.entity.UserEntity;
import com.fender.authorizeservice.dal.repository.UserRepository;
import com.fender.authorizeservice.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // User Registration
    @Transactional
    public User createUser (User user) throws Exception {
        checkUserNotNull(user);

        UserEntity findUserEntity = userRepository.findById(user.getId()).orElse(null);

        if (findUserEntity != null) {
            throw new Exception("User already exists");
        }

        userRepository.save(new UserEntity(user.getName(),user.getEmail(),user.getPassword()));

        return user;
    }

    // Login User - token based
    @Transactional
    public String login (String name, String password) throws Exception {
        UserEntity userEntity = userRepository.findByNameAndPassword(name, password).orElse(null);


        if (userEntity == null) {
            throw new Exception("User does not exist.");
        }

        String token = UUID.randomUUID().toString();
        userEntity.setToken(token);
        userRepository.save(userEntity);
        return token;
    }

    // Logout User - token based
    @Transactional
    public boolean logout (User user) throws Exception {
        UserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null) {
            throw new Exception("User does not exist.");
        }

        userEntity.setToken(StringUtils.EMPTY);
        userRepository.save(userEntity);
        return true;
    }

    // Update User
    @Transactional
    public User updateUser (User user) throws Exception {
        checkUserNotNull(user);

        UserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null) {
            throw new Exception("User does not exist.");
        }

        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());

        userRepository.save(userEntity);

        return user;
    }

    @Transactional
    public boolean deleteUser (User user) throws Exception {
        checkUserNotNull(user);

        UserEntity userEntity = userRepository.findById(user.getId()).orElse(null);

        if (userEntity == null) {
            throw new Exception("User does not exist.");
        }

        userRepository.delete(userEntity);
        return true;
    }

    private void checkUserNotNull (User user) throws Exception {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new Exception("A user requires a name, an email, and a password");
        }
    }
}
