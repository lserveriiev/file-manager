package org.lenur.command;

import java.io.IOException;
import java.nio.file.Files;
import org.lenur.helper.Text;

public class Info extends Command {
    public Info(final String[] arg) {
        super(arg);
    }

    @Override
    public void run() {
        String text = "";
        String lastModified = "";
        long fileSize = 0;

        if (Files.exists(this.path)) {
            try {
                text = Files.readString(this.path);
                lastModified = Files.getLastModifiedTime(this.path).toString();
                fileSize = Files.size(this.path);
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }

        String builder = String.format("Count of symbols: %d \n", text.length()) +
                String.format("Count of words: %d \n", Text.countWords(text)) +
                String.format("Last modified: %s \n", lastModified) +
                String.format("Size of the file: %d", fileSize);
        System.out.print(builder);
    }
}
