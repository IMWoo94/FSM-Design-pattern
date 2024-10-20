package org.example.finitestatepattern;

public class FSMMain {
	public static void main(String[] args) {
		ButtonContext button = new ButtonContext();

		/**
		 * input 으로 context 를 받으면서 사용이 가능하다.
		 */
		button.handleEvent(ButtonEvent.ONCLICK);   // Fetching data...
		button.handleEvent(ButtonEvent.FAILURE);   // Error occurred.
		button.handleEvent(ButtonEvent.RETRY);     // Retrying...
		button.handleEvent(ButtonEvent.SUCCESS);   // Data fetched successfully.
		button.handleEvent(ButtonEvent.ONCLICK);   // Fetching data...
		button.handleEvent(ButtonEvent.SUCCESS);   // Data fetched successfully.
	}
}
