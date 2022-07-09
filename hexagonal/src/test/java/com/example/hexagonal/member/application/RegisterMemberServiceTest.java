package com.example.hexagonal.member.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import com.example.hexagonal.common.error.BusinessException;
import com.example.hexagonal.member.application.port.in.RegisterMemberCommand;
import com.example.hexagonal.member.application.port.out.LoadMemberPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegisterMemberServiceTest {

  @Mock
  LoadMemberPort loadMemberPort;


  @InjectMocks
  RegisterMemberService registerMemberService;

  @Test
  @DisplayName("존재하는 유저로 실패")
  public void register_fail() throws Exception {
    //given
    RegisterMemberCommand command = registerMemberCommandFactory();
    given(loadMemberPort.existByEmail(any())).willReturn(true);
    //when
    BusinessException e = Assertions.assertThrows(BusinessException.class,
        ()-> registerMemberService.register(command));
    //then
    Assertions.assertEquals(400, e.getStatusCode());
  }

  private RegisterMemberCommand registerMemberCommandFactory(){
    return new RegisterMemberCommand("nick","email@email.com","pass",100,200,300);
  }
}