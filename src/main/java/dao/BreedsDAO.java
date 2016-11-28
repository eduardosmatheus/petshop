package dao;

import db.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Breed;

public class BreedsDAO implements Persistible<Breed> {

    private EntityManager em = JpaUtil.getInstance().getEntityManager();
            
    @Override
    public Breed findOne(int id) {
        Breed b = em.find(Breed.class, id);
        return b;
    }

    @Override
    public List<Breed> all() {
        TypedQuery<Breed> q = em.createQuery("from Breed", Breed.class);
        return q.getResultList();
    }
    
    @Override
    public Breed update(Breed f) {
        int id = f.getId();
        EntityTransaction transaction = em.getTransaction();
        if(transaction.isActive()) 
            transaction.begin();
        em.merge(f);
        transaction.commit();
        return findOne(id);
    }

    @Override
    public boolean delete(Breed breed) {
        int id = breed.getId();
        EntityTransaction transaction = em.getTransaction();
        if(transaction.isActive()) 
            transaction.begin();
        Object e = em.merge(breed);
        em.remove(e);
        transaction.commit();
        return findOne(id) == null;
    }

    @Override
    public boolean create(Breed breed) {
        EntityTransaction transaction = em.getTransaction();
        if(transaction.isActive()) 
            transaction.begin();
        em.persist(breed);
        transaction.commit();
        return findOne(breed.getId()) != null;
    }

}
