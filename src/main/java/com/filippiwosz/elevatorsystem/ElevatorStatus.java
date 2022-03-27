package com.filippiwosz.elevatorsystem;

import java.util.Optional;

/**
 * @author Filip Piwosz
 */
public record ElevatorStatus(ElevatorId id, FloorNumber currentFloor, Optional<FloorNumber> targetFloor) {
    ElevatorStatus(int id, int currentFloor, int targetFloor) {
        this(new ElevatorId(id), new FloorNumber(currentFloor), Optional.of(new FloorNumber(targetFloor)));
    }

    public ElevatorStatus(int id, int currentFloorNumber) {
        this(new ElevatorId(id), new FloorNumber(currentFloorNumber), Optional.empty());
    }
}
