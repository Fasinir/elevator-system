package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.Elevator;
import com.filippiwosz.elevatorsystem.ElevatorStatus;
import com.filippiwosz.elevatorsystem.FloorNumber;

/**
 * @author Filip Piwosz
 */
public class GoingUpState implements ElevatorState {
    @Override
    public void update(Elevator elevator) {
        ElevatorStatus currentStatus = elevator.currentStatus();

        if (currentStatus.targetFloor().isPresent()) {
            elevator.moveFloorUp();
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
}
