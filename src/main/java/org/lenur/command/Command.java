package org.lenur.command;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Command {
    protected final String text;
    protected final Path path;
    protected final String pathToFile;

    public Command(String[] arg) {
        final String path = arg[0];
        final String filename = arg[1];
        this.text = arg.length > 2 ? arg[2] : "";
        this.pathToFile = String.format("%s/%s", path, filename);
        this.path = Paths.get(this.pathToFile);
    }

    public abstract void run();
}
