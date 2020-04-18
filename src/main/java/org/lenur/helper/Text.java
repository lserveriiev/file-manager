package org.lenur.helper;

public class Text {
    public static int countWords(String text) {
        if (text.length() == 0) {
            return 0;
        }

        String[] words = text.split("\\s+");

        return words.length;
    }
}
