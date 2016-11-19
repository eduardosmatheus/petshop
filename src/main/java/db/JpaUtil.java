package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private final EntityManagerFactory emf;
    private static JpaUtil self;
    private EntityManager entityManager;
    
    private JpaUtil() {
        this.emf = Persistence.createEntityManagerFactory("petshop");
    }

    public static JpaUtil getInstance() {
        if(self == null){
            self = new JpaUtil();
        }
        return self;
    }
    
    public EntityManager getEntityManager() {
        if(entityManager == null)
            entityManager = emf.createEntityManager();
        return entityManager;
    }
}
