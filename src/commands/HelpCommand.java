package commands;

/**
 * Команда за извеждане на списък с поддържаните команди и тяхната употреба.
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class HelpCommand implements Command {

    /**
     * Изпълнява командата за показване на помощна информация.
     * <p>
     * Извежда списък с наличните команди и синтаксиса за тяхното използване.
     *
     * @param args аргументи на командата (не се използват)
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Commands:");
        System.out.println("load <file>, add <file>, save, saveas <file>");
        System.out.println("grayscale, monochrome, negative, rotate <left|right>");
        System.out.println("undo, session, switch <id>, collage <dir> <img1> <img2> <outimg>");
        System.out.println("close, help, exit");
    }
}
