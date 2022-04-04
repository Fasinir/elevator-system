package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.Logging;

/**
 * @author Filip Piwosz
 */
class HelpCommand implements ElevatorSystemCommand {
    @Override
    public void execute() {
        Logging.info("Available commands: ");
        Logging.info("help - shows available commands ");
        Logging.info("pickup <floor_number> - orders some elevator to <floor_number>");
        Logging.info("push <elevator_id> <target_floor> - equivalent of pushing elevator button, elevator of specified " +
                "id will queue the target floor");
        Logging.info("status - displays status");
        Logging.info("step - performs simulation step");
        Logging.info("draw - draws current simulation");
        Logging.info("exit - leave the simulation");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj != null && getClass() == obj.getClass();
    }
}
