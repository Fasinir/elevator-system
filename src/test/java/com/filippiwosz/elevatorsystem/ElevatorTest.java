package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstaticproviders.StatusStaticProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
@Test
class ElevatorTest {

    @Test(dataProvider = "regularConstructorParameters", dataProviderClass = StatusStaticProvider.class)
    public void currentStatus_properConstructorParameters_actualEqualsExpected(
            int id, int currentFloorNumber, int targetFloorNumber, ElevatorState state) {
        // Given
        Elevator elevator = new Elevator(id, currentFloorNumber, targetFloorNumber, state);
        // When
        ElevatorStatus actual = elevator.currentStatus();
        // Then
        ElevatorStatus expected = new ElevatorStatus(id, currentFloorNumber, targetFloorNumber);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "simplifiedConstructorParameters", dataProviderClass = StatusStaticProvider.class)
    public void currentStatus_properSimplifiedConstructorParameters_actualEqualsExpected(
            int id, int currentFloorNumber) {
        // Given
        Elevator elevator = new Elevator(id, currentFloorNumber);
        // When
        ElevatorStatus actual = elevator.currentStatus();
        // Then
        ElevatorStatus expected = new ElevatorStatus(id, currentFloorNumber);
        assertEquals(actual, expected);
    }
}
