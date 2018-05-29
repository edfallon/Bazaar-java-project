package controllers;

import db.DBHelper;
import db.Seeds;
import models.Advert;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
        Seeds.seedData();


        staticFileLocation("/public");
        LoginController loginController = new LoginController();
        UserController userController = new UserController();
        AdvertController advertController = new AdvertController();



        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            User loggedInUser = LoginController.getLoggedInUser(req, res);
            model.put("loggedInUser", loggedInUser);
            model.put("template","templates/main.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/search", (req, res) ->{
            Map<String, Object> model = new HashMap<>();
            List<Advert> results = DBHelper.search("query");
            model.put("results", results);
            model.put("templates", "templates/search.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/search", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            String theQuery = req.queryParams("query");
            List<Advert> adverts = DBHelper.search(theQuery);
            model.put("adverts", adverts);
            model.put("template", "templates/search.vtl" );
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
