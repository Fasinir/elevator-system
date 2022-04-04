package com.filippiwosz.elevatorsystem.elevatorstates;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

/**
 * State design pattern
 *
 * @author Filip Piwosz
 */
public interface ElevatorState {

    static boolean targetFloorIsUp(FloorNumber current, FloorNumber target) {
        return current.value() < target.value();
    }

    static boolean targetFloorIsDown(FloorNumber current, FloorNumber target) {
        return current.value() > target.value();
    }

    static boolean targetFloorHasBeenReached(FloorNumber current, FloorNumber target) {
        return current.equals(target);
    }

    void update(Elevator elevator);
}
