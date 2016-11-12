package repos;

import java.util.List;

public interface Findable<T> {
    
    T findOne(int id);
    List<T> all();
    
}
