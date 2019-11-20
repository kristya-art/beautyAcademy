package org.beauty;

import org.beauty.bea1.domain.Role;
import org.beauty.bea1.domain.User;
import org.beauty.bea1.repository.UserRepo;
import org.beauty.bea1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataLoader implements ApplicationRunner {


    private final UserRepo userRepo;

    @Autowired
    public DataLoader(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User katy = new User("mike","mike","mike@gmal.com","mike");
        katy.setRoles(Collections.singleton(Role.ADMIN));
        katy.setActive(true);
        userRepo.save(katy);
    }
}
