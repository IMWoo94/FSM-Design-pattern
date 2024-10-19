package org.example.statepattern;

public class OrderedState implements State {
	@Override
	public void next(Context pkg) {
		pkg.setState(new DeliveredState());
	}

	@Override
	public void prev(Context pkg) {
		System.out.println("The package is in its root state.");
	}

	@Override
	public void handle() {
		System.out.println("Package ordered, not delivered to the office yet.");
	}
}
