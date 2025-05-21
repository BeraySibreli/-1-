package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за прилагане на трансформация в сиво (grayscale) върху изображенията в текущата сесия.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class Grayscale implements Command {

    /**
     * Изпълнява командата за добавяне на трансформация "grayscale".
     * <p>
     * Ако няма активна сесия, се извежда съобщение в конзолата.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.addTransformation("grayscale");
        } else {
            System.out.println("No active session.");
        }
    }
}
