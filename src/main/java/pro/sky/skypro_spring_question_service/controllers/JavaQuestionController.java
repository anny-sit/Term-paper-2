package pro.sky.skypro_spring_question_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro_spring_question_service.Question;
import pro.sky.skypro_spring_question_service.services.JavaQuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Set<Question> allJavaQuestions() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return javaQuestionService.add(question,answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return javaQuestionService.remove(new Question(question,answer));
    }
    @GetMapping("/find")
    public Question find(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        return javaQuestionService.find(new Question(question,answer));
    }
}
