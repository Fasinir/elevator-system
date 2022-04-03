package com.filippiwosz.elevatorsystem;

/**
 * Factory method design pattern
 *
 * @author Filip Piwosz
 */
interface ElevatorCommandFactory {

    ElevatorSystemCommand createCommandFromInput(String input);

}
