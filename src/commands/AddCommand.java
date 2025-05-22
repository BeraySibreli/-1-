package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за добавяне на едно или повече изображения към текущата сесия.
 * <p>
 * Допуска се добавянето само на изображения във форматите Netpbm:
 * PBM, PGM, PPM. Проверката се извършва по разширението на името на файла
 * (фиктивно, без реално четене на файл).
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class AddCommand implements Command {

    /**
     * Изпълнява командата за добавяне на изображения.
     * <p>
     * Изисква поне един аргумент с име на изображение.
     * Ако няма активна сесия, се извежда съобщение за грешка.
     * Приемат се само файлове с разширения .pbm, .pgm, .ppm.
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
            String filename = args[i];
            if (isNetpbmFilename(filename)) {
                session.addImage(filename);
            } else {
                System.out.println("Unsupported format for file: " + filename +
                        ". Only Netpbm formats (.pbm, .pgm, .ppm) are allowed.");
            }
        }
    }

    /**
     * Проверява дали подаденото име на файл е във формат Netpbm,
     * като анализира разширението на името.
     *
     * @param filename името на файла, което се проверява
     * @return {@code true} ако файлът е с разширение .pbm, .pgm, .ppm ; {@code false} в противен случай
     */
    private boolean isNetpbmFilename(String filename) {
        String lowercase = filename.toLowerCase();
        return lowercase.endsWith(".pbm") ||
                lowercase.endsWith(".pgm") ||
                lowercase.endsWith(".ppm");
    }
}
