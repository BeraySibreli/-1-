package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за зареждане на нова сесия с едно или повече изображения.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class LoadCommand implements Command {

    /**
     * Изпълнява командата за зареждане на изображения в нова сесия.
     * <p>
     * Първото изображение (args[1]) се използва за инициализиране на сесията,
     * а всички останали се добавят към нея.
     * <p>
     * Ако не е подадено поне едно име на файл, се извежда съобщение с указания за употреба.
     *
     * @param args аргументи на командата, където args[1] е първото изображение,
     *             а args[2], args[3], ... са допълнителни изображения
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: load <filename1> <filename2> ...");
            return;
        }

        SessionManager.getInstance().createSession(args[1]);

        Session session = SessionManager.getInstance().getCurrentSession();

        for (int i = 2; i < args.length; i++) {
            session.addImage(args[i]);
        }
    }
}
