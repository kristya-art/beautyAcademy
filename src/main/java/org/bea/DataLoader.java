package org.bea;

import org.bea.bea.controller.CourseController;
import org.bea.bea.model.*;
import org.bea.bea.repository.RoleRepository;
import org.bea.bea.repository.SubscriptionRepository;
import org.bea.bea.repository.UserRepository;

import org.bea.bea.service.CourseService;
import org.bea.bea.service.TopicService;
import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.mail.Part;
import java.util.*;

import static org.bea.bea.model.RoleName.ROLE_ADMIN;
import static org.bea.bea.model.RoleName.ROLE_USER;

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
    private SubscriptionRepository subscriptionRepository;

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


        Participant mike = new Participant("mike", "mike","mike@gmail.com","mikemike");
        mike.addRole(new Role(ROLE_USER));
        userService.saveUser(mike);


       Course course = new Course("4536","Beauty-course", "beauty",45);
       courseService.saveCourse(course);

       Topic topic = new Topic("Body-beauty","description",course);
       course.addTopic(topic);
       courseService.saveCourse(course);
       // courseController.addTopic(course,topic);

       Course course2 = new Course("8990", "Beauty-instructor", "this course is for you, who want to become a " +
               "beauty instructor. To make this course you have to ...", 55 );

       Collection<Topic> topics =new HashSet<>();
       Topic t=new Topic("Moda 2020", "this topic is about how to choose the right clothes for different type of person",course2);
        Topic t2 =new Topic("Body care", "this topic is about how to be fit and beautifu, and how to motivate other to do it",course2);
        Topic t3 = new Topic("Make-up artist","this topic everything about make-up, ..",course2);

        courseService.saveCourse(course2);

        Collection<Participant> collection = new HashSet<>();

        Date date = new Date(2019/11/3);
        Date date2 = new Date(2019/11/17);
        collection.add(mike);
        Subscription subscription = new Subscription(collection,course,date,date2);

       subscription.addParticipants(collection);
        subscriptionRepository.save(subscription);
        System.out.println(subscription.getParticipants());
        System.out.println(collection);

        System.out.println(subscription.getCourse());


        Participant kat = new Participant("kat", "kat","kat@gmail.com","katkat");

        kat.addCourse(course);
        userService.saveUser(kat);

        System.out.println(kat.getCourses());


    }
}
