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

    @Test
    public void hasTitle() {
        assertEquals("Nokia 3310", advert.getTitle());
    }

    @Test
    public void canChangeTitle(){
        advert.setTitle("Super Awesome Nokia 3310");
        assertEquals("Super Awesome Nokia 3310", advert.getTitle());
    }

    @Test
    public void hasDescription() {
        assertEquals("Classic Nokia indestructable mobile phone for sale", advert.getDescription());
    }

    @Test
    public void canChangeDescription(){
        advert.setDescription("different description of ad");
        assertEquals("different description of ad", advert.getDescription());
    }

    @Test
    public void hasCategory() {
        assertEquals(Category.TECHNOLOGY, advert.getCategory());
    }

    @Test
    public void canChangeCategory(){
        advert.setCategory(Category.MISCELLANEOUS);
        assertEquals(Category.MISCELLANEOUS, advert.getCategory());
    }

    @Test
    public void hasPrice() {
        assertEquals(50.00, advert.getPrice(),0.01);
    }

    @Test
    public void canChangePrice() {
        advert.setPrice(55.00);
        assertEquals(55.00, advert.getPrice(), 0.01);
    }

    @Test
    public void hasLocation(){
        assertEquals("Glasgow", advert.getLocation());
    }

    @Test
    public void canChangeLocation() {
        advert.setLocation("Edinburgh");
        assertEquals("Edinburgh", advert.getLocation());
    }

    @Test
    public void hasUser() {
        assertEquals(user, advert.getUser());
    }


}
