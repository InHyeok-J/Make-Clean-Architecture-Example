package com.example.hexagonal.common.error;

public class NotFoundResourceException extends BusinessException{

  public NotFoundResourceException() {
  }

  public NotFoundResourceException(String message) {
    super(message, 404);
  }
}
