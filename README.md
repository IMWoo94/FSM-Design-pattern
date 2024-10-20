# FSM-Design-pattern
## FSM ( Finite State Machine ) 디자인 패턴 ( feat. State Pattern / Spring StateMachine )

> ### 일반적인 Enum 을 활용해 if else / switch 로 분기처리를 하는 과정
``` 
enum 을 활용하면 코드 상에서 오타를 줄이고 명시적으로 데이터를 관리 할 수 있다.
enum 에 필요한 코드를 구현해서 각각의 enum에 알맞은 코드를 관리할 수도 있다.
하지만 분기에서 enum 을 작성하지 않아도 컴파일 상에는 문제 없이 동작하고 구현되지 않은 것을 확인 할 수 없게 됩니다.
``` 
---
## State Pattern ?
> State Pattern은 객체의 내부 상태에 따라 그 객체의 행동이 달라지도록 설계하는 디자인 패턴입니다. <br>객체의 상태를 클래스로 분리하여, 상태가 변경될 때 객체의 동작을 쉽게 변경할 수 있게 합니다. <br>이 패턴을 통해 복잡한 조건문 없이 상태 전환을 명확하게 구현할 수 있습니다.

<img width="756" alt="스크린샷 2024-10-19 오후 5 56 14" src="https://github.com/user-attachments/assets/772fbf1f-96f9-4016-885a-87841e6c9ad4">

### State Pattern 상세 설명
* **핵심 개념**
  * 상태(State): 객체가 가질 수 있는 상태를 클래스로 표현합니다. 각 상태는 객체의 행동을 정의하는 메서드를 포함합니다.
  * 컨텍스트(Context): 상태 객체를 소유하고, 상태에 따라 행동을 위임하는 주체입니다. 상태 전환이 일어나면 상태 객체를 교체합니다.
  * 상태 전환: 컨텍스트 객체가 현재 상태에 따라 상태 객체를 변경하고, 새로운 상태에 맞는 동작을 수행합니다.
* **구조**
  * Context: 상태를 보유하는 클래스입니다. 현재 상태를 관리하고, 클라이언트가 요청하는 작업을 현재 상태 객체에 위임합니다.
  * State 인터페이스/추상 클래스: 다양한 상태들이 구현해야 할 공통 인터페이스입니다. 이 인터페이스는 상태에 따른 행동 메서드를 정의합니다.
  * Concrete State: 각각의 상태에 따른 동작을 구현하는 클래스들입니다. 이 클래스들은 State 인터페이스를 구현하여 각기 다른 동작을 정의합니다.
* **장점**
  * 상태에 따른 행동을 명확히 구분할 수 있어 코드의 복잡성을 줄입니다.
  * 상태 변화 로직을 객체지향적으로 캡슐화하므로 유지보수성이 높아집니다.
  * 상태 추가 및 변경이 쉽게 이루어집니다.
* **단점**
  * 상태가 많아질수록 클래스 수가 증가하고, 관리해야 할 코드가 늘어날 수 있습니다.
  * 상태 전환을 위한 인터페이스 설계가 복잡할 수 있습니다.

### 회고
```  
구현해보면서 알 수 있는건 결국에 각각의 State 에 대해서 직접 하드코딩으로 넘겨주는 것이 아닌가?? 하드코딩 된 것이 과연 좋은 코드일까라는 생각이 든다.
위 코드는 프로세스 적으로 순서가 있는 곳에서 적용되면 사용할 법 하지만 일반적인 enum 에서 단순 상수 정의 등으로 사용되면 큰 효과는 없어 보인다.
간단한 State Pattern 을 활용하면 Context 를 enum 에서 담고 있고, 해당 enum 마다 각각 순서를 미리 정해서 필요한 함수를 구동 시킬 수 있다.
즉, 프로세스를 거치는 과정에서 순서의 활용이 필요한 경우 State Pattern 을 통해서 정해진 순서대로 진행하면 좋을 듯 하다.
```

---
## Finite State Machine ( 유한 상태 머신 ) ?
> 유한한 상태를 가진 시스템에서 하나의 상태에서 다른 상태로 전이되는 모델입니다. <br>시스템은 하나의 상태만 유지하며, 특정 이벤트나 트리거에 의해 다른 상태로 전환됩니다. <br>FSM은 명확하게 정의된 상태와 상태 전환 규칙을 바탕으로 동작을 제어합니다.

