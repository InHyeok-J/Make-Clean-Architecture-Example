package com.example.layed.member.domain.exception;

import com.example.layed.common.exception.BusinessException;

public class NotMatchedPasswordException extends BusinessException {

  public NotMatchedPasswordException(String message) {
    super(message);
  }
}
