package controllers;

import db.DBAdvert;
import db.DBHelper;
import models.Advert;
import models.Category;
import models.Comment;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class AdvertController {
    public AdvertController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        get ("/advert/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Category> categories = new ArrayList<>( Arrays.asList(Category.values()));
            User loggedInUser = LoginController.getLoggedInUser(req,res);
            model.put("user", loggedInUser);
            model.put("categories", categories);
            model.put("template", "templates/adverts/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/advert/:id/edit", (req, res) -> {
            System.out.println("gets here!");
            Integer id = Integer.parseInt(req.params("id"));
            Advert advert = DBHelper.find(id, Advert.class);
            List<Category> categories = new ArrayList<>( Arrays.asList(Category.values()));
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUser(req, res);
            model.put("user", loggedInUser);
            model.put("categories", categories);
            model.put("template", "templates/adverts/edit.vtl");
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/adverts/:category", (req, res) -> {
            String selectedCategory = req.params("category").toUpperCase();
            Category enumCat = Category.valueOf(selectedCategory);
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUser(req, res);
            model.put("user", loggedInUser);
            List<Advert> adverts = DBAdvert.findAdvertsByCategory(enumCat);
            model.put("selectedCategory", selectedCategory);
            model.put("template", "templates/adverts/show_by_category.vtl");
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/advert/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Advert advert = DBHelper.find(id, Advert.class);
            List<Comment> comments = DBAdvert.findAllCommentsForAdvert(advert);
            User aduser = DBAdvert.findUserForAdvert(advert);
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUser(req, res);
            model.put("comments", comments);
            model.put("user", loggedInUser);
            model.put("advert", advert);
            model.put("aduser", aduser);
            model.put("template", "templates/adverts/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/advert", (req, res) -> {
            User user = LoginController.getLoggedInUser(req, res);
            int id = user.getId();
            String category = req.queryParams("category");
            Category catEnum = Category.valueOf(category);
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            String photo = req.queryParams("photourl");
            int price = Integer.parseInt(req.queryParams("price"));
            String location = req.queryParams("location");
            Advert advert = new Advert(title, description, catEnum, price, location, user, photo);
            DBHelper.save(advert);
            String text = req.queryParams("text");








            Comment comment = new Comment(text, user, advert);
            DBHelper.save(comment);
            res.redirect("/user/" + id);
            return null;
        }, new VelocityTemplateEngine());

        post ("/advert/:id", (req, res) -> {
            User user = LoginController.getLoggedInUser(req, res);
            int id = Integer.parseInt(req.params("id"));
            Advert advert = DBHelper.find(id, Advert.class);
            String category = req.queryParams("category");
            Category catEnum = Category.valueOf(category);
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            String photo = req.queryParams("photourl");
            int price = Integer.parseInt(req.queryParams("price"));
            String location = req.queryParams("location");

            advert.setCategory(catEnum);
            advert.setTitle(title);
            advert.setDescription(description);
            advert.setPhotourl(photo);
            advert.setPrice(price);
            advert.setLocation(location);
            DBHelper.update(advert);
            res.redirect("/advert/" + id);
            return null;
        }, new VelocityTemplateEngine());



        post ("/advert/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Advert advertToDelete = DBHelper.find(id, Advert.class);
            DBHelper.delete(advertToDelete);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());









    }
}
