package db;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private final EntityManagerFactory emf;
    private static JpaUtil self;
    
    private JpaUtil() {
        this.emf = Persistence.createEntityManagerFactory("petshop");
    }

    public static synchronized JpaUtil getInstance() {
        if(self == null){
            self = new JpaUtil();
        }
        return self;
    }
    
    public synchronized EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
