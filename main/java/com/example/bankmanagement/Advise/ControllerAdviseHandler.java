package com.example.bankmanagement.Advise;

import com.example.bankmanagement.DTO.API;
import com.example.bankmanagement.Exception.InvalidIdException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdviseHandler {

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("SERVER ERROR !",500));
    }
}
