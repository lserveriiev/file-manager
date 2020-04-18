package org.lenur.command;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Create extends Command {
    public Create(String[] arg) {
        super(arg);
    }

    @Override
    public void run() {
        this.createFile();
        this.writeToFile();
    }

    private void createFile() {
        if (!Files.exists(this.path)) {
            try {
                Files.createFile(this.path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void writeToFile() {
        try (FileWriter writer = new FileWriter(this.pathToFile)) {
            writer.write(this.text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
