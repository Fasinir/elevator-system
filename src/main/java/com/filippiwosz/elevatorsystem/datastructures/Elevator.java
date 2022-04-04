package com.filippiwosz.elevatorsystem.datastructures;

import com.filippiwosz.elevatorsystem.elevatorstates.ElevatorState;
import com.filippiwosz.elevatorsystem.elevatorstates.StandingState;

import java.util.Optional;

/**
 * @author Filip Piwosz
 */
public class Elevator {

    private final ElevatorId id;
    private FloorNumber currentFloor;
    private FloorNumber targetFloor;
    private ElevatorState state;

    public Elevator(int id, int startingFloor) {
        this(new ElevatorId(id), new FloorNumber(startingFloor), null, new StandingState());
    }

    public Elevator(ElevatorId id, FloorNumber startingFloor) {
        this(id, startingFloor, null, new StandingState());
    }

    public Elevator(int id, int startingFloor, int targetFloor, ElevatorState startingState) {
        this(new ElevatorId(id), new FloorNumber(startingFloor), new FloorNumber(targetFloor), startingState);
    }

    public Elevator(ElevatorId id, FloorNumber startingFloor, FloorNumber targetFloor, ElevatorState startingState) {
        this.id = id;
        this.currentFloor = startingFloor;
        this.targetFloor = targetFloor;
        this.state = startingState;
    }

    public ElevatorStatus currentStatus() {
        return new ElevatorStatus(id, currentFloor, Optional.ofNullable(targetFloor));
    }

    /**
     * State design pattern method.
     */
    public void update() {
        state.update(this);
    }

    public void moveFloorUp() {
        currentFloor = new FloorNumber(currentFloor.value() + 1);
    }

    public void moveFloorDown() {
        currentFloor = new FloorNumber(currentFloor.value() - 1);
    }

    /**
     * @param floorNumber - new target floor, can be null which indicates there is no target floor now
     */
    public void targetNewFloor(FloorNumber floorNumber) {
        targetFloor = floorNumber;
    }

    public void changeState(ElevatorState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id.value() + state.toString() + (id.value() < 10 ? "_" : "");
    }
}