<img width="730" alt="스크린샷 2024-10-20 오후 7 08 26" src="https://github.com/user-attachments/assets/cb4de435-a857-4f86-8215-76492694353f">

### Finite State Machine 상세 설명
* **핵심 개념**
  * 상태(State): 시스템이 가질 수 있는 상태를 나타냅니다. FSM은 유한한 개수의 상태만을 가집니다.
  * 전이(Transition): 한 상태에서 다른 상태로 변화하는 과정입니다. 이 전이는 특정 이벤트나 조건에 의해 발생합니다.
  * 이벤트(Event) 또는 트리거(Trigger): 상태 전환을 촉발시키는 외부 신호나 조건입니다. 이를 통해 상태가 변화하게 됩니다.
* **구조**
  * State: 시스템이 현재 어떤 상태에 있는지를 나타냅니다.
  * Event/Trigger: 상태 전환을 유발하는 외부 입력입니다.
  * Transition: 이벤트에 따라 하나의 상태에서 다른 상태로 이동하는 규칙입니다.
  * Action: 상태 전환 시 또는 상태에 있을 때 수행되는 작업입니다.
* **동작 방식**
  * FSM은 항상 하나의 상태에 있으며, 이벤트가 발생하면 정의된 전이 규칙에 따라 상태가 바뀝니다.
  <br>모든 상태는 명확한 전이 규칙을 가지며, 각 이벤트는 상태 전환의 트리거 역할을 합니다.
  <br>상태에 따라 수행할 작업이 달라질 수 있습니다.
* **장점**
  * 상태 전환 규칙이 명확하여, 상태에 따른 동작을 직관적으로 관리할 수 있습니다.
  * 복잡한 시스템에서 상태 변화와 관련된 로직을 구조화하고 시각화하는 데 유용합니다.
  * 유연한 상태 전환이 가능하므로 상태 간 순서 제약이 적습니다.
* **단점**
  * 상태가 많아지면 전이 규칙이 복잡해질 수 있으며, 이를 관리하기 위한 설계가 필요합니다.
  * 비슷한 상태들이 많다면, 코드 중복이 발생할 수 있습니다.
 
### 회고
```  
FSM 디자인 패던은 정해져 있는 유한한 상태와 전이를 정의하는 트리거를 정의해 상태를 관리하는 디자인 패턴이다.
State Pattern 의 next, prev 로 상태를 변경하는게 아니라 input 에 값에 따라 상태를 바꾸는 것을 의미한다.
즉, State Pattern 은 주어진 순서가 있기에 해당 순서대로 상태의 값을 변경하고 실행된다.
하지만, FSM을 활용하면 입력된 값의 상태부터 이후로 진행이 가능하며 입력에 따라 유연하게 조정될 수 있다.
상태의 순서를 입력에 의해서 상태 전환을 컨트롤 할 수 있다는 점이 State Pattern 의 단점을 극복한 FSM 이지 않을까
```

---
### State Patern VS Finite State Machine
* State Pattern은 상태에 따라 동작을 분리하고, 상태 전환 로직이 객체 내에서 처리됩니다.
<br>상태는 객체의 행동을 변경하지만, 상태 전환 규칙 자체는 명확하게 정의되어 있지 않으며 정해진 순서로 상태가 변경되는 경우가 많습니다.

* Finite State Machine은 이벤트나 트리거에 의해 유동적으로 상태 전환이 이루어집니다.
<br>즉, 특정 이벤트가 발생할 때마다 상태가 전환되며, 여러 상태 전환 경로를 정의할 수 있어 더 복잡한 상태 전환 규칙을 유연하게 관리할 수 있습니다.

---

## FSM 패턴을 구현해준 Spring StateMachine
[Spring StateMachine](https://spring.io/projects/spring-statemachine#learn)

---
참고<br>
[Java에서 Enum의 한계를 극복하기 위한 FSM(Finite State Machine) 디자인 패턴 (feat. State Pattern, Spring StateMachine)](https://velog.io/@blackbean99/Java%EC%97%90%EC%84%9C-Enum%EC%9D%98-%ED%95%9C%EA%B3%84%EB%A5%BC-%EA%B7%B9%EB%B3%B5%ED%95%98%EA%B8%B0-%EC%9C%84%ED%95%9C-FSMFinite-State-Machine-%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4-feat.-State-Pattern-Spring-StateMachine)
