# FSM-Design-pattern
## FSM ( Finite State Machine ) 디자인 패턴 ( feat. State Pattern / Spring StateMachine )

---
일반적인 Enum 을 활용해 if else / switch 로 분기처리를 하는 과정
* enum 을 활용하면 코드 상에서 오타를 줄이고 명시적으로 데이터를 관리 할 수 있다.
* 또한 추가로 enum 에 필요한 코드를 구현해서 각각의 enum에 알맞은 코드를 관리할 수도 있다.
* 하지만 좋지 않은 점도 있습니다.
* 분기에서 enum 을 작성하지 않아도 컴파일 상에는 문제 없이 동작하고 구현되지 않은 것을 확인 할 수 없게 됩니다.

---
State Pattern ?
<br>State Pattern은 객체의 내부 상태에 따라 그 객체의 행동이 달라지도록 설계하는 디자인 패턴입니다. 객체의 상태를 클래스로 분리하여, 상태가 변경될 때 객체의 동작을 쉽게 변경할 수 있게 합니다. 이 패턴을 통해 복잡한 조건문 없이 상태 전환을 명확하게 구현할 수 있습니다.
<img width="756" alt="스크린샷 2024-10-19 오후 5 56 14" src="https://github.com/user-attachments/assets/772fbf1f-96f9-4016-885a-87841e6c9ad4">

State Pattern 상세 설명

핵심 개념
* 상태(State): 객체가 가질 수 있는 상태를 클래스로 표현합니다. 각 상태는 객체의 행동을 정의하는 메서드를 포함합니다.
* 컨텍스트(Context): 상태 객체를 소유하고, 상태에 따라 행동을 위임하는 주체입니다. 상태 전환이 일어나면 상태 객체를 교체합니다.
* 상태 전환: 컨텍스트 객체가 현재 상태에 따라 상태 객체를 변경하고, 새로운 상태에 맞는 동작을 수행합니다.

구조
* Context: 상태를 보유하는 클래스입니다. 현재 상태를 관리하고, 클라이언트가 요청하는 작업을 현재 상태 객체에 위임합니다.
* State 인터페이스/추상 클래스: 다양한 상태들이 구현해야 할 공통 인터페이스입니다. 이 인터페이스는 상태에 따른 행동 메서드를 정의합니다.
* Concrete State: 각각의 상태에 따른 동작을 구현하는 클래스들입니다. 이 클래스들은 State 인터페이스를 구현하여 각기 다른 동작을 정의합니다.

장점
* 상태에 따른 행동을 명확히 구분할 수 있어 코드의 복잡성을 줄입니다.
* 상태 변화 로직을 객체지향적으로 캡슐화하므로 유지보수성이 높아집니다.
* 상태 추가 및 변경이 쉽게 이루어집니다.

단점
* 상태가 많아질수록 클래스 수가 증가하고, 관리해야 할 코드가 늘어날 수 있습니다.
* 상태 전환을 위한 인터페이스 설계가 복잡할 수 있습니다.

---
참고<br>
[Java에서 Enum의 한계를 극복하기 위한 FSM(Finite State Machine) 디자인 패턴 (feat. State Pattern, Spring StateMachine)](https://velog.io/@blackbean99/Java%EC%97%90%EC%84%9C-Enum%EC%9D%98-%ED%95%9C%EA%B3%84%EB%A5%BC-%EA%B7%B9%EB%B3%B5%ED%95%98%EA%B8%B0-%EC%9C%84%ED%95%9C-FSMFinite-State-Machine-%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4-feat.-State-Pattern-Spring-StateMachine)
