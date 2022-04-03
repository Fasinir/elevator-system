package com.filippiwosz.elevatorsystem;

import java.util.*;

import static java.lang.Math.abs;

/**
 * @author Filip Piwosz
 */
public class ElevatorSystem {

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

    public void pickup(FloorNumber number) {
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

    public void step() {
        elevatorsMap.values()
                .forEach(Elevator::update);
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
    }

    public List<ElevatorStatus> status() {
        return elevatorsMap.values()
                .stream()
                .map(Elevator::currentStatus)
                .toList();
    }

    public void pushElevatorButton(ElevatorId id, FloorNumber targetFloorNumber) {
        ElevatorQueue queue = elevatorQueues.get(id);
        queue.push(targetFloorNumber);
    }

    public String elevatorsString() {
        return null;
    }
}
