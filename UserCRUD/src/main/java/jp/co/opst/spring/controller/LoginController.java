package jp.co.opst.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.opst.spring.bean.LoginInfo;
import jp.co.opst.spring.entity.User;
import jp.co.opst.spring.service.UserService;

@Controller
@SessionAttributes("loginInfo")
public class LoginController {

    @Autowired
    private UserService service;

    @RequestMapping("index")
    public String index() {
        return "/index";
    }

    @RequestMapping(value="login", method=RequestMethod.GET)
    public String loginGet() {
        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String userId, @RequestParam String password, Model model, HttpSession session,
            RedirectAttributes attributes) {

        if (service.isCorrectUser(userId, password)) {
            User user = service.selectById(userId);
            String userName = user.getLstName() + " " + user.getFstName();
            String authority = user.getAuthority();
            System.out.println(userName);

            LoginInfo loginInfo = new LoginInfo(userId, userName, authority);
            session.setAttribute("loginInfo", loginInfo);
            // 権限による画面分け
            switch (user.getAuthority()) {
            case "admin":
                return "redirect:/admin/top.html";
            case "user":
                return "redirect:/user/top.html";
            default:
                return "redirect:/loginError.html";
            }
        } else {
            attributes.addFlashAttribute("hasError", true);
            attributes.addFlashAttribute("errorMessage", "IDまたはパスワードが違います");
            return "redirect:/";
        }
    }

    @RequestMapping("/loginError")
    public String loginError() {
        return "loginError";
    }

}
