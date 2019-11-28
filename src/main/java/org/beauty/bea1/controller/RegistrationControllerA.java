package org.beauty.bea1.controller;

import org.beauty.bea1.domain.User;
import org.beauty.bea1.messages.ResponseMessage;
import org.beauty.bea1.messages.request.LoginForm;
import org.beauty.bea1.repository.UserRepo;
import org.beauty.bea1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("/api/auth")
public class RegistrationControllerA {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {


        if(!userService.addUser(user))
        { return  new  ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use"),
                HttpStatus.BAD_REQUEST) ;
        }
        return new ResponseEntity<>(new ResponseMessage("Now you have to check your email , there you" +
                "can find a link with activation code"), HttpStatus.OK);
    }

    @GetMapping("/activate{code}")
        public ResponseEntity<?> activateUser(@PathVariable String code){
        boolean isActivated = userService.activateUser(code);

        if(isActivated){
            return new ResponseEntity<>(new ResponseMessage("user successfully activated"), HttpStatus.OK);

        }else
            return new ResponseEntity<>(new ResponseMessage("activated code is not found!"),HttpStatus.BAD_REQUEST);
    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest){
//
//    }

}
