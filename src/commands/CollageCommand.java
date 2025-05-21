package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за създаване на колаж от две изображения в рамките на текущата сесия.
 * <p>
 * Изисква посока (horizontal или vertical), две съществуващи изображения и име на изходния файл.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class CollageCommand implements Command {

    /**
     * Изпълнява командата за създаване на колаж.
     * <p>
     * Очаква следния синтаксис:
     * <pre>
     *     collage &lt;horizontal|vertical&gt; &lt;img1&gt; &lt;img2&gt; &lt;outimg&gt;
     * </pre>
     * Ако липсват аргументи или няма активна сесия, се извежда съобщение.
     *
     * @param args аргументи на командата:
     *             args[1] – посока на колажа (horizontal/vertical),
     *             args[2] и args[3] – имена на изображенията,
     *             args[4] – име на резултатното изображение
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 5) {
            System.out.println("Usage: collage <horizontal|vertical> <img1> <img2> <outimg>");
            return;
        }
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.collage(args[1], args[2], args[3], args[4]);
        } else {
            System.out.println("No active session.");
        }
    }
}
