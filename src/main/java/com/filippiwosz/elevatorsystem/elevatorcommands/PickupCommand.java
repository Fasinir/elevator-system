package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

/**
 * @author Filip Piwosz
 */
class PickupCommand implements ElevatorSystemCommand {

    final ElevatorSystem system;
    final String data;

    public PickupCommand(ElevatorSystem system, String data) {
        this.system = system;
        this.data = data;
    }

    @Override
    public void execute() {
        String[] splitted = data.split(" ");
        int floorNumber = Integer.parseInt(splitted[0]);

        system.pickup(new FloorNumber(floorNumber));
    }
}
