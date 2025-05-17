package commands;

import core.Session;
import core.SessionManager;

public class SessionInfoCommand implements Command {
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) s.showInfo();
        else System.out.println("No active session.");
    }
}
