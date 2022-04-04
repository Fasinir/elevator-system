package com.filippiwosz.elevatorsystem;

import com.filippiwosz.elevatorsystem.elevatorcommands.ConcreteElevatorCommandFactory;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorCommandFactory;
import com.filippiwosz.elevatorsystem.elevatorcommands.ElevatorSystemCommand;

import java.util.Scanner;

/**
 * @author Filip Piwosz
 */
public class Main {
    private static final int DEFAULT_FLOORS = 5;
    private static final int DEFAULT_ELEVATORS = 5;


    public static void main(String[] args) {
        UserInputReader reader = new UserInputReader(new Scanner(System.in));

        int numberOfFloors = DEFAULT_FLOORS;
        int numberOfElevators = DEFAULT_ELEVATORS;
        try {
            if (args.length >= 1) {
                numberOfFloors = Integer.parseInt(args[0]);
                if (args.length >= 2) {
                    numberOfElevators = Integer.parseInt(args[1]);
                }
            }
        } catch (NumberFormatException e) {
            Logging.error("Error parsing input arguments, assigning default values");
        }
        Logging.info("Simulating elevator system for " + numberOfElevators + " number of elevators and " +
                numberOfFloors + " number of floors");
        String input;
        ElevatorSystem system = new ElevatorSystem(numberOfElevators, numberOfFloors);
        ElevatorCommandFactory factory = new ConcreteElevatorCommandFactory(system);
        while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
            ElevatorSystemCommand command;
            try {
                command = factory.createCommandFromInput(input);
                command.execute();
            } catch (ElevatorException e) {
                Logging.error(e.getMessage());
            }
        }


    }


}
