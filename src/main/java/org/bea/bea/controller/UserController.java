package org.bea.bea.controller;

import org.bea.bea.model.User;
import org.bea.bea.service.UserNotFoundException;
import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@PreAuthorize("hasAuthority('ROLEADMIN')")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/list")
    public List<User> listUsers(){return userService.listUsers();}

    @PostMapping("/delete")
    public void deleteUser(@RequestBody User user){userService.deleteUser(user);}

    @GetMapping("{id}")
    public User findUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.findUser(id);
    }


}
