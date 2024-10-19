package org.example.statepattern;

public class StateDemoMain {
	public static void main(String[] args) {
		Context cont = new Context();
		cont.handle();

		cont.nextState();
		cont.handle();

		cont.nextState();
		cont.handle();

		cont.nextState();
		cont.handle();
	}
}
