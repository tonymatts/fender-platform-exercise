package com.fender.authorizeservice.controller;

import com.fender.authorizeservice.model.User;
import com.fender.authorizeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    //    User Registration
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public User createUser (@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }

    //    Login (token based)
    @RequestMapping(value = "/login/{name}/{password}", method = RequestMethod.PUT)
    public String login (@PathVariable String name, @PathVariable String password) throws Exception {
        return userService.login(name, password);
    }

    //    Logout - logs a user out
    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    public boolean logout (@RequestBody User user) throws Exception {
        return userService.logout(user);
    }

    //    Update a User's Information
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public User updateUser (@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

    //    Delete a User
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public boolean deleteUser (@RequestBody User user) throws Exception {
        return userService.deleteUser(user);
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public void healthCheck () throws Exception {
        System.out.println("service is healthy");
    }
}
