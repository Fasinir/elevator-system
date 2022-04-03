package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

/**
 * @author Filip Piwosz
 */
class StepCommand implements ElevatorSystemCommand {
    final ElevatorSystem system;

    public StepCommand(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        system.step();
    }
}
