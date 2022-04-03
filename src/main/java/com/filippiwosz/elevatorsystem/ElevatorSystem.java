package com.filippiwosz.elevatorsystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Filip Piwosz
 */
class ElevatorSystem {

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

    void pickup(FloorNumber number) {
        throw new UnsupportedOperationException();
    }

    void step() {
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

    List<ElevatorStatus> status() {
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
