package org.bea.bea.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class FinalExam extends Exam {

    @Id
    private Long id;

    private boolean isAvailable;

    private FinalExam(){}

    private FinalExam(Long points, Date date, Time time){
        super(points,date,time);

    }





}
