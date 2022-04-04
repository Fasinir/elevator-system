package com.filippiwosz.elevatorsystem;

/**
 * Is thrown by ElevatorSystem methods
 *
 * @author Filip Piwosz
 * @see ElevatorSystem
 */
public class ElevatorSystemException extends ElevatorException {
    public ElevatorSystemException(String msg) {
        super(msg);
    }
}
