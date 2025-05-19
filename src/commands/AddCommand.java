package commands;

import core.Session;
import core.SessionManager;

public class AddCommand implements Command {
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
            session.addImage(args[i]);
        }
    }
}
