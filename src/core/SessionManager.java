package core;

import java.util.*;

/**
 * Клас за управление на сесиите в приложението.
 * <p>
 * Прилага Singleton шаблон за осигуряване на единствена инстанция.
 * Сесиите се съхраняват в колекция, достъпна чрез уникален идентификатор.
 */
public class SessionManager {

    /**
     * Единствената инстанция на SessionManager.
     */
    private static SessionManager instance;

    /**
     * Карта от идентификатори към сесии.
     */
    private final Map<Integer, Session> sessions = new HashMap<>();

    /**
     * Следващ достъпен идентификатор за нова сесия.
     */
    private int nextId = 1;

    /**
     * Текущо активната сесия.
     */
    private Session currentSession;

    /**
     * Частен конструктор за прилагане на Singleton шаблона.
     */
    private SessionManager() {}

    /**
     * Връща единствената инстанция на SessionManager.
     * Ако все още не съществува, се създава нова.
     *
     * @return инстанцията на SessionManager
     */
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    /**
     * Създава нова сесия с посочено име на файл и я задава като текуща.
     *
     * @param filename името на файла, свързан със сесията
     */
    public void createSession(String filename) {
        Session session = new Session(nextId++, filename);
        sessions.put(session.getId(), session);
        currentSession = session;
    }

    /**
     * Връща текущата активна сесия.
     *
     * @return текущата сесия или {@code null}, ако няма активна сесия
     */
    public Session getCurrentSession() {
        return currentSession;
    }

    /**
     * Връща сесия по нейн идентификатор.
     *
     * @param id уникалният идентификатор на сесията
     * @return сесията или {@code null}, ако не съществува
     */
    public Session getSession(int id) {
        return sessions.get(id);
    }

    /**
     * Задава текуща сесия.
     *
     * @param s сесията, която да бъде зададена като текуща
     */
    public void setCurrentSession(Session s) {
        this.currentSession = s;
    }

    /**
     * Премахва текущата активна сесия, ако съществува.
     */
    public void removeCurrentSession() {
        if (currentSession != null) {
            sessions.remove(currentSession.getId());
            currentSession = null;
        }
    }
}
