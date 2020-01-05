package org.bea.bea.model;

import com.fasterxml.jackson.databind.Module;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Participant extends User {

    @ManyToMany()
    private Collection<Course> courses = new HashSet<>();

    Set<Role> roles = new HashSet<>();

    //Role role = new Role(RoleName.ROLE_PARTICIPANT);


    public Participant() {
        super();
    }


    public Participant(String name, String username, String email, String password) {
        super(name, username, email, password);
        // this.addRole(role);

    }

    public Participant(String name, String username, String email, String password,
                       Set<Course> courses
    ){
        super(name, username, email,password);
        this.courses= courses;
        this.addCourses(courses);

    }


    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addCourses(Collection<Course> courses){
        this.courses=courses;
    }

    public Collection<Course> getCourses() {
        return courses;
    }
}
