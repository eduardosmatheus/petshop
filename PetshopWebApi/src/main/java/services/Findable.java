package services;

import javax.ws.rs.core.Response;

public interface Findable {
    
    Response findById(int id);
    Response findAll();
    
}
