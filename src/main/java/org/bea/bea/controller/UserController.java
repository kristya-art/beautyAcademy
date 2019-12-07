package org.bea.bea.controller;

import org.bea.bea.model.User;
import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@PreAuthorize("hasAuthority('ROLEADMIN')")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/list")
    public List<User> listUsers(){return userService.listUsers();}

    @PostMapping("/delete")
    public void deleteUser(@RequestBody User user){userService.deleteUser(user);}


}
