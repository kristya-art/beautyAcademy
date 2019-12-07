package org.bea.bea.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Participant extends User{

  //  @ManyToMany()
  //  private Collection<Course> courses = new HashSet<>();


    public Participant() {
    }

    public Participant(String name, String username, String email, String password) {
        super(name, username, email, password);
   //     this.courses = courses;
    }



//    public void removeCourse(Course course) {
//        courses.remove(course);
//    }
//
//    public void addCourse(Course course) {
//        courses.add(course);
    }
