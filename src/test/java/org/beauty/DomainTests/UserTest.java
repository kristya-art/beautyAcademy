package org.beauty.DomainTests;

import org.beauty.bea1.domain.Role;
import org.beauty.bea1.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.validation.constraints.Null;
import java.util.Collections;
import java.util.Set;

public class UserTest {

    @Test
    public void UserTest(){

        User dummyUser = new User("Henry", "Denis", "henry.denis@gmail.com","henryhenry");



        Assert.assertEquals("Henry", dummyUser.getName());
        Assert.assertEquals("Denis",dummyUser.getUsername());
        Assert.assertEquals("henry.denis@gmail.com",dummyUser.getEmail());


        dummyUser.setRoles(Collections.singleton(Role.ADMIN));

        Assert.assertTrue(dummyUser.getRoles().contains(Role.ADMIN));

    }
}
