package com.example.layed.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class FailResponse {

  private final boolean status = false;
  private String message;

  public static ResponseEntity<?> withMessageAndCode(HttpStatus status, String message) {
    return ResponseEntity.status(status)
        .body(new FailResponse(message));
  }
}
