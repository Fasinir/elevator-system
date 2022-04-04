package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.Logging;

import java.util.Objects;

/**
 * @author Filip Piwosz
 */
class DrawElevatorsCommand implements ElevatorSystemCommand {

    final ElevatorSystem system;

    public DrawElevatorsCommand(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        Logging.info(system.elevatorsString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawElevatorsCommand that = (DrawElevatorsCommand) o;
        return Objects.equals(system, that.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system);
    }
}
