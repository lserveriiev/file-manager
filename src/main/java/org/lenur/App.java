package org.lenur;

import org.lenur.input.ScannerInput;

public class App {
    public static void main(String[] args) {
        FileManager editor = new FileManager();
        editor.run(new ScannerInput());
    }
}
