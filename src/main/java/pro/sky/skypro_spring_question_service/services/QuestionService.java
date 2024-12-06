package pro.sky.skypro_spring_question_service.services;


import pro.sky.skypro_spring_question_service.Question;

import java.util.HashSet;
import java.util.Set;

public interface QuestionService {

    Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer);
    public Question add(Question question);
    public Question remove(Question question);
    public Question find(Question question);

    public Set<Question> getAll();

    public Question getRandomQuestion();

}
