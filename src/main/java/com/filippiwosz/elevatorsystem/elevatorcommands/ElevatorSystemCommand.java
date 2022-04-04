package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystemException;

/**
 * Command design pattern.
 *
 * @author Filip Piwosz
 */
public interface ElevatorSystemCommand {
    void execute() throws ElevatorSystemException;
}
