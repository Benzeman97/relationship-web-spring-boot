package com.benz.web.exception;

import com.benz.web.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DataNotFoundExceptionHandler {

	@ExceptionHandler
    public ResponseEntity<ErrorMessage> getResponse(DataNotFoundException ex)
    {
        ErrorMessage error_msg=new ErrorMessage(404,ex.getMessage(),"www.benz.com");
        return new ResponseEntity<ErrorMessage>(error_msg, HttpStatus.NOT_FOUND);
    }
}
