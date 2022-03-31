package com.filippiwosz.elevatorsystem;

/**
 * @author Filip Piwosz
 */
class StepCommand implements ElevatorSystemCommand {
    final ElevatorSystem system;

    public StepCommand(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        system.step();
    }
}
