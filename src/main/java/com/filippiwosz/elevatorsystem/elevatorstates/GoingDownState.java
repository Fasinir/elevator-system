package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

/**
 * @author Filip Piwosz
 */
public class GoingDownState implements ElevatorState {
    @Override
    public void update(Elevator elevator) {
        ElevatorStatus currentStatus = elevator.currentStatus();

        if (currentStatus.targetFloor().isPresent()) {
            elevator.moveFloorDown();
            currentStatus = elevator.currentStatus();
            FloorNumber currentFloor = currentStatus.currentFloor();
            FloorNumber targetFloor = currentStatus.targetFloor().get();

            if (ElevatorState.targetFloorHasBeenReached(currentFloor, targetFloor)) {
                elevator.targetNewFloor(null);
                elevator.changeState(new StandingState());
            }
        } else {
            elevator.changeState(new StandingState());
        }
    }

    @Override
    public String toString() {
        return "D";
    }
}
