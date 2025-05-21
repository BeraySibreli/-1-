package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за запазване на всички изображения от текущата сесия
 * с прилагане на натрупаните трансформации.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class SaveCommand implements Command {

    /**
     * Изпълнява командата за запазване на изображенията в текущата сесия.
     * <p>
     * Ако няма активна сесия, извежда съобщение в конзолата.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.save();
        } else {
            System.out.println("No active session.");
        }
    }
}
