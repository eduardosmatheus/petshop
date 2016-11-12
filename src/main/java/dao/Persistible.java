package dao;

import java.util.List;

public interface Persistible<T> {
    
    T findOne(int id);
    List<T> all();
    boolean create(T entity);
    T update(T entity);
    boolean delete(T entity);
}
