package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorId;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;
import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.StandingState;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
@Test
public class StandingStateTest {

    private static final ElevatorId ELEVATOR_ID = new ElevatorId(0);
    private static final FloorNumber STARTING_FLOOR = new FloorNumber(3);
    private static final ElevatorState STANDING_STATE = new StandingState();

    @Test
    public void update_noFloorNumber_nothingHappens() {
        // Given
        Elevator elevator = new Elevator(ELEVATOR_ID, STARTING_FLOOR, null, STANDING_STATE);
        // When
        elevator.update();
        ElevatorStatus actual = elevator.currentStatus();
        // Then
        ElevatorStatus expected = new ElevatorStatus(ELEVATOR_ID, STARTING_FLOOR, Optional.empty());
        assertEquals(actual, expected);
    }

    @Test
    public void update_elevatorIsOnRightFloor_targetFloorNumberIsEmpty() {
        // Given
        Elevator elevator = new Elevator(ELEVATOR_ID, STARTING_FLOOR, STARTING_FLOOR, STANDING_STATE);
        // When
        elevator.update();
        Optional<FloorNumber> actual = elevator.currentStatus().targetFloor();
        // Then
        Optional<FloorNumber> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}
