package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за запазване на първото изображение от текущата сесия под ново име.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class SaveAsCommand implements Command {

    /**
     * Изпълнява командата за запазване на изображението с ново име.
     * <p>
     * Ако не е подадено име на файл като аргумент, извежда съобщение с указания за употреба.
     * Ако няма активна сесия, показва съобщение за грешка.
     *
     * @param args аргументи на командата, където args[1] трябва да съдържа новото име на файла
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: saveas <filename>");
            return;
        }
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.saveAs(args[1]);
        } else {
            System.out.println("No active session.");
        }
    }
}
