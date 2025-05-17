package commands;

import core.Session;
import core.SessionManager;

public class CloseCommand implements Command {
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) {
            s.close();
            SessionManager.getInstance().removeCurrentSession();
        } else {
            System.out.println("No active session.");
        }
    }
}
