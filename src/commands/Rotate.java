package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за завъртане на изображенията в текущата сесия наляво или надясно.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class Rotate implements Command {

    /**
     * Изпълнява командата за добавяне на трансформация за завъртане.
     * <p>
     * Изисква аргумент "left" или "right" за посоката на завъртане.
     * Ако няма активна сесия или аргументът е невалиден, се извежда съобщение.
     *
     * @param args аргументи на командата, където args[1] трябва да бъде "left" или "right"
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2 || (!args[1].equals("left") && !args[1].equals("right"))) {
            System.out.println("Usage: rotate <left|right>");
            return;
        }
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.addTransformation("rotate " + args[1]);
        } else {
            System.out.println("No active session.");
        }
    }
}
