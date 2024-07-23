package com.example.sprintbootdemo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserViewController {

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUserForm() {
        return "createUser";
    }


    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public RedirectView createUser() {
        return new RedirectView("/createUser");
    }
}
