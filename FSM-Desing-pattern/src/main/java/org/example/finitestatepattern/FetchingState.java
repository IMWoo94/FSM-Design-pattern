package org.example.finitestatepattern;

public class FetchingState implements State{

	@Override
	public void handleEvent(ButtonContext context, ButtonEvent event) {
		switch(event){
			case FAILURE -> {
				context.setState(new ErrorState());
				System.out.println("Error occurred.");
				break;
			}
			case SUCCESS -> {
				context.setState(new IdleState());
				System.out.println("Data fetched successfully.");
				break;
			}
			default -> System.out.println("Invalid event for FETCHING state.");
		}
	}
}

