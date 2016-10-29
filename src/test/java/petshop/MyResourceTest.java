package petshop;

import helper.PetshopTestHelper;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyResourceTest extends PetshopTestHelper {

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
}
