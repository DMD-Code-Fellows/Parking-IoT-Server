package com.dmd.parking_iot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * Configurator for the parking space state machine. Sets up the valid parking space states and their transitions.
 * This code is based on the API documentation:
 * https://docs.spring.io/spring-statemachine/docs/2.0.3.RELEASE/reference/htmlsingle/
 */
@Configuration
@EnableStateMachine
public class ParkingSpaceStateMachineConfig extends EnumStateMachineConfigurerAdapter<ParkingSpaceStates, ParkingSpaceEvents> {

    /**
     * TODO
     * @param config
     * @throws Exception
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<ParkingSpaceStates, ParkingSpaceEvents> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    /**
     * TODO
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<ParkingSpaceStates, ParkingSpaceEvents> states)
            throws Exception {
        states
                .withStates()
                .initial(ParkingSpaceStates.VACANT)
                .states(EnumSet.allOf(ParkingSpaceStates.class));
    }

    /**
     * TODO
     * @param transitions
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<ParkingSpaceStates, ParkingSpaceEvents> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(ParkingSpaceStates.VACANT).target(ParkingSpaceStates.OCCUPIED).event(ParkingSpaceEvents.OCCUPY)
                .and()
                .withExternal()
                .source(ParkingSpaceStates.OCCUPIED).target(ParkingSpaceStates.VACANT).event(ParkingSpaceEvents.VACATE)
                .and()
                .withExternal()
                .source(ParkingSpaceStates.OUT_OF_SERVICE).target(ParkingSpaceStates.VACANT).event(ParkingSpaceEvents.PUT_INTO_SERVICE)
                .and()
                .withExternal()
                .source(ParkingSpaceStates.VACANT).target(ParkingSpaceStates.OUT_OF_SERVICE).event(ParkingSpaceEvents.REMOVE_FROM_SERVICE);
    }

    /**
     * TODO
     * @return
     */
    @Bean
    public StateMachineListener<ParkingSpaceStates, ParkingSpaceEvents> listener() {
        return new StateMachineListenerAdapter<ParkingSpaceStates, ParkingSpaceEvents>() {
            @Override
            public void stateChanged(State<ParkingSpaceStates, ParkingSpaceEvents> from, State<ParkingSpaceStates, ParkingSpaceEvents> to) {
                System.out.println("State change to " + to.getId()); //TODO remove this debugging statement with production release
            }
        };
    }
}
