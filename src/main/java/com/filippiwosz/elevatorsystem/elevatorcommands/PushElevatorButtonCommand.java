package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystemException;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorId;
import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

import java.util.Objects;

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
    public void execute() throws ElevatorSystemException {
        system.pushElevatorButton(elevatorId, targetFloor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PushElevatorButtonCommand that = (PushElevatorButtonCommand) o;
        return Objects.equals(system, that.system) && Objects.equals(elevatorId, that.elevatorId) && Objects.equals(targetFloor, that.targetFloor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system, elevatorId, targetFloor);
    }
}
