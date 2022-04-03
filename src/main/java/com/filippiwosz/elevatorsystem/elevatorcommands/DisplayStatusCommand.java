package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorStatus;
import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

import java.util.List;

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
        System.out.println(builder);
    }
}
