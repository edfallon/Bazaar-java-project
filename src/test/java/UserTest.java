import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user;

    @Before
    public void setUp() {

        user = new User("Bob Smith", "BobSmith1@hotmail.co.uk");

    }
}
