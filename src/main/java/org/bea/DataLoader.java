package org.bea;

import org.bea.bea.model.Role;
import org.bea.bea.model.RoleName;
import org.bea.bea.model.User;
import org.bea.bea.repository.RoleRepository;
import org.bea.bea.repository.UserRepository;

import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private RoleRepository roleRepository;

    private final UserRepository userRepo;

    @Autowired
    private  UserService userService;

    @Autowired
    public DataLoader(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role1 = new Role(RoleName.ROLE_ADMIN);
        Role role2 = new Role(RoleName.ROLE_LECTURER);
        Role role3 = new Role(RoleName.ROLE_USER);
        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);

        User steve = new User("steve","steve","steve@gmal.com","stevesteve");
        Set<Role> roles = new HashSet<>();

       // userRepo.save(steve);
        Role role = new Role(RoleName.ROLE_ADMIN);
        roles.add(role);
        steve.setRoles(roles);
        steve.setActive(true);
        userService.saveUser(steve);
    }
}
