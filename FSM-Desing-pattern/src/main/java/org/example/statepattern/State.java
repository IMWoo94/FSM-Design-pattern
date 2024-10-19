package org.example.statepattern;

public interface State {
	void next(Context pkg);

	void prev(Context pkg);

	void handle();
}