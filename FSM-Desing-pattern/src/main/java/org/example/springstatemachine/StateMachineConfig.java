package org.example.springstatemachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.configurers.ConfigurationConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<ButtonState, ButtonEvent> {

	@Override
	public void configure(StateMachineConfigurationConfigurer<ButtonState, ButtonEvent> config)
		throws Exception {
		ConfigurationConfigurer<ButtonState, ButtonEvent> listener = config
			.withConfiguration()
			.autoStartup(true)
			.listener(new StateMachineListenerAdapter<ButtonState, ButtonEvent>() {
				@Override
				public void stateChanged(State<ButtonState, ButtonEvent> from, State<ButtonState, ButtonEvent> to) {
					System.out.println("State change to : " + to.getId());
				}
			});
	}

	@Override
	public void configure(StateMachineStateConfigurer<ButtonState, ButtonEvent> states) throws Exception {
		states.withStates()
			.initial(ButtonState.IDLE)
			.states(EnumSet.allOf(ButtonState.class));
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<ButtonState, ButtonEvent> transitions) throws Exception {
		transitions
			.withExternal().source(ButtonState.IDLE).target(ButtonState.FETCHING).event(ButtonEvent.ONCLICK)
			.and()
			.withExternal().source(ButtonState.FETCHING).target(ButtonState.ERROR).event(ButtonEvent.FAILURE)
			.and()
			.withExternal().source(ButtonState.FETCHING).target(ButtonState.IDLE).event(ButtonEvent.SUCCESS)
			.and()
			.withExternal().source(ButtonState.ERROR).target(ButtonState.FETCHING).event(ButtonEvent.RETRY);
	}
}
