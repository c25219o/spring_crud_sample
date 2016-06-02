package jp.co.opst.spring.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPage {



    @RequestMapping("user/myPage")
    public String myPage() {
        return "user/myPage";
    }

}
