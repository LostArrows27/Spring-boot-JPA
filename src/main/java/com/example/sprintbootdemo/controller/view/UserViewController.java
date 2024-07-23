package com.example.sprintbootdemo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserViewController {

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String createUserForm() {
        return "createUser";
    }
}
