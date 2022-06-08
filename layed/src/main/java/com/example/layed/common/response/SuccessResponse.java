package com.example.layed.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class SuccessResponse {

  private final boolean status = true;

  private Object data;

  public static ResponseEntity<?> withData(Object data) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new SuccessResponse(data));
  }
}
