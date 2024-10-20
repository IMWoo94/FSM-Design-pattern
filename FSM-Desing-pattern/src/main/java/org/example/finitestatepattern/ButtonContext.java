package org.example.finitestatepattern;

public class ButtonContext {
	private State state;

	public ButtonContext() {
		state = new IdleState();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void handleEvent(ButtonEvent event) {
		state.handleEvent(this, event);
	}
}
