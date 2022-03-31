package com.filippiwosz.elevatorsystem;

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

    void push(FloorNumber number) {
        queue.push(number);
    }

    int size() {
        return queue.size();
    }

}
