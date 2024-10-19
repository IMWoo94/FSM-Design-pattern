package org.example.statepattern;

public class ReceivedState implements State {

	@Override
	public void next(Context pkg) {
		System.out.println("This package is already received by a client.");
	}

	@Override
	public void prev(Context pkg) {
		pkg.setState(new DeliveredState());
	}

	@Override
	public void handle() {
		System.out.println("Package received, not yet.");
	}
}
