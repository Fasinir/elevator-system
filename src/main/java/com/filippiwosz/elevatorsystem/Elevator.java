package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.StandingState;

import java.util.Optional;

/**
 * @author Filip Piwosz
 */
class Elevator {

    private final ElevatorId id;
    private FloorNumber currentFloor;
    private Optional<FloorNumber> targetFloor;
    private ElevatorState state;

    Elevator(ElevatorId id, FloorNumber startingFloor) {
        this(id, startingFloor, Optional.empty(), new StandingState());
    }

    Elevator(ElevatorId id, FloorNumber startingFloor, Optional<FloorNumber> targetFloor, ElevatorState startingState) {
        this.id = id;
        this.currentFloor = startingFloor;
        this.targetFloor = targetFloor;
        this.state = startingState;
    }
}
