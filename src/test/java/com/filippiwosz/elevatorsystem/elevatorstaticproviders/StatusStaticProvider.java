package com.filippiwosz.elevatorsystem.elevatorstaticproviders;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.StandingState;
import org.testng.annotations.DataProvider;

/**
 * @author Filip Piwosz
 */
public class StatusStaticProvider {

    @DataProvider
    public static Object[][] regularConstructorParameters() {
        ElevatorState standing = new StandingState();
        return new Object[][]{
                {0, 0, 1, standing},
                {1, 1, 2, standing},
                {1, 3, 2, standing}
        };
    }

    @DataProvider
    public static Object[][] simplifiedConstructorParameters() {
        return new Object[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };
    }

}
