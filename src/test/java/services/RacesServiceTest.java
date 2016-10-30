package services;

import helper.PetshopTestHelper;
import java.util.concurrent.CopyOnWriteArrayList;
import mocking.RaceList;
import model.Race;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class RacesServiceTest extends PetshopTestHelper {

    final CopyOnWriteArrayList<Race> list = RaceList.getInstance();
    
    @Test(priority = 1, description = "The findAll method should be invoked.")
    public void shouldFindAllRaces() {
        String rs = target.path("races/all").request().get(String.class);
        assertEquals(getExpectedRaces(), rs);
    }
    
    @Test(priority = 4, description = "The delete method should be invoked and remove the following object.")
    public void shouldDeleteRace() {
        int status = target.path("races/1/delete").request().delete().getStatus();
        assertEquals(status, 200);
    }
    
    @Test(priority = 2)
    public void shouldFindRaceById() {
        String response = target.path("races/1").request().get(String.class);
        assertEquals(response, "{\"id\":1,\"descricao\":\"Chiuaua\"}");
    }
    
    @Test(priority = 3)
    public void shouldNotFindRaceById() {
        int status = target.path("races/5").request().get().getStatus();
        assertEquals(status, 500);
    }
    
    private String getExpectedRaces() {
        return "[{\"id\":1,\"descricao\":\"Chiuaua\"},"
                + "{\"id\":2,\"descricao\":\"Labrador\"},"
                + "{\"id\":3,\"descricao\":\"Golden Retriever\"},"
                + "{\"id\":4,\"descricao\":\"Bullterrier\"}]";
    }
}
