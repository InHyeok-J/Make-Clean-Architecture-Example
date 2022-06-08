package com.example.layed.common.exception;

import com.example.layed.common.response.FailResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {ConstraintViolationException.class,
      MethodArgumentNotValidException.class,
      HttpMessageNotReadableException.class,
  })
  private ResponseEntity<?> handleMethodArgumentNotValidException(
      Exception e) {

    return FailResponse.withMessageAndCode(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  @ExceptionHandler(BusinessException.class)
  private ResponseEntity<?> handleBusinessException(BusinessException e) {
    return FailResponse.withMessageAndCode(HttpStatus.BAD_REQUEST, e.getMessage());
  }
}
