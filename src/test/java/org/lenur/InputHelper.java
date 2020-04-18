package org.lenur;

import org.lenur.input.Input;

public class InputHelper implements Input {
    private final String[][] args;
    private int index = 0;

    public InputHelper(String[][] args) {
        this.args = args;
    }

    @Override
    public String[] getArgs() {
        return args[index++];
    }
}
