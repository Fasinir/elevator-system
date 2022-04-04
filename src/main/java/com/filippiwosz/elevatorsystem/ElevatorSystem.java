package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.datastructures.Elevator;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorId;
import com.filippiwosz.elevatorsystem.datastructures.ElevatorStatus;
import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.System.lineSeparator;

/**
 * The core of the simulation.
 *
 * @author Filip Piwosz
 */
public class ElevatorSystem {

    private static final String INVALID_ELEVATOR_ID = "Invalid elevator ID!";
    private static final String INVALID_FLOOR_NUMBER = "Invalid floor number!";
    private final Map<ElevatorId, Elevator> elevatorsMap;
    private final Map<ElevatorId, ElevatorQueue> elevatorQueues;
    private final int buildingHeight;


    public ElevatorSystem(int numberOfElevators, int buildingHeight) {
        this.elevatorsMap = new HashMap<>();
        this.elevatorQueues = new HashMap<>();
        this.buildingHeight = buildingHeight;
        for (int i = 0; i < numberOfElevators; i++) {
            ElevatorId id = new ElevatorId(i);
            Elevator elevator = new Elevator(id, new FloorNumber(0));
            elevatorsMap.put(id, elevator);
            elevatorQueues.put(id, new ElevatorQueue(new LinkedList<>()));
        }
    }

    /**
     * Searches for the closest and least busy elevator to get to the target floor.
     *
     * @param number - target floor number
     * @throws ElevatorSystemException - when invalid floor number
     */
    public void pickup(FloorNumber number) throws ElevatorSystemException {
        if (!floorNumberIsValid(number)) {
            throw new ElevatorSystemException(INVALID_FLOOR_NUMBER);
        }
        List<Elevator> standingElevators = elevatorsMap.values()
                .stream()
                .filter(elevator -> elevator.currentStatus().targetFloor().isEmpty())
                .toList();
        if (standingElevators.isEmpty()) {
            pickupFromSmallestQueue(number);
        } else {
            Elevator closestElevator = standingElevators
                    .stream()
                    .min(Comparator.comparing(elevator -> abs(elevator.currentStatus().currentFloor()
                            .value() - number.value())))
                    .get();
            ElevatorId id = closestElevator.currentStatus().id();
            ElevatorQueue queue = elevatorQueues.get(id);
            queue.push(number);
        }
    }

    private void pickupFromSmallestQueue(FloorNumber number) {
        ElevatorQueue queue = elevatorQueues.entrySet()
                .stream()
                .min(Comparator.comparing(entry -> {
                    Elevator elevator = elevatorsMap.get(entry.getKey());
                    FloorNumber startFloor = elevator.currentStatus().currentFloor();
                    return entry.getValue().distanceFromFloor(startFloor, number);
                }))
                .get()
                .getValue();
        queue.push(number);
    }

    /**
     * Assigns elevators' their new target floors (from their queues) and then updates them.
     */
    public void step() {
        elevatorsMap.values()
                .stream()
                .filter(elevator -> elevator
                        .currentStatus()
                        .targetFloor()
                        .isEmpty())
                .forEach(elevator -> {
                    ElevatorQueue queue = elevatorQueues.get(elevator.currentStatus().id());
                    if (!queue.isEmpty()) {
                        elevator.targetNewFloor(queue.pop());
                    }
                });
        elevatorsMap.values()
                .forEach(Elevator::update);
    }

    /**
     * @return - a list of each elevator status
     */
    public List<ElevatorStatus> status() {
        return elevatorsMap.values()
                .stream()
                .map(Elevator::currentStatus)
                .toList();
    }

    /**
     * Adds targetFloorNumber to elevator's queue.
     *
     * @param id                - elevator id
     * @param targetFloorNumber - destination for the elevator
     * @throws ElevatorSystemException
     */
    public void pushElevatorButton(ElevatorId id, FloorNumber targetFloorNumber) throws ElevatorSystemException {
        if (!elevatorIdIsValid(id)) {
            throw new ElevatorSystemException(INVALID_ELEVATOR_ID);
        }
        if (!floorNumberIsValid(targetFloorNumber)) {
            throw new ElevatorSystemException(INVALID_FLOOR_NUMBER);
        }
        ElevatorQueue queue = elevatorQueues.get(id);
        queue.push(targetFloorNumber);
    }

    /**
     * @return String of current simulation state.
     */
    public String elevatorsString() {
        StringBuilder builder = new StringBuilder();
        for (int i = buildingHeight; i >= 0; i--) {
            for (int j = 0; j < elevatorsMap.size(); j++) {
                Elevator elevator = elevatorsMap.get(new ElevatorId(j));
                FloorNumber currentFloor = elevator.currentStatus().currentFloor();
                if (currentFloor.value() == i) {
                    builder.append("|").append(elevator);
                } else {
                    builder.append("|___");
                }
            }
            builder.append(lineSeparator());
        }
        return builder.toString();
    }

    private boolean floorNumberIsValid(FloorNumber floorNumber) {
        int val = floorNumber.value();
        return val >= 0 && val <= buildingHeight;
    }

    private boolean elevatorIdIsValid(ElevatorId id) {
        return elevatorsMap.get(id) != null;
    }
}
