package commands;

import core.Session;
import core.SessionManager;

/**
 * Команда за зареждане на нова сесия с едно или повече изображения.
 * <p>
 * Допуска се зареждане само на изображения във форматите Netpbm:
 * PBM, PGM, PPM . Проверката се извършва по разширението на името на файла
 * (фиктивно, без реално четене на файл).
 * <p>
 * Имплементира интерфейса {@link Command}.
 */
public class LoadCommand implements Command {

    /**
     * Изпълнява командата за зареждане на изображения в нова сесия.
     * <p>
     * Първото изображение (args[1]) се използва за инициализиране на сесията,
     * а всички останали се добавят към нея.
     * Приемат се само файлове с разширения .pbm, .pgm, .ppm.
     * Ако някой от файловете не е в поддържан формат, той се пропуска със съобщение.
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

        String firstImage = args[1];
        if (!isNetpbmFilename(firstImage)) {
            System.out.println("Unsupported format for file: " + firstImage +
                    ". Only Netpbm formats (.pbm, .pgm, .ppm) are allowed.");
            return;
        }

        SessionManager.getInstance().createSession(firstImage);
        Session session = SessionManager.getInstance().getCurrentSession();

        for (int i = 2; i < args.length; i++) {
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
     * @return {@code true} ако файлът е с разширение .pbm, .pgm, .ppm; {@code false} в противен случай
     */
    private boolean isNetpbmFilename(String filename) {
        String lowercase = filename.toLowerCase();
        return lowercase.endsWith(".pbm") ||
                lowercase.endsWith(".pgm") ||
                lowercase.endsWith(".ppm");
    }
}
