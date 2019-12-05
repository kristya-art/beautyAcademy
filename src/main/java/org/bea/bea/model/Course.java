package org.bea.bea.model;

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

    @OneToMany()
    private Collection<Topic> topics;

//    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
//    private Collection<Participant> participants;

    @OneToOne()
    @NotFound(action= NotFoundAction.IGNORE)
    private Exam exam;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Collection<Lecturer> lecturers;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Collection<Participant> participants;

    public Course(){}

    public Course(String code, String title, String description, int points,  Exam exam) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.points = points;
        this.exam = exam;
        lecturers=new HashSet<>();
        topics=new HashSet<>();

    }

    public Course(String code, String title, String description, int points,Collection<Participant> participants,  Exam exam) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.points = points;
        this.exam = exam;
        lecturers=new HashSet<>();
        topics=new HashSet<>();
        participants=new HashSet<>();

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

    public void addtTopic(Topic topic) {
        topics.add(topic);
    }

    public void removeTopic(Topic topic){
        topics.remove(topic);
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Collection<Lecturer> getLecturers() {
        return lecturers;
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        lecturer.addCourse(this);

    }

    public void removeLecturer(Lecturer lecturer){
        lecturers.remove(lecturer);
        lecturer.removeCourse(this);
    }

    public Collection<Participant> getParticipants() {
        return participants;
    }

    public void addParticipants(Collection<Participant> participants) {
        this.participants = participants;
    }

    public void addParticipant(Participant participant){
        participants.add(participant);
        participant.addCourse(this);
    }
    public void removeParticipant(Participant participant){
        participants.remove(participant);
        participant.removeCourse(this);
    }
}
