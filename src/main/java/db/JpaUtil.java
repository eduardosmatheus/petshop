package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    public static EntityManager getEntityManager() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");
        return emf.createEntityManager();
    }
}
