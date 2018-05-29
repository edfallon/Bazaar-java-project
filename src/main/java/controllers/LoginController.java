package controllers;

import db.DBUser;
import models.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoginController {
    public LoginController() {
        this.setupEndPoints();
    }



    private void setupEndPoints(){
        post("/login", (req, res) -> {
            String inputtedemail = req.queryParams("email");
            req.session().attribute("email", inputtedemail);
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());

        get("/login", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/login.vtl");

        }, new VelocityTemplateEngine());

        get("/logout", (req, res) -> {
            req.session().removeAttribute("email");
            res.redirect("/");
            return null;
        }, new VelocityTemplateEngine());



    }

    public static User getLoggedInUser(Request req, Response res){
        String email = req.session().attribute("email");
        User user = DBUser.findByEmail(email);
        if (user == null) {
            res.redirect("/login");
        }
        return user;

    }

}
