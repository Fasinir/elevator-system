package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Filip Piwosz
 */
@Test
public class ConcreteElevatorCommandFactoryTest {
    private static final ElevatorSystem ELEVATOR_SYSTEM = new ElevatorSystem(10, 10);

    @DataProvider
    public Object[][] properInputStringAndExpectedCommand() {
        return new Object[][]{
                {"status", new DisplayStatusCommand(ELEVATOR_SYSTEM)},
                {"draw", new DrawElevatorsCommand(ELEVATOR_SYSTEM)},
                {"push 1 1", new PushElevatorButtonCommand(ELEVATOR_SYSTEM, 1, 1)},
                {"push 0 0", new PushElevatorButtonCommand(ELEVATOR_SYSTEM, 0, 0)},
                {"pickup 0", new PickupCommand(ELEVATOR_SYSTEM, 0)},
                {"pickup 1", new PickupCommand(ELEVATOR_SYSTEM, 1)},
                {"help", new HelpCommand()},
                {"step", new StepCommand(ELEVATOR_SYSTEM)}
        };
    }

    @Test(dataProvider = "properInputStringAndExpectedCommand")
    public void createCommandFromInput_properInput_actualEqualsExpected(String input, ElevatorSystemCommand expected) {
        // Given
        ConcreteElevatorCommandFactory factory = new ConcreteElevatorCommandFactory(ELEVATOR_SYSTEM);
        // When
        ElevatorSystemCommand actual = null;
        try {
            actual = factory.createCommandFromInput(input);
        } catch (ElevatorCommandException e) {
        }
        // Then
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] wrongInputStrings() {
        return new Object[][]{
                {""}, {"push    "}, {"push 2"}, {"pushh"}, {" help"}, {"stattus"},
                {"pickup   "}, {"pickupp"}, {"dddraw"}
        };
    }

    @Test(dataProvider = "wrongInputStrings", expectedExceptions = {ElevatorCommandException.class})
    public void createCommandFromInput_improperInput_throwsElevatorCommandException(String wrongInput)
            throws ElevatorCommandException {
        // Given
        ConcreteElevatorCommandFactory factory = new ConcreteElevatorCommandFactory(ELEVATOR_SYSTEM);
        // When
        factory.createCommandFromInput(wrongInput);
        // Then
    }
}
