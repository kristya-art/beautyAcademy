package org.bea.bea.model;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Lecturer extends User{

//    @ManyToMany
//    public Collection<Course> courses = new HashSet<>();

    public Lecturer(){super();}

    public Lecturer(String name, String username, String email, String password){
        super(name,username,email,password);
    }

//    public void addCourse(Course course) {
//        courses.add(course);
//    }
//
//    public void removeCourse(Course course) {
//        courses.remove(course);
//    }
}
