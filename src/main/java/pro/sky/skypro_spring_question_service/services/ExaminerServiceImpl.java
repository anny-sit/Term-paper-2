package pro.sky.skypro_spring_question_service.services;

import org.springframework.stereotype.Service;
import pro.sky.skypro_spring_question_service.Question;
import pro.sky.skypro_spring_question_service.exceptions.WantedMoreThanExistException;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private JavaQuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = (JavaQuestionService) questionService;
    }

    public Set<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new WantedMoreThanExistException();
        }
        Set<Question> readyToReturn = new HashSet<>();
        for (int i = 0; i < amount + 1; i++) {
            readyToReturn.add(questionService.getRandomQuestion());
        }
        return readyToReturn;
    }

}
