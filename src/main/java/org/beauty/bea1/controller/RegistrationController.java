package org.beauty.bea1.controller;

import org.beauty.bea1.domain.User;
import org.beauty.bea1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";

    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object>model ){


        if(!userService.addUser(user)) {
            model.put("message", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
       boolean isActivated = userService.activateUser(code);
       // boolean isActivated = userService.addUser(user);

        if(isActivated){
            model.addAttribute("message","User successfully activated");
        }else{model.addAttribute("message", "Activation code is not found!");}
        return "login";
    }

}
