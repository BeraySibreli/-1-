
package core;

import java.util.*;


public class ImageSessionManager {
    private final Map<Integer, ImageSession> sessions = new HashMap<>();
    private int nextId = 1;

    public ImageSession createSession(String filename) {
        ImageSession session = new ImageSession(nextId++, filename);
        sessions.put(session.getId(), session);
        return session;
    }

    public ImageSession switchSession(int id) {
        if (sessions.containsKey(id)) {
            System.out.println("Switched to session with ID: " + id);
            return sessions.get(id);
        } else {
            System.out.println("Session with ID " + id + " does not exist.");
            return null;
        }
    }

    public void closeSession(int id) {
        if (sessions.containsKey(id)) {
            sessions.get(id).close();
            sessions.remove(id);
        }
    }
}
