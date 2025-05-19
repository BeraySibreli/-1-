package commands;

import core.Session;
import core.SessionManager;

public class LoadCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: load <filename1> <filename2> ...");
            return;
        }


        SessionManager.getInstance().createSession(args[1]);


        Session session = SessionManager.getInstance().getCurrentSession();


        for (int i = 2; i < args.length; i++) {
            session.addImage(args[i]);
        }
    }
}
