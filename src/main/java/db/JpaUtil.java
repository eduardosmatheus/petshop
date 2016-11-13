package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private final EntityManagerFactory emf;
    private static JpaUtil self;

    public JpaUtil() {
        this.emf = Persistence.createEntityManagerFactory("petshop");
    }
    public static synchronized JpaUtil getInstance() {
        if(self == null)
            self = new JpaUtil();
        return self;
    }
    
    public synchronized EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
