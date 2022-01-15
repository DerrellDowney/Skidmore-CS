package edu.skidmore.cs226.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command: Translated book example (page 241)
 * <p>
 * Supports a list of commands which may be executed in sequence my calling the
 * execute method.
 * </p>
 * 
 * @author readda
 */
public class MacroCommand extends Command {
    private List<Command> cmds;

    public MacroCommand() {
        cmds = new ArrayList<>();
    }

    public void add(Command cmd) {
        cmds.add(cmd);
    }

    public void remove(Command cmd) {
        cmds.remove(cmd);
    }

    @Override
    public void execute() {
        for (Command c : cmds) {
            c.execute();
        }

    }

}
