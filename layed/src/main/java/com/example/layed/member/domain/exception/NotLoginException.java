package com.example.layed.member.domain.exception;

import com.example.layed.common.exception.BusinessException;

public class NotLoginException extends BusinessException {

  public NotLoginException(String message) {
    super(message);
  }
}
