package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.ElevatorSystemException;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

import java.util.Objects;

/**
 * @author Filip Piwosz
 */
class PickupCommand implements ElevatorSystemCommand {

    final ElevatorSystem system;
    final FloorNumber floorNumber;

    public PickupCommand(ElevatorSystem system, int floorNumber) {
        this.system = system;
        this.floorNumber = new FloorNumber(floorNumber);
    }

    @Override
    public void execute() throws ElevatorSystemException {
        system.pickup(floorNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PickupCommand that = (PickupCommand) o;
        return Objects.equals(system, that.system) && Objects.equals(floorNumber, that.floorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system, floorNumber);
    }
}
