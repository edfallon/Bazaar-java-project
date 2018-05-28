package controllers;

import db.DBAdvert;
import db.DBHelper;
import models.Advert;
import models.Category;
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
            model.put("categories", categories);
            model.put("template", "templates/adverts/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/advert/:category", (req, res) -> {
            String selectedCategory = req.params(":category");
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("selectedCategory", selectedCategory);
            model.put("template", "templates/adverts/show_by_category.vtl");
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/advert/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Advert advert = DBHelper.find(id, Advert.class);
            User user = DBAdvert.findUserForAdvert(advert);

            Map<String, Object> model = new HashMap<>();
            model.put("advert", advert);
            model.put("user", user);
            model.put("template", "templates/adverts/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        post ("/advert", (req, res) -> {
//            String category = req.queryParams("category");
//            String title = req.queryParams("title");
//            String description = req.queryParams("description");
//            String photo = req.queryParams("photourl");
//            int price = Integer.parseInt(req.queryParams("price"));
//            String location = req.queryParams("location");
//            Advert advert = new Advert(title, description, category, price, location, user, photo);
//            DBHelper.save(advert);
//            res.redirect("/");
//            return null;
//        }, new VelocityTemplateEngine());

        post ("/advert/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Advert advertToDelete = DBHelper.find(id, Advert.class);
            DBHelper.delete(advertToDelete);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get("/advert/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Advert advert = DBHelper.find(intId, Advert.class);
            List<Category> categories = new ArrayList<>( Arrays.asList(Category.values()));
            Map<String, Object> model = new HashMap<>();
            model.put("categories", categories);
            model.put("template", "templates/adverts/edit.vtl");
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());








    }
}
