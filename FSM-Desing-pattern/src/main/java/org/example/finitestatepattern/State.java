package org.example.finitestatepattern;

public interface State {
	void handleEvent(ButtonContext context, ButtonEvent event);
}
