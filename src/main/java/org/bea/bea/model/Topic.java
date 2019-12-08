package org.bea.bea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topic_id")
    private Long id;

    private String title;
    private String description;

    @ManyToOne(targetEntity=Course.class)
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "topic",targetEntity = Lesson.class,cascade = CascadeType.ALL)
    Collection<Lesson> lessons = new HashSet<>();

    public Topic() {
    }

    public Topic(String title, String description, Course course) {
        this.title = title;
        this.description = description;
        this.course = course;
        course.addTopic(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
