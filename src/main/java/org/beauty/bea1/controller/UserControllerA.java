package org.beauty.bea1.controller;

import org.beauty.bea1.domain.Role;
import org.beauty.bea1.domain.User;
import org.beauty.bea1.repository.UserRepo;
import org.beauty.bea1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


    @RestController
    @RequestMapping("/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public class UserControllerA {
        @Autowired
        private UserRepo userRepo;

        @Autowired
        private UserService userService;

        @GetMapping("userList")
        public List<User> userList() { return userService.userList();}

//        @GetMapping
//        public String userList(Model model){
//            model.addAttribute("users",userRepo.findAll());
//
//            return "userList";
//        }
//        @GetMapping("{user}")
//        public String userEditForm(@PathVariable User user, Model model){
//            model.addAttribute("user",user);
//            model.addAttribute("roles", Role.values());
//            return "userEdit";
//        }

        @PostMapping("addUser")
        public boolean addUser(@RequestBody User user) {return userService.addUser(user);}
        @PostMapping("save")
        public void saveUser(@RequestBody User user) {userService.saveUser(user);}

//        @PostMapping
//        public String userSave(
//                @RequestParam String username,
//                @RequestParam Map<String,String > form,
//                @RequestParam ("userId")User user)
//        {
//            user.setUsername(username);
//
//            Set<String> roles = Arrays.stream(Role.values())
//                    .map(Role::name)
//                    .collect(Collectors.toSet());
//
//            user.getRoles().clear();
//            for(String key: form.keySet()){
//                if(roles.contains(key)){
//                    user.getRoles().add(Role.valueOf(key));
//                }
//            }
//            userRepo.save(user);
//            return "redirect:/user";
//        }

        @PostMapping("delete")
        public void deleteUser(@RequestBody User user){
            userService.deleteUser(user);
        }

        public UserControllerA() {}
    }







