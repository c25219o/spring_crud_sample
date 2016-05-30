package jp.co.opst.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.opst.spring.entity.User;
import jp.co.opst.spring.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String userId, @RequestParam String password, Model model, HttpSession session) {

        if (service.isCorrectUser(userId, password)) {

            User user = service.selectById(userId);
            session.setAttribute("loginUser", user);

            // TODO authority別処理！

            return "redirect:/top";
        } else {
            model.addAttribute("loginError", "Login faild");
            return "/";
        }
    }

}
