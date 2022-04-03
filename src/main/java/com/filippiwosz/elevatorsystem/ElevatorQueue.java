package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.datastructures.FloorNumber;

import java.util.Deque;

/**
 * @author Filip Piwosz
 */
class ElevatorQueue {
    private final Deque<FloorNumber> queue;

    ElevatorQueue(Deque<FloorNumber> queue) {
        this.queue = queue;
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }

    FloorNumber pop() {
        return queue.pollFirst();
    }

    FloorNumber peek() {
        return queue.peekFirst();
    }

    void push(FloorNumber number) {
        queue.push(number);
    }

    int distanceFromFloor(FloorNumber startingFloor, FloorNumber targetFloor) {
        int count = 0;
        FloorNumber prev = startingFloor;
        for (FloorNumber number : queue) {
            FloorNumber next = number;
            count += Math.abs(prev.value() - next.value());
            prev = next;
        }
        count += Math.abs(queue.getLast().value() - targetFloor.value());
        return count;
    }

}
