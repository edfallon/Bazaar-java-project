import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user;

    @Before
    public void setUp() {

        user = new User("Bob Smith", "BobSmith1@hotmail.co.uk");

    }

    @Test
    public void hasName() {
        assertEquals("Bob Smith", user.getName());
    }

    @Test
    public void hasEmailAddress() {
        assertEquals("bobsmith1@hotmail.com", user.getEmail());
    }

    @Test
    public void hasEmptyListOfAdverts() {
        assertEquals(0, user.getAdverts().size());
    }
}
