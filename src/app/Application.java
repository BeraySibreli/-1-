package app;

import java.util.Scanner;

/**
 * Основен входен клас за командния интерфейс на редактора на растерни изображения.
 * <p>
 * Стартира приложението, инициализира {@link CommandExecutor} и обработва потребителския вход от конзолата.
 */
public class Application {

    /**
     * Главен метод, който стартира приложението.
     * <p>
     * Извежда начален екран, приема команди от потребителя и ги предава за изпълнение.
     * Командата <code>exit</code> прекратява програмата.
     *
     * @param args аргументи от командния ред (не се използват)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandExecutor executor = new CommandExecutor();

        System.out.println("Raster Image Editor. Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            executor.execute(input);
        }

        System.out.println("Goodbye!");
    }
}
