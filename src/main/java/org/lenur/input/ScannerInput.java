package org.lenur.input;

import java.util.Scanner;

public class ScannerInput implements Input {
    final Scanner scanner;

    public ScannerInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String[] getArgs() {
        return this.scanner.nextLine().split("\\s+");
    }
}
