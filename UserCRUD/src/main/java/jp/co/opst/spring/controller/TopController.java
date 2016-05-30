package jp.co.opst.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {

    @RequestMapping("/top")
    public String topPage(){
        return "/user/top";
    }

}
