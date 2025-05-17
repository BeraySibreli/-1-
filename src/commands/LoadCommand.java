package commands;

import core.SessionManager;

public class LoadCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: load <filename>");
            return;
        }
        SessionManager.getInstance().createSession(args[1]);
    }
}
