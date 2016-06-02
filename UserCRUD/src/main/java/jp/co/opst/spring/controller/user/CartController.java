package jp.co.opst.spring.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.opst.spring.bean.Cart;
import jp.co.opst.spring.service.OrderService;
import jp.co.opst.util.array.ArrayUtil;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    OrderService service;

    @Autowired Cart cart;

    @RequestMapping("user/cart")
    public String seeCart(Model model, HttpSession session) {

        int totalPrice = 0;
        // TODO 合計金額計算

        model.addAttribute("totalPrice", totalPrice);
        return "user/shopping/cart";
    }

    @RequestMapping(value="user/order", method=RequestMethod.POST)
    public String order(HttpSession session) {
        return null;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String addToCart(@RequestParam String[] goodsNum, @RequestParam int[] count) {

        Integer[] goodsCount = ArrayUtil.removeZero(count);
        cart.addToCart(goodsNum, count);


        // カートに遷移？
        return "redirect:user/cart/html";

        // 商品一覧に遷移？
//        return "redirect:user/shopping.html";
    }
}
