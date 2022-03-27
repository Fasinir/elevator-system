package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.Elevator;

/**
 * State design pattern
 *
 * @author Filip Piwosz
 */
public interface ElevatorState {

    void update(Elevator elevator);
}
