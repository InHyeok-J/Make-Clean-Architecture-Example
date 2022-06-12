package com.example.layed.member.domain;

import com.example.layed.member.domain.exception.NotLoginException;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionManager {

  private final HttpSession httpSession;

  void saveSession(Long userId){
    httpSession.setAttribute("user", userId);
  }

  Long getUserId(){
    String findUserId = httpSession.getAttribute("user").toString();
    if(findUserId==null){
      throw new NotLoginException("로그인 안된 유저입니다.");
    }
    return Long.parseLong(findUserId);
  }
}
