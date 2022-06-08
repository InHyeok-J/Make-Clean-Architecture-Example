package com.example.layed.member.domain;

import com.example.layed.member.dto.RegisterMemberRequest;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRequestValidator {

  private final Validator validator;

  public void registerRequestValid(@Valid RegisterMemberRequest registerMemberRequest) {
    Set<ConstraintViolation<RegisterMemberRequest>> violations = validator.validate(
        registerMemberRequest);

    if (!violations.isEmpty()) {
      String errorMessage = errorMessageFormat(violations);
      throw new ConstraintViolationException("Error occurred: " + errorMessage, violations);
    }
  }


  private <T> String errorMessageFormat(Set<ConstraintViolation<T>> violations) {
    StringBuilder sb = new StringBuilder();
    for (ConstraintViolation<T> constraintViolation : violations) {
      sb.append(constraintViolation.getMessage());
    }
    return sb.toString();
  }
}
