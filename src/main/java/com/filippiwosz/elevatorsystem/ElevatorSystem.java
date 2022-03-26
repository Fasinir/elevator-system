package com.filippiwosz.elevatorsystem;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    void update(ElevatorId id, FloorNumber oldNumber, FloorNumber newNumber) {
        throw new UnsupportedOperationException();
    }

    void step() {
        throw new UnsupportedOperationException();
    }

    List<ElevatorStatus> status() {
        throw new UnsupportedOperationException();
    }
}
