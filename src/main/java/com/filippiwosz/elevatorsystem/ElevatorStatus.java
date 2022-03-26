package com.filippiwosz.elevatorsystem;

import java.util.Optional;

/**
 * @author Filip Piwosz
 */
record ElevatorStatus(ElevatorId id, FloorNumber currentFloor, Optional<FloorNumber> targetFloor) {
}
