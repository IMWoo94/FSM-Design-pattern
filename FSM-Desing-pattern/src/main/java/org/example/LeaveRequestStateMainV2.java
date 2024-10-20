package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LeaveRequestStateMainV2 {
	public static void main(String[] args) {

		/**
		 * Simple State Machine 활용 사례
		 * 추상 클래스를 활용해 enum 에 context 를 포함하는 케이스
 		 */
		LeaveRequestStateV2 context = LeaveRequestStateV2.Submitted;

		System.out.println(context.responsiblePerson());
		context = context.nextState();

		System.out.println(context.responsiblePerson());
		context = context.nextState();

		System.out.println(context.responsiblePerson());
	}
}