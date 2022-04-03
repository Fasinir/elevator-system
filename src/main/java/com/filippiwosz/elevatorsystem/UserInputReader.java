package com.filippiwosz.elevatorsystem;

import java.util.Scanner;

/**
 * @author Filip Piwosz
 */
class UserInputReader {
    private final Scanner scanner;

    public UserInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
