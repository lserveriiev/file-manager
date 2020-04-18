package org.lenur.command;

import java.io.IOException;
import java.nio.file.Files;

public class Read extends Command {
    public Read(String[] arg) {
        super(arg);
    }

    @Override
    public void run() {
        String text = "";

        try {
            text = Files.readString(this.path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.print(text);
    }
}
