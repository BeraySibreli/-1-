package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за извеждане на информация относно текущата сесия.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class SessionInfoCommand implements Command {

    /**
     * Изпълнява командата за показване на информация за текущата сесия.
     * <p>
     * Ако няма активна сесия, се извежда съобщение в конзолата.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.showInfo();
        } else {
            System.out.println("No active session.");
        }
    }
}
