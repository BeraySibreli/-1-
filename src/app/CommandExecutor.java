package app;

import java.util.HashMap;
import java.util.Map;
import commands.*;

public class CommandExecutor {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandExecutor() {
        commands.put("help", new HelpCommand());
        commands.put("load", new LoadCommand());
        commands.put("add", new AddCommand());
        commands.put("grayscale", new Grayscale());
        commands.put("monochrome", new Monochrome());
        commands.put("negative", new Negative());
        commands.put("rotate", new Rotate());
        commands.put("save", new SaveCommand());
        commands.put("saveas", new SaveAsCommand());
        commands.put("undo", new UndoCommand());
        commands.put("session", new SessionInfoCommand());
        commands.put("switch", new SwitchCommand());
        commands.put("collage", new CollageCommand());
        commands.put("close", new CloseCommand());
    }

    public void execute(String input) {
        if (input.isEmpty()) return;
        String[] parts = input.split("\\s+");
        String commandName = parts[0];

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(parts);
        } else {
            System.out.println("Unknown command: " + commandName);
        }
    }
}
