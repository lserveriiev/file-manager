package org.lenur.command;

public class CommandFactory {
    public static Command create(String type, String[] args) {
        if ("create".equals(type)) {
            return new Create(args);
        }

        if ("read".equals(type)) {
            return new Read(args);
        }

        if ("info".equals(type)) {
            return new Info(args);
        }

        return null;
    }
}
