package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за затваряне на текущата активна сесия.
 * <p>
 * Извиква метода {@link Session#close()} и премахва сесията от {@link SessionManager}.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class CloseCommand implements Command {

    /**
     * Изпълнява командата за затваряне на текущата сесия.
     * <p>
     * Ако няма активна сесия, извежда съобщение в конзолата.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.close();
            SessionManager.getInstance().removeCurrentSession();
        } else {
            System.out.println("No active session.");
        }
    }
}
