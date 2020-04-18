package org.lenur;

import org.lenur.command.Command;
import org.lenur.command.CommandFactory;
import org.lenur.input.Input;

public class FileManager {
    public void run(Input input) {
        boolean canExecute = true;

        while (canExecute) {

            String[] args = input.getArgs();

            if (args.length >= 3) {
                String action = args[0];
                String[] params = new String[3];
                System.arraycopy(args, 1, params, 0, args.length - 1);
                Command command = CommandFactory.create(action, params);

                if (command != null) {
                    command.run();
                } else {
                    canExecute = false;
                }
            } else if (args.length == 1 && "exit".equals(args[0])) {
                System.out.print("The program has finished!");
                canExecute = false;
            }
        }
    }
}
