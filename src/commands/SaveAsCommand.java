package commands;

import core.Session;
import core.SessionManager;

public class SaveAsCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: saveas <filename>");
            return;
        }
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) s.saveAs(args[1]);
        else System.out.println("No active session.");
    }
}
