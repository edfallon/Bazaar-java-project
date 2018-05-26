package controllers;

import db.DBHelper;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
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

    }
}
