package db;

/**
 * Created by alex on 12/6/2017.
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
    INSTANCE;
    private EntityManagerFactory emFactory;
    private PersistenceManager() {
        // "jpa-example" was the value of the name attribute of the
        // persistence-unit element.
        /*java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);*/
        emFactory = Persistence.createEntityManagerFactory("WebApp");
    }
    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
    public void close() {
        emFactory.close();
    }

}