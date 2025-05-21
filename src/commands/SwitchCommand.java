package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за превключване към съществуваща сесия по неин идентификатор.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class SwitchCommand implements Command {

    /**
     * Изпълнява командата за превключване към друга сесия.
     * <p>
     * Ако няма подаден валиден идентификатор като втори аргумент, извежда указание за правилна употреба.
     * При невалиден формат на ID или несъществуваща сесия, показва подходящи съобщения.
     *
     * @param args аргументи на командата, където args[1] трябва да е ID на сесията
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: switch <id>");
            return;
        }
        try {
            int id = Integer.parseInt(args[1]);
            SessionManager sm = SessionManager.getInstance();
            Session s = sm.getSession(id);
            if (s != null) {
                sm.setCurrentSession(s);
                s.switchTo();
            } else {
                System.out.println("Session not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid session ID.");
        }
    }
}
