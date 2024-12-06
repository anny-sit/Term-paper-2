package pro.sky.skypro_spring_question_service.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.skypro_spring_question_service.Question;
import pro.sky.skypro_spring_question_service.services.ExaminerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Set<Question> getQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
