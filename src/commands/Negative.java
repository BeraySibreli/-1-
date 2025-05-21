package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за прилагане на негативен ефект върху изображенията в текущата сесия.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class Negative implements Command {

    /**
     * Изпълнява командата за добавяне на трансформация "negative".
     * <p>
     * Ако няма активна сесия, извежда съобщение в конзолата.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.addTransformation("negative");
        } else {
            System.out.println("No active session.");
        }
    }
}
