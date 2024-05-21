package com.kou.muhtas2.demo.exception;

import com.kou.muhtas2.demo.auth.exception.AuthenticationException;
import com.kou.muhtas2.demo.user.exceptions.ActivationNotificationException;
import com.kou.muhtas2.demo.user.exceptions.InvalidTokenException;
import com.kou.muhtas2.demo.user.exceptions.NotUniqueEmailException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Validation Error");
        Map<String, String> validationError = new HashMap<>();
        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
            validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationError);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    ResponseEntity<ApiError> handleNotUniqEmailException(NotUniqueEmailException exception,
                                                         HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Validation Error");
        Map<String, String> validationError = new HashMap<>();
        validationError.put("email", "E-mail in use");
        apiError.setValidationErrors(validationError);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(404);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage(exception.getMessage());
        return ResponseEntity.status(404).body(apiError);
    }

    @ExceptionHandler(ActivationNotificationException.class)
    ResponseEntity<ApiError> handleActivationNotificationException(ActivationNotificationException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(502);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage(exception.getMessage());
        return ResponseEntity.status(502).body(apiError);
    }

    @ExceptionHandler(InvalidTokenException.class)
    ResponseEntity<ApiError> handleInvalidTokenException(InvalidTokenException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage(exception.getMessage());
        return ResponseEntity.status(400).body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(401);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage(exception.getMessage());
        return ResponseEntity.status(401).body(apiError);
    }


}
