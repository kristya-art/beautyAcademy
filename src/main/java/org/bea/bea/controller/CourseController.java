package org.bea.bea.controller;

import org.bea.bea.model.Course;
import org.bea.bea.model.Topic;
import org.bea.bea.model.User;
import org.bea.bea.repository.CourseRepository;
import org.bea.bea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository repository;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/save")
    public void saveCourse(@RequestBody Course course){
        courseService.saveCourse(course);
    }

    @PostMapping("/list")
    public List<Course> listCourses(){return courseService.listCourses();}

//    @PostMapping("/delete")
//    public void deleteCourse(@RequestBody Course course){courseService.deleteCourse(course);}

    @DeleteMapping("/cancel/{id}")
    public void cancelCourse(@PathVariable Long id)throws CourseNotFoundException {
     courseService.deleteCourse(id);
    }
//    @PostMapping("/save")
//    public void addCourse(Course course){
//        courseService.saveCourse(course);
//    }

    @PostMapping("/create")
    public Course createCourse(@Valid @RequestBody Course course){
        return courseService.saveCourse(course);
    }
    @PostMapping("/addTopic")
    public void addTopic(Course course, Topic topic) {
        course.addTopic(topic);
        courseService.saveCourse(course);

    }
    @GetMapping("/list")
    public List<Course> allCourses(){ return  courseService.listCourses();}

    @GetMapping("{id}")
    public Course findCourse(@PathVariable Long id) throws CourseNotFoundException {
        return courseService.findCourse(id);
    }

//    @PutMapping("/update/{id}")
//    public Course updateCourse(@RequestBody Course course,@PathVariable Long id)throws  CourseNotFoundException{
//        course = courseService.findCourse(id);
//      return courseService.updateCourse(course);
//
//
//    }


    @PutMapping("/update/{id}")
    Course update(@RequestBody Course newCourse, @PathVariable Long id) {

        return repository.findById(id)
                 .map(course -> {
            course.setCode(newCourse.getCode());
            course.setTitle(newCourse.getTitle());
            course.setDescription(newCourse.getDescription());
            course.setPoints(newCourse.getPoints());
            course.setTopics(newCourse.getTopics());
            return  courseRepository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return courseRepository.save(newCourse);
                });
    }


    }

