package org.bea.bea.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="i_exam")
public class IntermediateExam extends Exam{

    @Id
    private Long id;
@OneToMany
 private Collection<Quiz> quizzes = new ArrayList<>();


    public IntermediateExam(){}

    private IntermediateExam(Long points, Date date, Time time, Collection<Quiz> quizzes){
        super(points,date,time);
        this.quizzes=quizzes;

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Collection<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
