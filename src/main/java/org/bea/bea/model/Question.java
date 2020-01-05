package org.bea.bea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="question")
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String question_text;

    @ManyToOne
    @JoinColumn(name="quiz_id")
    @JsonIgnore
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
   private List<Answer> answers;

//   private Answer correctAnswer;

  // public Question(){}

   public Question(){
       answers = new ArrayList<>();
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

//    public Answer getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    public void setCorrectAnswer(Answer correctAnswer) {
//        this.correctAnswer = correctAnswer;
//    }
}
