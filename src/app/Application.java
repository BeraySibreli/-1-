package app;

import core.ImageSession;
import core.ImageSessionManager;
import transforms.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImageSessionManager manager = new ImageSessionManager();
        ImageSession currentSession = null;

        System.out.println("Raster Image Editor started. Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split("\s+");

            if (parts.length == 0) continue;

            String command = parts[0];

            switch (command) {
                case "exit":
                    System.out.println("Exiting...");
                    return;
                case "help":
                    System.out.println("Commands: load, add, save, saveas, close, switch, session, undo");
                    System.out.println("Transformations: grayscale, monochrome, negative, rotate left/right, collage");
                    break;
                case "load":
                    if (parts.length < 2) {
                        System.out.println("Usage: load <filename>");
                        break;
                    }
                    currentSession = manager.createSession(parts[1]);
                    break;
                case "switch":
                    if (parts.length < 2) {
                        System.out.println("Usage: switch <sessionId>");
                        break;
                    }
                    currentSession = manager.switchSession(Integer.parseInt(parts[1]));
                    break;
                case "add":
                    if (checkSession(currentSession) && parts.length >= 2) {
                        currentSession.addImage(parts[1]);
                    }
                    break;
                case "session":
                    if (checkSession(currentSession)) currentSession.sessionInfo();
                    break;
                case "save":
                    if (checkSession(currentSession)) currentSession.save();
                    break;
                case "saveas":
                    if (checkSession(currentSession) && parts.length >= 2)
                        currentSession.saveAs(parts[1]);
                    break;
                case "close":
                    if (checkSession(currentSession)) {
                        manager.closeSession(currentSession.getId());
                        currentSession = null;
                    }
                    break;
                case "undo":
                    if (checkSession(currentSession)) currentSession.undo();
                    break;
                case "grayscale":
                    if (checkSession(currentSession)) currentSession.applyTransformation(new Grayscale());
                    break;
                case "monochrome":
                    if (checkSession(currentSession)) currentSession.applyTransformation(new Monochrome());
                    break;
                case "negative":
                    if (checkSession(currentSession)) currentSession.applyTransformation(new Negative());
                    break;
                case "rotate":
                    if (checkSession(currentSession) && parts.length >= 2)
                        currentSession.applyTransformation(new Rotate(parts[1]));
                    break;
                case "collage":
                    if (checkSession(currentSession) && parts.length == 5)
                        currentSession.collage(parts[1], parts[2], parts[3], parts[4]);
                    else
                        System.out.println("Usage: collage <direction> <img1> <img2> <outimage>");
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private static boolean checkSession(ImageSession session) {
        if (session == null) {
            System.out.println("No active session. Use 'load <filename>' first.");
            return false;
        }
        return true;
    }
}
