package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LeaveRequestStateMainV1 {
	public static void main(String[] args) {

		/**
		 * 일반적인 Enum 을 활용해 if else / switch 로 분기처리를 하는 과정
		 * enum 을 활용하면 코드 상에서 오타를 줄이고 명시적으로 데이터를 관리 할 수 있다.
		 * 또한 추가로 enum 에 필요한 코드를 구현해서 각각의 enum에 알맞은 코드를 관리할 수도 있다.
		 * 하지만 좋지 않은 점도 있습니다.
		 * 분기에서 enum 을 작성하지 않아도 컴파일 상에는 문제 없이 동작하고 구현되지 않은 것을 확인 할 수 없게 됩니다.
 		 */
		LeaveRequestStateV1[] values = LeaveRequestStateV1.values();
		for(LeaveRequestStateV1 state : values) {
			switch (state) {
				case LeaveRequestStateV1.Submitted, LeaveRequestStateV1.Approved -> state.testMethod();
			}
		}

	}
}