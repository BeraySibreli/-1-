package commands;

import core.Session;
import core.SessionManager;

public class AddCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: add <filename>");
            return;
        }
        Session session = SessionManager.getInstance().getCurrentSession();
        if (session != null) session.addImage(args[1]);
        else System.out.println("No active session.");
    }
}
