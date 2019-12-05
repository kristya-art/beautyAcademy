package org.bea;



import org.bea.bea.model.Role;
import org.bea.bea.model.User;
import org.bea.bea.repository.MessageRepo;
import org.bea.bea.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.bea.bea.model.RoleName.ROLE_USER;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

   @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepo messageRepo;

    @Test
    public void persistTest(){
        User dummyUser = new User("Henry", "Denis", "henry.denis@gmail.com","henryhenry");

        Set<Role> roles = new HashSet<>();
        Role role = new Role(ROLE_USER);
        roles.add(role);
        dummyUser.setRoles(roles);


        userRepository.save(dummyUser);
        assertThat(dummyUser.getId()).isNotNull();

        assertThat(dummyUser.getRoles()).contains(role);
        System.out.println(dummyUser.getRoles());



    }


}
