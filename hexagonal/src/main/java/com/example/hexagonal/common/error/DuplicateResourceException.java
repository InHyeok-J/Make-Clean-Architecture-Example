package com.example.hexagonal.common.error;

public class DuplicateResourceException extends BusinessException{


  public DuplicateResourceException() {
  }

  public DuplicateResourceException(String message) {
    super(message, 400);
  }
}
