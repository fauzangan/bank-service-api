package com.example.bank_service_api.exception;

import com.example.bank_service_api.util.ErrorResponse;
import com.example.bank_service_api.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GloblaExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                Response.renderError(ex.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<?> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        return new ResponseEntity<>(
                Response.renderError(ex.getMessage(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectPINNumberException.class)
    public ResponseEntity<?> handleInsufficientBalanceException(IncorrectPINNumberException ex) {
        return new ResponseEntity<>(
                Response.renderError(ex.getMessage(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(
                Response.renderError(ex.getMessage(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        return new ResponseEntity<>(Response.renderError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
