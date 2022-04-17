package io.reflectoring.buckpal.account.adapter.in.web;

import io.reflectoring.buckpal.account.application.port.in.SendMoneyCommand;
import io.reflectoring.buckpal.account.application.port.in.SendMoneyUseCase;
import io.reflectoring.buckpal.account.domain.Account.AccountId;
import io.reflectoring.buckpal.account.domain.Money;
import io.reflectoring.buckpal.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SendMoneyController {

  private final SendMoneyUseCase sendMoneyUseCase;

  @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
  void sendMoney(
    @PathVariable("sourceAccountId") Long sourceAccountId,
    @PathVariable("targetAccountId") Long targetAccountId,
    @PathVariable("amount") Long amount) {

    SendMoneyCommand command = new SendMoneyCommand(
      new AccountId(sourceAccountId),
      new AccountId(targetAccountId),
      Money.of(amount));

    sendMoneyUseCase.sendMoney(command);
  }
}

/*
Web Adapter 는 어떤 책임을 갖고 있는가?
- HTTP 요청 수신 (요청을 HttpServletRequest 객체로 매핑)
- 권한 검사
- 입력 유효성 검증 (DTO Bean Validation)
- 입력을 유스케이스의 입력 모델로 변환 (DTO -> Model)
- 유스케이스 호출 (비지니스 로직)
- 출력을 HTTP 응답으로 매핑
- HTTP 응답 반환

DTO 어느 계층까지 사용할 것인지에 대한 고민이 필요하다
정답은 없고 Web Adapter 계층까지 사용하여 변환 과정을 거쳐 Model 변환 후 Application 계층 호출할 것인지
Application 계층까지 사용해 Web Adapter 계층이 Model 모르도록 설계할 것인지

Application 계층까지로 제한해둔다면 Controller가 Entity에 대한 의존성을 갖지 않을 수 있다
DTO -> Controller, Service
Entity -> Service, Repository
요렇게 만들었을 때의 단점은 Service 계층이 DTO에 묶인다는 것인데
다시 말해 로직 자체가 DTO 반환 형태로 고정되어 다른 형태로 반환하는 재활용하기 힘들어진다

Web Adapter 계층까지로 제한해둔다면
DTO -> Controller
Entity -> Controller, Service, Repository
Controller에서 변환 작업을 수행하기 때문에 엔티티를 받아서 원하는 형태로 반환하면 된다
이 방식이 맞는 것 같기두..?
 */