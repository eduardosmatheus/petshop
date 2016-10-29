package services;

import helper.PetshopTestHelper;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class RacesServiceTest extends PetshopTestHelper {

    @Test
    public void shouldFindAllRacesByRequest() {
        String rs = target.path("races/all").request().get(String.class);
        Assert.assertEquals(getExpectedMessage(), rs);
    }
    
    private String getExpectedMessage() {
        return RaceList.getInstance()
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));
    }
}
