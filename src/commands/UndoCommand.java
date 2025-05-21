package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за отмяна на последната трансформация в активната сесия.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class UndoCommand implements Command {

    /**
     * Изпълнява командата за отмяна на последната трансформация.
     * <p>
     * Ако няма активна сесия, извежда съобщение в конзолата.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.undoLastTransformation();
        } else {
            System.out.println("No active session.");
        }
    }
}
