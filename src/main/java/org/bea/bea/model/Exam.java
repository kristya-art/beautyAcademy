package org.bea.bea.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exam_id")
    private Long id;

   private boolean isFinal ;

    private Long points;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    Date date;




    public Exam() {
    }

    public Exam(boolean isFinal, Long points, Date date) {
        this.isFinal = isFinal;
        this.points = points;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
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
