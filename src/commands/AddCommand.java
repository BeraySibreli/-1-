package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за добавяне на едно или повече изображения към текущата сесия.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class AddCommand implements Command {

    /**
     * Изпълнява командата за добавяне на изображения.
     * <p>
     * Изисква поне един аргумент с име на изображение.
     * Ако няма активна сесия, се извежда съобщение за грешка.
     *
     * @param args аргументи на командата, където args[1], args[2], ... са имената на изображенията
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: add <filename1> <filename2> ...");
            return;
        }

        Session session = SessionManager.getInstance().getCurrentSession();
        if (session == null) {
            System.out.println("No active session.");
            return;
        }

        for (int i = 1; i < args.length; i++) {
            session.addImage(args[i]);
        }
    }
}
