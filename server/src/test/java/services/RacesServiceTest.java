package services;

import helper.PetshopTestHelper;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import mocking.RaceList;
import model.Race;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class RacesServiceTest extends PetshopTestHelper {

    final CopyOnWriteArrayList<Race> list = RaceList.getInstance();
    
    @Test(priority = 1, description = "The findAll method should be invoked.")
    public void shouldFindAllRaces() {
        String rs = target.path("races").request().get(String.class);
        assertEquals(getExpectedRaces(), rs);
    }
    
    @Test(priority = 4, description = "The delete method should be invoked and remove the following object.")
    public void shouldDeleteRace() {
        int status = target.path("races/1").request().delete().getStatus();
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
    
    @Test(priority = 5)
    public void shouldCreateANewRace() {
        Entity<Race> foo = Entity.json(new Race(5, "Pitbull"));
        Response createdRace = target.path("races").request().post(foo);
        assertNotNull(createdRace);
        assertEquals(createdRace.getStatus(), 201);
    }
    
    private String getExpectedRaces() {
        return "[{\"id\":1,\"descricao\":\"Chiuaua\"},"
                + "{\"id\":2,\"descricao\":\"Labrador\"},"
                + "{\"id\":3,\"descricao\":\"Golden Retriever\"},"
                + "{\"id\":4,\"descricao\":\"Bullterrier\"}]";
    }
}
