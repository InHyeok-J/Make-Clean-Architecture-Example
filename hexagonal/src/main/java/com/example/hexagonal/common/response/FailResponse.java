package com.example.hexagonal.common.response;

import lombok.Getter;

@Getter
class FailResponse {

  private final boolean success = false;
  private String message;

  public FailResponse(String message) {
    this.message = message;
  }
}
