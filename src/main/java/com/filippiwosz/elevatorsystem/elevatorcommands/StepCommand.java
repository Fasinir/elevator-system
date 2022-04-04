package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepCommand that = (StepCommand) o;
        return Objects.equals(system, that.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system);
    }
}
