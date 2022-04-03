package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorException;

/**
 * @author Filip Piwosz
 */
public class ElevatorCommandException extends ElevatorException {
    ElevatorCommandException(String message) {
        super(message);
    }
}
