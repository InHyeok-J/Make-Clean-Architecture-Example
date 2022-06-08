package com.example.layed.member.domain.exception;

import com.example.layed.common.exception.BusinessException;

public class DuplicateMemberException extends BusinessException {

  public DuplicateMemberException(String message){
    super(message);
  }
}
