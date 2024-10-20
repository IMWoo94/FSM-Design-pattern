package org.example.finitestatepattern;

public class IdleState implements State{

	@Override
	public void handleEvent(ButtonContext context, ButtonEvent event) {
		switch(event){
			case ONCLICK -> {
				context.setState(new FetchingState());
				System.out.println("Fetching data...");
				break;
			}
			default -> System.out.println("Invalid event for IDLE state.");
		}
	}
}
