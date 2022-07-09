package com.example.hexagonal.common.response;

import lombok.Getter;

@Getter
class SuccessResponse {

  private final boolean success = true;

  private final Object data;

  public SuccessResponse(Object data) {
    this.data = data;
  }
}
