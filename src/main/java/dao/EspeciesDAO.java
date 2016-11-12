package dao;

import db.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Especie;

public class EspeciesDAO implements Persistible<Especie> {

    private EntityManager em = JpaUtil.getInstance().getEntityManager();
            
    @Override
    public Especie findOne(int id) {
        Especie b = em.find(Especie.class, id);
        return b;
    }

    @Override
    public List<Especie> all() {
        TypedQuery<Especie> q = em.createQuery("from Especie", Especie.class);
        return q.getResultList();
    }
    
    @Override
    public Especie update(Especie f) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(f);
        transaction.commit();
        return f;
    }

    @Override
    public boolean delete(Especie breed) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Object e = em.merge(breed);
        em.remove(e);
        transaction.commit();
        return findOne(breed.getId()) == null;
    }

    @Override
    public boolean create(Especie breed) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(breed);
        transaction.commit();
        return findOne(breed.getId()) != null;
    }

}
