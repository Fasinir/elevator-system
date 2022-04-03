package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

/**
 * Factory method design pattern
 *
 * @author Filip Piwosz
 */
public interface ElevatorCommandFactory {

    public ElevatorSystemCommand createCommandFromInput(String input) throws ElevatorCommandException;

}
