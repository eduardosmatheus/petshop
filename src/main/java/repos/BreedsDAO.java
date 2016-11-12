package repos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Breed;

public class BreedsDAO implements Persistible<Breed> {

    @PersistenceContext
    EntityManager em;

    @Override
    public Breed findOne(int id) {
        return em.find(Breed.class, id);
    }

    @Override
    public List<Breed> all() {
        Query q = em.createQuery("select a from Breed a");
        return q.getResultList();
    }
    
    @Override
    public Breed update(Breed f) {
        Breed existente = findOne(f.getId());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        existente.setName(f.getName());
        em.persist(existente);
        transaction.commit();
        return existente;
    }

    @Override
    public boolean delete(Breed breed) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(breed);
        transaction.commit();
        return findOne(breed.getId()) == null;
    }

    @Override
    public Breed create(Breed breed) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(breed);
        transaction.commit();
        return findOne(breed.getId());
    }

}
