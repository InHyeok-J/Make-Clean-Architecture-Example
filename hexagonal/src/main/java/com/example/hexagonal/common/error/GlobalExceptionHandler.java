package com.example.hexagonal.common.error;

import com.example.hexagonal.common.response.JsonResponse;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  private ResponseEntity<?> handleViolationError(ConstraintViolationException e){
    return JsonResponse.fail(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");
  }

  @ExceptionHandler(BusinessException.class)
  private ResponseEntity<?> handleBusinessError(BusinessException e){
    return JsonResponse.fail(HttpStatus.valueOf(e.getStatusCode()), e.getMessage());
  }
}
