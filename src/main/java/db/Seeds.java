package db;

import models.Advert;
import models.Comment;
import models.User;

public class Seeds {
    public static void seedData(){
        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(Comment.class);
        DBHelper.deleteAll(User.class);

        User user1 = new User("Bob Smith", "bobsmith1@hotmail.com");
        DBHelper.save(user1);

        Advert advert1 = new Advert("Nokia 3310", "Classic Nokia indestructable mobile phone for sale", Category.TECHNOLOGY, 50.00, "Glasgow", user, "testphoto.imgur.com");
        DBHelper.save(advert1);

        Comment comment1 = new Comment("Question about product", "Does product have any changeable covers?", user, advert);
        DBHelper.save(comment1);
    }
}






