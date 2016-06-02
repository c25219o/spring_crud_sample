package jp.co.opst.spring.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.opst.spring.controller.params.SearchParam;
import jp.co.opst.spring.controller.service.GoodsService;
import jp.co.opst.spring.dao.GoodsDao;
import jp.co.opst.spring.entity.Goods;

@Controller
public class ShoppingController {

    @Autowired
    GoodsService service;

    @RequestMapping("/user/shopping")
    public String goodsList(Model model, @ModelAttribute SearchParam params) {

        List<Goods> goodsList;
        if (params.hasCondition()) {
            goodsList = service.findByCondition(params);
        } else {
            goodsList = service.findAll();
        }

        model.addAttribute("goodsList", goodsList);
        return "user/shopping/goodsList";
    }

}
