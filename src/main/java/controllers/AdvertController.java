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






    }
}
