package org.beauty.bea1.controller;

import org.beauty.bea1.domain.Role;
import org.beauty.bea1.domain.User;
import org.beauty.bea1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";

    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object>model ){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb !=null) {
            model.put("message", "user exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }

}
