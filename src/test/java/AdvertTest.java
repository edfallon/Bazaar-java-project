import models.Advert;
import models.Category;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvertTest {

    Advert advert;
    User user;

    @Before

    public void before() {

        user = new User("Bob Smith", "bobsmith1@hotmail.com");
        advert = new Advert("Nokia 3310", "Classic Nokia indestructable mobile phone for sale", Category.TECHNOLOGY, 50.00, "Glasgow", user, "testphoto.imgur.com");
    }


}
