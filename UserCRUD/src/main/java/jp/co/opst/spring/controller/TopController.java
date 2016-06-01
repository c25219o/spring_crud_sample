package jp.co.opst.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {

    @RequestMapping("/user/top")
    public String userTop(){
        return "user/top";
    }

    @RequestMapping("/admin/top")
    public String adminTop(){
        return "admin/top";
    }

}
