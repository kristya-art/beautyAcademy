package org.beauty.bea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

@RequestMapping("/hello")
    public String sayHi(){
       return "Hi, I am a new application:) !";
    }
}
