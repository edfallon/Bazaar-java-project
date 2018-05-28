import models.Advert;
import models.Category;
import models.Comment;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentTest {

    User user;
    Advert advert;
    Comment comment;

    @Before
    public void setUp()  {

        user = new User("Bob Smith", "bobsmith1@hotmail.com");
        advert = new Advert("Nokia 3310", "Classic Nokia indestructable mobile phone for sale", Category.TECHNOLOGY, 50.00, "Glasgow", user, "testphoto.imgur.com");
        comment = new Comment("Does product have any changeable covers?", user, advert);
    }




    @Test
    public void hasCommentText() {
        assertEquals("Does product have any changeable covers?", comment.getText());
    }


    @Test
    public void canChangeCommentText() {
        comment.setText("the text has changed");
        assertEquals("the text has changed", comment.getText());
    }

    @Test
    public void hasUser() {
        assertEquals(user, comment.getUser());
    }

    @Test
    public void hasAdvert() {
        assertEquals(advert, comment.getAdvert());
    }
}
