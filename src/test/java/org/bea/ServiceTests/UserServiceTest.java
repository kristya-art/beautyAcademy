package org.bea.ServiceTests;

import org.bea.bea.model.Role;
import org.bea.bea.model.User;
import org.bea.bea.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bea.bea.model.RoleName.ROLE_ADMIN;
import static org.bea.bea.model.RoleName.ROLE_USER;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void persistTest() {
        User dummyUser = new User("Tom", "Peter", "tom@gmail.com", "tomtom");
        Set<Role> roles = new HashSet<>();
        Role role = new Role(ROLE_ADMIN);
        roles.add(role);
        dummyUser.setRoles(roles);


        userService.saveUser(dummyUser);
        assertThat(dummyUser.getId()).isNotNull();
    }
      @Test
      public void testCreation(){




    }



}
