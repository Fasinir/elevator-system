package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

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
        System.out.println(system.elevatorsString());
    }
}
