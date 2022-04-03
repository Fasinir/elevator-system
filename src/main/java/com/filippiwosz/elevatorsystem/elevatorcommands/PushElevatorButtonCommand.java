package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorId;
import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.FloorNumber;

/**
 * @author Filip Piwosz
 */
class PushElevatorButtonCommand implements ElevatorSystemCommand {

    final ElevatorSystem system;
    final ElevatorId elevatorId;
    final FloorNumber targetFloor;

    public PushElevatorButtonCommand(ElevatorSystem system, int elevatorId, int targetFloor) {
        this.system = system;
        this.elevatorId = new ElevatorId(elevatorId);
        this.targetFloor = new FloorNumber(targetFloor);
    }

    @Override
    public void execute() {
        system.pushElevatorButton(elevatorId, targetFloor);
    }
}
