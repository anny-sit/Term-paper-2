package pro.sky.skypro_spring_question_service.services;

import org.springframework.stereotype.Service;
import pro.sky.skypro_spring_question_service.Question;
import pro.sky.skypro_spring_question_service.exceptions.AlreadyAddedException;
import pro.sky.skypro_spring_question_service.exceptions.NoSuchQuestionException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (!questions.contains(question1)) {
            questions.add(question1);
            return question1;
        }
        throw new AlreadyAddedException();

    }

    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        }
        throw new AlreadyAddedException();
    }

    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new NoSuchQuestionException();
    }

    public Question find(Question question) {
        if (questions.contains(question)) {
            return questions.stream()
                    .filter(question1 -> question1.equals(question))
                    .findFirst()
                    .get();
        }
        throw new NoSuchQuestionException();
    }

    public Set<Question> getAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        Random numbers = new Random();
        int num = numbers.nextInt(questions.size());
        int i = 1;
        Question question = null;
        for (Question q: questions) {
            if (i == num-1) {
                question = q;
            } else {
                i++;
            }
        }
        return question;
    }
}
