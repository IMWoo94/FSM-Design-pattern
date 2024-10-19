package org.example.statepattern;

public class DeliveredState implements State {

	@Override
	public void next(Context pkg) {
		pkg.setState(new ReceivedState());
	}

	@Override
	public void prev(Context pkg) {
		pkg.setState(new OrderedState());
	}

	@Override
	public void handle() {
		System.out.println("Package delivered to post office, not received yet.");
	}
}
