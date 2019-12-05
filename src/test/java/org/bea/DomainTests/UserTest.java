package org.bea.DomainTests;

import org.bea.bea.model.Role;
import org.bea.bea.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.bea.bea.model.RoleName.ROLE_USER;

public class UserTest {

    @Test
    public void UserTest(){

        User dummyUser = new User("Tom", "Peter", "tom@gmail.com","tomtom");



        Assert.assertEquals("Tom", dummyUser.getName());
        Assert.assertEquals("Peter",dummyUser.getUsername());
        Assert.assertEquals("tom@gmail.com",dummyUser.getEmail());



        Set<Role> roles = new HashSet<>();
        Role role = new Role(ROLE_USER);
        roles.add(role);
        dummyUser.setRoles(roles);
        Assert.assertTrue(dummyUser.getRoles().contains(role));
       // System.out.println(role.getName());
        Assert.assertEquals(role.getName(),ROLE_USER);
    }
}
