package org.bea;

import org.bea.bea.controller.CourseController;
import org.bea.bea.model.*;
import org.bea.bea.repository.RoleRepository;
import org.bea.bea.repository.UserRepository;

import org.bea.bea.service.CourseService;
import org.bea.bea.service.TopicService;
import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.bea.bea.model.RoleName.ROLE_ADMIN;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CourseController courseController;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private final UserRepository userRepo;

    @Autowired
    private  UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TopicService topicService;

    @Autowired
    public DataLoader(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role1 = new Role(ROLE_ADMIN);
        Role role2 = new Role(RoleName.ROLE_LECTURER);
        Role role3 = new Role(RoleName.ROLE_USER);
        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);

        User steve = new User("steve","steve","steve@gmal.com","stevesteve");
        Set<Role> roles = new HashSet<>();
        Role role = new Role(ROLE_ADMIN);
        roles.add(role);

       steve.setRoles(roles);

       userService.saveUser(steve);


       Course course = new Course("4536","Beauty-course", "beauty",45);
       courseService.saveCourse(course);

       Topic topic = new Topic("Body-beauty","description",course);
      // topicService.saveTopic(topic);
       course.addTopic(topic);
       courseService.saveCourse(course);

       // courseController.addTopic(course,topic);

       System.out.println(course.getTopics());


    }
}
