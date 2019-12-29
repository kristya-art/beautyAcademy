package org.bea.bea.controller;

import org.bea.bea.model.Course;
import org.bea.bea.model.Topic;
import org.bea.bea.model.User;
import org.bea.bea.repository.CourseRepository;
import org.bea.bea.service.CourseNotFoundException;
import org.bea.bea.service.CourseService;
import org.bea.bea.service.TopicService;
import org.bea.bea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
