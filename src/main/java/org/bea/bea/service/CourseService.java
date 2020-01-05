package org.bea.bea.service;

import org.bea.bea.model.Course;
import org.bea.bea.model.Subscription;
import org.bea.bea.repository.CourseRepository;
import org.bea.bea.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;


    public CourseService() {
    }


    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

//    public void deleteCourse(Course course) {
//        courseRepository.delete(course);
//    }

    public void deleteCourse(Long id)throws CourseNotFoundException{
        Course course = courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
//        List<Subscription> subscriptions = subscriptionRepository.findAll().stream()
//                .filter(subscription -> subscription.getCourse()==course).collect(Collectors.toList());
//
//        for(Subscription s: subscriptions){
//       subscriptionRepository.delete(s);}


        courseRepository.delete(course);


    }
    public Course findCourse(Long id) throws CourseNotFoundException{
        log.info("Finding course with id {}", id);
        Course course2 = courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        return course2;
    }

    public Course updateCourse(Course course)throws CourseNotFoundException{
          return courseRepository.save(course);

    }
}
