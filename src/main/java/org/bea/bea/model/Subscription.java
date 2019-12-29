package org.bea.bea.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscription_id")
    private Long id;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date last_date;

    @JoinColumn(name="courses_id")
    @ManyToOne()
     private Course course;

    @JoinColumn(name="participant_id")
    @ManyToMany()
    private Collection<Participant> participants;

    public Subscription() {
    }

    public Subscription(Collection<Participant> participants,Course course, Date date, Date last_date) {
        this.date = date;
        this.last_date=last_date;
        this.course=course;
        participants=new HashSet<>();
        this.addParticipants(participants);

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

    public Date getLast_date() {
        return last_date;
    }

    public void setLast_date(Date last_date) {
        this.last_date = last_date;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
