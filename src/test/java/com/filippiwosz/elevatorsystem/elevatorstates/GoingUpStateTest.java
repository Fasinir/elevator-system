package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorId;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;
import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.GoingUpState;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
@Test
public class GoingUpStateTest {
    private static final ElevatorId ELEVATOR_ID = new ElevatorId(0);
    private static final FloorNumber STARTING_FLOOR = new FloorNumber(3);
    private static final ElevatorState GOING_UP_STATE = new GoingUpState();


    @Test
    public void update_targetFloorAboveCurrentFloor_currentFloorIncreases() {
        // Given
        FloorNumber floorNumber = new FloorNumber(STARTING_FLOOR.value() + 2);
        Elevator elevator = new Elevator(ELEVATOR_ID, STARTING_FLOOR, floorNumber, GOING_UP_STATE);
        // When
        elevator.update();
        FloorNumber actual = elevator.currentStatus().currentFloor();
        // Then
        FloorNumber expected = new FloorNumber(STARTING_FLOOR.value() + 1);
        assertEquals(actual, expected);
    }

    @Test
    public void update_targetFloorIsJustOneFloorDown_transitionsToStandingState() {
        // Given
        FloorNumber targetFloor = new FloorNumber(STARTING_FLOOR.value() + 1);
        Elevator elevator = new Elevator(ELEVATOR_ID, STARTING_FLOOR, targetFloor, GOING_UP_STATE);
        // When
        elevator.update();
        elevator.update();
        ElevatorStatus actual = elevator.currentStatus();
        // Then
        ElevatorStatus expected = new ElevatorStatus(ELEVATOR_ID, targetFloor, Optional.empty());
        assertEquals(actual, expected);
    }
}
