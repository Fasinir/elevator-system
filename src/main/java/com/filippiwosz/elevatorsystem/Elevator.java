package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.StandingState;

import java.util.Optional;

/**
 * @author Filip Piwosz
 */
public class Elevator {

    private final ElevatorId id;
    private FloorNumber currentFloor;
    private FloorNumber targetFloor;
    private ElevatorState state;

    Elevator(ElevatorId id, FloorNumber startingFloor) {
        this(id, startingFloor, null, new StandingState());
    }

    Elevator(ElevatorId id, FloorNumber startingFloor, FloorNumber targetFloor, ElevatorState startingState) {
        this.id = id;
        this.currentFloor = startingFloor;
        this.targetFloor = targetFloor;
        this.state = startingState;
    }

    ElevatorStatus currentStatus() {
        return new ElevatorStatus(id, currentFloor, Optional.ofNullable(targetFloor));
    }

    void update() {
        state.update(this);
    }
}
