package org.bea.bea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long id;

    private String code;
    private String title;
    private String description;
    private int points;

    @JsonIgnore
    @OneToMany(mappedBy = "course",targetEntity = Topic.class)
    private Collection<Topic> topics;

//    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
//    private Collection<Participant> participants;





    public Course(){}

    public Course(String code, String title, String description, int points) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.points = points;

        topics=new HashSet<>();

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Collection<Topic> getTopics() {
        return topics;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void removeTopic(Topic topic){
        topics.remove(topic);
    }







}
