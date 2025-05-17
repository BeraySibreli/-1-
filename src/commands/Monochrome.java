package commands;

import core.Session;
import core.SessionManager;

public class Monochrome implements Command {
    @Override
    public void execute(String[] args) {
        Session s = SessionManager.getInstance().getCurrentSession();
        if (s != null) s.addTransformation("monochrome");
        else System.out.println("No active session.");
    }
}
