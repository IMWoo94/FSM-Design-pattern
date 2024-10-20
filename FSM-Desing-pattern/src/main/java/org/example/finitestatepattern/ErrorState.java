package org.example.finitestatepattern;

public class ErrorState implements State {
	@Override
	public void handleEvent(ButtonContext context, ButtonEvent event) {
		switch (event) {
			case RETRY:
				context.setState(new FetchingState());
				System.out.println("Retrying...");
				break;
			default:
				System.out.println("Invalid event for ERROR state.");
		}
	}
}
