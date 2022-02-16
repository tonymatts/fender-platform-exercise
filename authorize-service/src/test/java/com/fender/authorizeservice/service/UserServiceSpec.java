package com.fender.authorizeservice.service;

import com.fender.authorizeservice.dal.repository.UserRepository;
import com.fender.authorizeservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = "classpath:user-bean-config.xml")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceSpec {

    @Mock
    UserRepository userRepositoryMock;

    UserService userService;


    @Test
    public void createUser_IsSuccessful () throws Exception {
        // given
        Assertions.assertNotNull(userRepositoryMock);
        userService = new UserService(userRepositoryMock);
        User newUser = new User("name", "me@email.com", "Test123!");

        // when
        User result = userService.createUser(newUser);

        // then
        Assertions.assertNotNull(result);
    }
}
