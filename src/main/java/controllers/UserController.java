package controllers;

import db.DBHelper;
import db.DBUser;
import models.Advert;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class UserController {
    public UserController(){this.setupEndpoints();}

    private void setupEndpoints(){


        get("/user/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/create.vtl");
            return new ModelAndView(model, "templates/users/create.vtl");
        },new VelocityTemplateEngine());

        post ("/users", (req, res) -> {
            String name = req.queryParams("name");
            String email = req.queryParams("email");

            User user = new User(name, email);
            DBHelper.save(user);
            res.redirect("/login");
            return null;
        }, new VelocityTemplateEngine());

        get("/user/:id", (req, res) -> {
            Integer id = Integer.parseInt(req.params("id"));
            User user = DBHelper.find(id, User.class);
            List<Advert> adverts = DBUser.findAllAdsForUser(user);
            Map<String, Object> model = new HashMap<>();
            model.put("advert", adverts);
            model.put("template", "templates/users/index.vtl");
            return new ModelAndView(model, "templates/users/index.vtl");

        }, new VelocityTemplateEngine());

    }
}
