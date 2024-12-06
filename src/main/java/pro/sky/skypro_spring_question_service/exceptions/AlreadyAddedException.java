package pro.sky.skypro_spring_question_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class AlreadyAddedException extends RuntimeException{
}
