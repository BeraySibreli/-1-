package commands;

import core.Session;
import core.SessionManager;

public class Rotate implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2 || (!args[1].equals("left") && !args[1].equals("right"))) {
            System.out.println("Usage: rotate <left|right>");
            return;
        }
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) s.addTransformation("rotate " + args[1]);
        else System.out.println("No active session.");
    }
}
