package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorCommandFactory;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

/**
 * @author Filip Piwosz
 */
public class ConcreteElevatorCommandFactory implements ElevatorCommandFactory {
    private final ElevatorSystem system;

    public ConcreteElevatorCommandFactory(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public ElevatorSystemCommand createCommandFromInput(String input) {
        return null;
    }
}
