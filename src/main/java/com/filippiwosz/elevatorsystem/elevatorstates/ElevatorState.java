package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.Elevator;
import com.filippiwosz.elevatorsystem.FloorNumber;

/**
 * State design pattern
 *
 * @author Filip Piwosz
 */
public interface ElevatorState {

    void update(Elevator elevator);

    static boolean targetFloorIsUp(FloorNumber current, FloorNumber target) {
        return current.value() < target.value();
    }

    static boolean targetFloorIsDown(FloorNumber current, FloorNumber target) {
        return current.value() > target.value();
    }

    static boolean targetFloorHasBeenReached(FloorNumber current, FloorNumber target) {
        return current.equals(target);
    }
}
