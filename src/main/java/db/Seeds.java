package db;

import models.Advert;
import models.Category;
import models.Comment;
import models.User;

import java.util.List;

public class Seeds {
    public static void seedData(){
        DBHelper.deleteAll(User.class);
        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(Comment.class);


        User user1 = new User("Bob Smith", "bobsmith1@hotmail.com");
        DBHelper.save(user1);
        User user2 = new User("Fred Mercury", "IAmTheChampion@gmail.com");
        DBHelper.save(user2);

        Advert advert1 = new Advert("Nokia 3310", "Classic Nokia indestructable mobile phone for sale", Category.TECHNOLOGY, 50.00, "Glasgow", user1, "testphoto.imgur.com");
        DBHelper.save(advert1);

        Advert advert2 = new Advert ("Dyson", "new Dyson cordless vacuum cleaner for sale", Category.APPLIANCES, 250.00, "edinburgh", user2, "photourl.url.com");
        DBHelper.save(advert2);
      
        Comment comment1 = new Comment("Question about product", "Does product have any changeable covers?", user1, advert1);
        DBHelper.save(comment1);
    }
}






