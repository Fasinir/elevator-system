package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.Elevator;
import com.filippiwosz.elevatorsystem.ElevatorStatus;
import com.filippiwosz.elevatorsystem.FloorNumber;

/**
 * @author Filip Piwosz
 */
public class StandingState implements ElevatorState {
    @Override
    public void update(Elevator elevator) {
        ElevatorStatus status = elevator.currentStatus();
        if (status.targetFloor().isPresent()) {
            FloorNumber targetFloor = status.targetFloor().get();
            FloorNumber currentFloor = status.currentFloor();

            if (targetFloorIsUp(currentFloor, targetFloor)) {
            } else if (targetFloorIsDown(currentFloor, targetFloor)) {

            } else {

            }
        }
    }

    private boolean targetFloorIsUp(FloorNumber currentFloor, FloorNumber targetFloor) {
        return currentFloor.value() < targetFloor.value();
    }

    private boolean targetFloorIsDown(FloorNumber currentFloor, FloorNumber targetFloor) {
        return currentFloor.value() > targetFloor.value();
    }
}
