package org.bea.bea.controller;

import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ActivateUserController {

    @Autowired
    UserService userService;

//    @GetMapping("/activate/{code}")
//    public String activate(Model model, @PathVariable String code){
//        boolean isActivated = userService.activateUser(code);
//        // boolean isActivated = userService.addUser(user);
//
//        if(isActivated){
//            model.addAttribute("message","User successfully activated");
//        }else{model.addAttribute("message", "Activation code is not found!");}
//        return "login";
//    }

}
