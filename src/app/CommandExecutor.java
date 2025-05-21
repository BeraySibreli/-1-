package app;

import java.util.*;
import commands.*;

/**
 * Отговаря за регистрирането и изпълнението на команди, подадени като текстов вход.
 * <p>
 * Поддържа асоциативна структура (Map), която свързва име на команда с нейния {@link Command} обект.
 */
public class CommandExecutor {

    /**
     * Речник от имена на команди към техните съответни обекти.
     */
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Конструктор, който регистрира всички налични команди.
     * <p>
     * Добавят се: help, load, add, grayscale, monochrome, negative, rotate, save, saveas, undo,
     * session, switch, collage, close.
     */
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

    /**
     * Изпълнява команда на базата на подаден текстов вход.
     * <p>
     * Входът се разделя на име на команда и аргументи. Ако командата е известна, се изпълнява;
     * в противен случай се извежда съобщение за грешка.
     *
     * @param input пълният вход от потребителя като низ (напр. "add image1.png")
     */
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
