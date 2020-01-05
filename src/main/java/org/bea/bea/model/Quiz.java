package org.bea.bea.model;



import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qId;

    private String name;
    private Date date;
    private int duration;

//    @ManyToOne
//    private IntermediateExam intermediateExam;

    @ColumnDefault("false")
    private boolean isActive;

    @ManyToOne(targetEntity = IntermediateExam.class)
    @JoinColumn(name = "course_id")
    private Course course;

   @OneToMany(mappedBy = "quiz")
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public Quiz(String name, Course course) {
        this.questions = new ArrayList<>();
        this.name = name;
        this.course = course;
    }

    public Long Id() {
        return qId;
    }

    public void Id(Long qId) {
        this.qId = qId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
