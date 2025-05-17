package commands;

import core.Session;
import core.SessionManager;

public class SwitchCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: switch <id>");
            return;
        }
        try {
            int id = Integer.parseInt(args[1]);
            SessionManager sm = SessionManager.getInstance();
            Session s = sm.getSession(id);
            if (s != null) {
                sm.setCurrentSession(s);
                s.switchTo();
            } else {
                System.out.println("Session not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid session ID.");
        }
    }
}
