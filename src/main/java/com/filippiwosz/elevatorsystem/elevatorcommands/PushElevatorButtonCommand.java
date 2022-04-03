package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorId;
import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.FloorNumber;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

/**
 * @author Filip Piwosz
 */
class PushElevatorButtonCommand implements ElevatorSystemCommand {

    final ElevatorSystem system;
    final String data;

    public PushElevatorButtonCommand(ElevatorSystem system, String data) {
        this.system = system;
        this.data = data;
    }

    @Override
    public void execute() {
        String[] splitted = data.split(" ");
        int elevatorId = Integer.parseInt(splitted[0]);
        int targetFloor = Integer.parseInt(splitted[1]);

        system.pushElevatorButton(new ElevatorId(elevatorId), new FloorNumber(targetFloor));
    }
}
