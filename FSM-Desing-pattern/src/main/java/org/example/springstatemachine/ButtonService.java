package org.example.springstatemachine;

import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class ButtonService {

	private final StateMachine<ButtonState, ButtonEvent> stateMachine;

	public ButtonService(StateMachine<ButtonState, ButtonEvent> stateMachine) {
		this.stateMachine = stateMachine;
	}

	public void processEvent(ButtonEvent event){
		stateMachine.sendEvent(event);
		System.out.println("current state  : " + stateMachine.getState().getId());
	}
}
