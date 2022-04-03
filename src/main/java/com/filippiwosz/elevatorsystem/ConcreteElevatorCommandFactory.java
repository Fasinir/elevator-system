package com.filippiwosz.elevatorsystem;

/**
 * @author Filip Piwosz
 */
class ConcreteElevatorCommandFactory implements ElevatorCommandFactory {
    private final ElevatorSystem system;

    ConcreteElevatorCommandFactory(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public ElevatorSystemCommand createCommandFromInput(String input) {
        return null;
    }
}
