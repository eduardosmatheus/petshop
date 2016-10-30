package services;

import helper.PetshopTestHelper;
import static org.junit.Assert.*;
import org.junit.Test;

public class RacesServiceTest extends PetshopTestHelper {

    @Test
    public void shouldFindAllRaces() {
        String rs = target.path("races/all").request().get(String.class);
        assertEquals(getExpectedResult(), rs);
    }
    
    @Test
    public void shouldUpdateRaceInfo() {
        
    }
    
    @Test
    public void shouldFindRaceById() {
        
    }
    
    private String getExpectedResult() {
        return "[{\"id\":1,\"descricao\":\"Chiuaua\"},{\"id\":2,\"descricao\":\"Labrador\"},{\"id\":3,\"descricao\":\"Golden Retriever\"},{\"id\":4,\"descricao\":\"Bullterrier\"}]";
    }
}
