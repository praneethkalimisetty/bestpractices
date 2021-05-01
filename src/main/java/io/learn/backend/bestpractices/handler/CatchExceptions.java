package io.learn.backend.bestpractices.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// import com.springboot.exception.InvalidFieldException;

@RestControllerAdvice
public class CatchExceptions {
    
    @ExceptionHandler
    public String handleInvalidException(Exception exception){
        return exception.getMessage();
    }
}
