import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user;

    @Before
    public void setUp() {

        user = new User("Bob Smith", "BobSmith1@hotmail.com");

    }

    @Test
    public void hasName() {
        assertEquals("Bob Smith", user.getName());
    }

    @Test
    public void hasEmailAddress() {
        assertEquals("BobSmith1@hotmail.com", user.getEmail());
    }

    @Test
    public void hasEmptyListOfAdverts() {
        assertEquals(0, user.getAdverts().size());
    }

    @Test
    public void hasEmptyListOfComments() {
        assertEquals(0, user.getComments().size());
    }
}
