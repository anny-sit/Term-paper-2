package pro.sky.skypro_spring_question_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skypro_spring_question_service.exceptions.WantedMoreThanExistException;
import pro.sky.skypro_spring_question_service.services.ExaminerServiceImpl;
import pro.sky.skypro_spring_question_service.services.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    Question quest = new Question("question", "answer");

    Set<Question> questionSet = new HashSet<>() {{
        add(quest);
    }};


    @Test
    public void getQuestionsTest() {
        when(questionServiceMock.getRandomQuestion())
                .thenReturn(quest);
        when(questionServiceMock.getAll())
                .thenReturn(questionSet);
        assertEquals(questionSet, examinerService.getQuestions(1));


    }

    @Test
    public void WantedMoreThanExistExceptionTest() {
        when(questionServiceMock.getAll())
                .thenReturn(questionSet);
        assertThrows(WantedMoreThanExistException.class, () -> examinerService.getQuestions(3));

    }

}
