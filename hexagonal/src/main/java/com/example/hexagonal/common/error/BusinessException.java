package com.example.hexagonal.common.error;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

  private int statusCode;

  public BusinessException() {
  }

  public BusinessException(String message, int statusCode) {
    super(message);
    this.statusCode = statusCode;
  }
}
