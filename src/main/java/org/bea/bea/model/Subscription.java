package org.bea.bea.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscription_id")
    private Long id;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    Date date;

    @OneToMany(cascade=CascadeType.ALL)
    private Collection<Course> courses;

    @OneToMany(cascade=CascadeType.ALL)
    private Collection<Participant> participants;

    public Subscription() {
    }

    public Subscription(Date date) {
        this.date = date;
        courses=new HashSet<>();
        participants=new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void addCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void removeCourse(Course course){
        courses.remove(course);
    }

    public Collection<Participant> getParticipants() {
        return participants;
    }

    public void addParticipants(Collection<Participant> participants) {
        this.participants = participants;
    }
    public void addParticipant(Participant participant){
        participants.add(participant);
    }
    public void removeParticipant(Participant participant){
        participants.remove(participant);
    }
}
