package commands;

import core.Session;
import core.SessionManager;

public class CollageCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 5) {
            System.out.println("Usage: collage <horizontal|vertical> <img1> <img2> <outimg>");
            return;
        }
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) s.collage(args[1], args[2], args[3], args[4]);
        else System.out.println("No active session.");
    }
}
