package commands;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Commands:");
        System.out.println("load <file>, add <file>, save, saveas <file>");
        System.out.println("grayscale, monochrome, negative, rotate <left|right>");
        System.out.println("undo, session, switch <id>, collage <dir> <img1> <img2> <outimg>");
        System.out.println("close, help, exit");
    }
}
