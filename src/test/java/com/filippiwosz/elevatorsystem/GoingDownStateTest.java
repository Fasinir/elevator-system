package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.GoingDownState;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
public class GoingDownStateTest {
    private static final ElevatorId ELEVATOR_ID = new ElevatorId(0);
    private static final FloorNumber STARTING_FLOOR = new FloorNumber(3);
    private static final ElevatorState GOING_DOWN_STATE = new GoingDownState();


    @Test
    public void update_targetFloorBelowCurrentFloor_currentFloorDecreases() {
        // Given
        FloorNumber floorNumber = new FloorNumber(STARTING_FLOOR.value() - 2);
        Elevator elevator = new Elevator(ELEVATOR_ID, STARTING_FLOOR, floorNumber, GOING_DOWN_STATE);
        // When
        elevator.update();
        // Then
        FloorNumber expected = new FloorNumber(STARTING_FLOOR.value() - 1);
        FloorNumber actual = elevator.currentStatus().currentFloor();

        assertEquals(actual, expected);
    }

    @Test
    public void update_targetFloorIsJustOneFloorDown_transitionsToStandingState() {
        // Given
        FloorNumber targetFloor = new FloorNumber(STARTING_FLOOR.value() - 1);
        Elevator elevator = new Elevator(ELEVATOR_ID, STARTING_FLOOR, targetFloor, GOING_DOWN_STATE);
        // When
        elevator.update();
        elevator.update();
        // Then
        ElevatorStatus expected = new ElevatorStatus(ELEVATOR_ID, targetFloor, Optional.empty());
        ElevatorStatus actual = elevator.currentStatus();
        Assert.assertEquals(actual, expected);
    }
}
