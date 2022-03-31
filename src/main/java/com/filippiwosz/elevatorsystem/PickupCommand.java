package com.filippiwosz.elevatorsystem;

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
        ElevatorDirection elevatorDirection = ElevatorDirection.valueOf(splitted[1].toUpperCase());

        system.pickup(new FloorNumber(floorNumber), elevatorDirection);
    }
}
