package dao;

import db.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import model.Customer;

public class CustomerDAO implements Persistible<Customer> {

    private final EntityManager em = JpaUtil.getInstance().getEntityManager();
    
    @Override
    public Customer findOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Customer findOne(String id) {
        Customer customer = em.find(Customer.class, id);
        return customer;
    }

    @Override
    public List<Customer> all() {
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public boolean create(Customer entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return findOne(entity.getCpf()) != null;
    }

    @Override
    public Customer update(Customer entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return findOne(entity.getCpf());
    }

    @Override
    public boolean delete(Customer entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        return findOne(entity.getCpf()) == null;
    }
}
