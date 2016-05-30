package jp.co.opst.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.opst.spring.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String login(@RequestParam String userId, @RequestParam String password) {

        if (service.isCorrectUser(userId, password)) {
            return null;
        } else {
            return null;
        }
    }

}
