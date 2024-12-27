package com.exceptionhandler.springbootexceptionhandler.Controllers;

import com.exceptionhandler.springbootexceptionhandler.DTO.PayloadDTO;
import com.exceptionhandler.springbootexceptionhandler.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ExceptionController {

    public ResponseEntity<PayloadDTO> Error(String message, Exception e){

        if(e instanceof CustomException){
            return ResponseEntity.status(((CustomException) e).getStatus()).body(PayloadDTO.getErrorPayload(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(PayloadDTO.getErrorPayload(message));
    }
    public <T> ResponseEntity<T>  Errors(String message, Exception e){

        if(e instanceof CustomException){
            return (ResponseEntity<T>) ResponseEntity.status(((CustomException) e).getStatus()).body(e.getMessage());
        }
        return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}