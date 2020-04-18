package org.lenur;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
    protected final Path path;
    protected final String pathToFile;

    public FileHelper(String path, String filename) {
        this.pathToFile = String.format("%s/%s", path, filename);
        this.path = Paths.get(this.pathToFile);
    }

    public boolean fileExist() {
        return Files.exists(this.path);
    }

    public String getText() {
        try {
            return Files.readString(this.path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public long getFileSize() {
        try {
            return Files.size(this.path);
        } catch (IOException e) {
            return 0;
        }
    }
}
