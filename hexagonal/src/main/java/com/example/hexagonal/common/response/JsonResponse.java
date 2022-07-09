package com.example.hexagonal.common.response;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonResponse {

  public static ResponseEntity<?> okWithData(HttpStatus status,Object data){
    SuccessResponse response = new SuccessResponse(data);
    return ResponseEntity.status(status)
        .body(response);
  }

  public static ResponseEntity<?> ok(HttpStatus status){
    SuccessResponse response = new SuccessResponse(new ArrayList<>());
    return ResponseEntity.status(status)
        .body(response);
  }

  public static ResponseEntity<?> fail(HttpStatus status, String message){
    FailResponse failResponse = new FailResponse(message);
    return ResponseEntity.status(status)
        .body(failResponse);
  }
}
