package core;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static SessionManager instance;
    private final Map<Integer, Session> sessions = new HashMap<>();
    private int nextId = 1;
    private Session currentSession;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void createSession(String filename) {
        Session session = new Session(nextId++, filename);
        sessions.put(session.getId(), session);
        currentSession = session;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Session getSession(int id) {
        return sessions.get(id);
    }

    public void setCurrentSession(Session s) {
        this.currentSession = s;
    }

    public void removeCurrentSession() {
        if (currentSession != null) {
            sessions.remove(currentSession.getId());
            currentSession = null;
        }
    }
}
