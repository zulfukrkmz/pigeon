package org.pigeon.apps.pigeoncrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PigeonGlobalExceptionHandler {
    //Adding Exception Handler
    @ExceptionHandler
    public ResponseEntity<PigeonErrorResponse> handleException (CustomerNotFoundException exc) {
        //creating StudentErrorResponse

        PigeonErrorResponse error = new PigeonErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PigeonErrorResponse> handleException (Exception exc) {
        //creating pigeonErrorResponse

        PigeonErrorResponse error = new PigeonErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
