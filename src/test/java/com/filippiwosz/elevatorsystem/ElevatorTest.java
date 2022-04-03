package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
public class ElevatorTest {

    @Test(dataProvider = "regularConstructorParameters", dataProviderClass = ElevatorStaticProvider.class)
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

    @Test(dataProvider = "simplifiedConstructorParameters", dataProviderClass = ElevatorStaticProvider.class)
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

    @Test(dataProvider = "simplifiedConstructorParameters", dataProviderClass = ElevatorStaticProvider.class)
    public void moveFloorUp_properFloorNumber_floorNumberIncreases(int id, int currentFloorNumber) {
        // Given
        Elevator elevator = new Elevator(id, currentFloorNumber);
        // When
        elevator.moveFloorUp();
        int actual = elevator.currentStatus()
                .currentFloor()
                .value();
        // Then
        int expected = currentFloorNumber + 1;
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "simplifiedConstructorParameters", dataProviderClass = ElevatorStaticProvider.class)
    public void moveFloorDown_properFloorNumber_floorNumberDecreases(int id, int currentFloorNumber) {
        // Given
        Elevator elevator = new Elevator(id, currentFloorNumber);
        // When
        elevator.moveFloorDown();
        int actual = elevator.currentStatus()
                .currentFloor()
                .value();
        // Then
        int expected = currentFloorNumber - 1;
        assertEquals(actual, expected);
    }
}
