package org.bea.bea.model;

import javax.persistence.*;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topic_id")
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private Course course;

    public Topic() {
    }

    public Topic(String title, String description, Course course) {
        this.title = title;
        this.description = description;
        this.course = course;
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
