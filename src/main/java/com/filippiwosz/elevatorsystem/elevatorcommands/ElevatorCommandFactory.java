package com.filippiwosz.elevatorsystem.elevatorcommands;

/**
 * Factory method design pattern
 *
 * @author Filip Piwosz
 */
public interface ElevatorCommandFactory {

    ElevatorSystemCommand createCommandFromInput(String input) throws ElevatorCommandException;

}
