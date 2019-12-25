package org.bea.bea.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="answered_question")
public class AnsweredQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "que_id")
    private Question question;

    @OneToMany
    private List<Answer> selectedAnswers;

    public AnsweredQuestion(Question question, List<Answer> selectedAnswers) {
        this.question = question;
        selectedAnswers = new ArrayList<>();

    }

    private void add(Answer answer) {
        selectedAnswers.add(answer);
    }


    public AnsweredQuestion(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(List<Answer> selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }
}
