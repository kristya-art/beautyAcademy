package org.bea.bea.service;

import org.bea.bea.model.Course;
import org.bea.bea.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private CourseRepository courseRepository;


    public CourseService() {
    }


    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    public Course findCourse(Long id) throws CourseNotFoundException{
        log.info("Finding course with id {}", id);
        Course course = courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        return course;
    }
}
