package org.bea.bea.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    @ColumnDefault("false")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name="que_id")
    private Question question;


    public Answer() {
    }

    public Answer(String text, Question question) {
        this.text = text;
        this.question = question;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
       return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
