package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.Logging;

import java.util.List;
import java.util.Objects;

import static java.lang.System.lineSeparator;

/**
 * @author Filip Piwosz
 */
class DisplayStatusCommand implements ElevatorSystemCommand {

    final ElevatorSystem system;

    public DisplayStatusCommand(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        List<ElevatorStatus> statusList = system.status();
        StringBuilder builder = new StringBuilder();
        statusList.forEach(elevatorStatus -> builder
                .append(elevatorStatus)
                .append(lineSeparator()));

        //delete last newline
        if (!statusList.isEmpty()) {
            builder.delete(builder.length() - 1, builder.length());
        }
        Logging.info(builder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplayStatusCommand that = (DisplayStatusCommand) o;
        return Objects.equals(system, that.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system);
    }
}
