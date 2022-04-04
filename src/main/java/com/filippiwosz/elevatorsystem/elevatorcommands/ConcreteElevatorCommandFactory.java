package com.filippiwosz.elevatorsystem.elevatorcommands;

import com.filippiwosz.elevatorsystem.ElevatorSystem;

import java.util.Locale;

/**
 * @author Filip Piwosz
 */
public class ConcreteElevatorCommandFactory implements ElevatorCommandFactory {
    private final ElevatorSystem system;

    public ConcreteElevatorCommandFactory(ElevatorSystem system) {
        this.system = system;
    }

    @Override
    public ElevatorSystemCommand createCommandFromInput(String input) throws ElevatorCommandException {
        String lowerCase = input.toLowerCase(Locale.ROOT);
        String[] splitted = lowerCase.split(" ");
        try {
            switch (splitted[0]) {
                case "status":
                    return new DisplayStatusCommand(system);
                case "draw":
                    return new DrawElevatorsCommand(system);
                case "pickup":
                    return new PickupCommand(system, Integer.parseInt(splitted[1]));
                case "push":
                    int id = Integer.parseInt(splitted[1]);
                    int floor = Integer.parseInt(splitted[2]);
                    return new PushElevatorButtonCommand(system, id, floor);
                case "step":
                    return new StepCommand(system);
                case "help":
                    return new HelpCommand();
                default:
                    throw new ElevatorCommandException("No such command exists!");
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new ElevatorCommandException("Invalid command structure!");
        }
    }
}
