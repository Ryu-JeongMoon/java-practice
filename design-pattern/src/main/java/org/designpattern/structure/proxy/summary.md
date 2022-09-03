## Proxy Pattern

Proxy Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control
access to it.

![proxy](https://user-images.githubusercontent.com/76534087/188265258-38c8c920-e0cb-46eb-b642-6e7a75054836.jpg)

#### 장점

- 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있다.
- 기존 코드가 해야 하는 일만 유지할 수 있다.
- 기능 추가 및 초기화 지연 등으로 다양하게 활용할 수 있다.

#### 단점

- 코드의 복잡도가 증가한다.

### 언제 쓰면 좋은가?

1. Lazy initialization (virtual proxy)
    - 생성하는 놈이 비쌀 때
2. Access control (protection proxy)
    - 권한 체크 (@PreAuthorize 등)
3. Local execution of a remote service (remote proxy)
    - 원격 서비스를 로컬에서 실행할 때
4. Logging requests (logging proxy)
    - 인자 값 & 리턴 값 기록, 속도 등
5. Caching results (caching proxy)
    - 반복된 요청에 대한 결과를 미리 캐싱해 둠
6. Smart reference (smart reference)
7. Counting the number of references to the real object (counting proxy)
    - 참조 횟수를 세어서 0이 되면 자동으로 삭제 (GC ?!)