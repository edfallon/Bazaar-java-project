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
        comment = new Comment("Question about product", "Does product have any changeable covers?", user, advert);
    }

    @Test
    public void hasTitle() {
        assertEquals("Question about product", comment.getTitle());
    }

    @Test
    public void canSetTitle() {
        comment.setTitle("different question");
        assertEquals("different question", comment.getTitle());
    }

    @Test
    public void hasCommentText() {
        assertEquals("Does product have any changeable covers?", comment.getText());
    }
}
