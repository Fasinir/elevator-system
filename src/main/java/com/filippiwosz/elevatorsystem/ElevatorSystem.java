package com.filippiwosz.elevatorsystem;

import java.util.List;

/**
 * @author Filip Piwosz
 */
class ElevatorSystem {

    private final List<Elevator> elevators;

    ElevatorSystem(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    void pickup(FloorNumber number, ElevatorDirection direction) {
        throw new UnsupportedOperationException();
    }

    void step() {
        throw new UnsupportedOperationException();
    }

    List<ElevatorStatus> status() {
        throw new UnsupportedOperationException();
    }
}
