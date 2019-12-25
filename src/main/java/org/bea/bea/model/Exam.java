package org.bea.bea.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;

import java.sql.Time;
import java.util.Date;

//@Entity
public abstract class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exam_id")
    private Long id;

   private boolean isFinal ;

    private Long points;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    private Time time;




    public Exam() {
    }

    public Exam( Long points, Date date,Time time) {
        this.points = points;
        this.date = date;
        this.time = time;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
