package pro.sky.skypro_spring_question_service;

import org.junit.jupiter.api.Test;
import pro.sky.skypro_spring_question_service.exceptions.AlreadyAddedException;
import pro.sky.skypro_spring_question_service.exceptions.NoSuchQuestionException;
import pro.sky.skypro_spring_question_service.services.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {

    JavaQuestionService questionService = new JavaQuestionService();

    @Test
    public void addTest() {
        Question expected = new Question("question", "answer");
        Question real = questionService.add("question", "answer");
        assertEquals(expected, real);
    }

    @Test
    public void addWithQuestTest() {
        Question expected = new Question("question", "answer");
        Question real = questionService.add(new Question("question", "answer"));
        assertEquals(expected, real);
    }

    @Test
    public void removeTest() {
        Question expected = new Question("question", "answer");
        questionService.add(new Question("question", "answer"));
        Question real = questionService.remove(new Question("question", "answer"));
        assertEquals(expected, real);
    }

    @Test
    public void findTest() {
        Question expected = new Question("question", "answer");
        questionService.add(new Question("question", "answer"));
        Question real = questionService.find(new Question("question", "answer"));
        assertEquals(expected, real);
    }

    @Test
    public void getAllTest() {
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("question", "answer"));
        questionService.add(new Question("question", "answer"));
        Set<Question> real = questionService.getAll();
        assertEquals(expected, real);
    }

    @Test
    public void notFoundExceptionTest() {
        assertThrows(NoSuchQuestionException.class, () -> questionService.find(new Question("question", "answer")));
    }

    @Test
    public void AlreadyAddedExceptionTest() {
        questionService.add(new Question("question", "answer"));
        assertThrows(AlreadyAddedException.class, () -> questionService.add(new Question("question", "answer")));
        assertThrows(AlreadyAddedException.class, () -> questionService.add("question", "answer"));
    }

}
