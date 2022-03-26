package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.StandingState;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
@Test
class ElevatorTest {

    @DataProvider
    public Object[][] constructorParametersAndExpectedStatus() {

        ElevatorId idAlpha = new ElevatorId(0);
        ElevatorId idBeta = new ElevatorId(1);

        FloorNumber floorNumberAlpha = new FloorNumber(0);
        FloorNumber floorNumberBeta = new FloorNumber(1);
        FloorNumber floorNumberGamma = new FloorNumber(2);
        FloorNumber floorNumberDelta = new FloorNumber(3);

        ElevatorState standing = new StandingState();

        return new Object[][]{
                {idAlpha, floorNumberAlpha, floorNumberBeta, standing,
                        new ElevatorStatus(idAlpha, floorNumberAlpha, Optional.of(floorNumberBeta))},
                {idBeta, floorNumberBeta, floorNumberGamma, standing,
                        new ElevatorStatus(idBeta, floorNumberBeta, Optional.of(floorNumberGamma))},
                {idBeta, floorNumberDelta, null, standing,
                        new ElevatorStatus(idBeta, floorNumberDelta, Optional.empty())}
        };
    }

    @Test(dataProvider = "constructorParametersAndExpectedStatus")
    public void currentStatus_givenProperConstructorParameters_actualEqualsExpected(
            ElevatorId id, FloorNumber current, FloorNumber target, ElevatorState state, ElevatorStatus expected) {
        // Given
        Elevator elevator = new Elevator(id, current, target, state);
        // When
        ElevatorStatus actual = elevator.currentStatus();
        // Then
        assertEquals(actual, expected);
    }
}
