package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

import static com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState.targetFloorIsDown;
import static com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState.targetFloorIsUp;

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
                elevator.changeState(new GoingUpState());
            } else if (targetFloorIsDown(currentFloor, targetFloor)) {
                elevator.changeState(new GoingDownState());
            } else {
                elevator.targetNewFloor(null);
            }
        }
    }

    @Override
    public String toString() {
        return "S";
    }
}
