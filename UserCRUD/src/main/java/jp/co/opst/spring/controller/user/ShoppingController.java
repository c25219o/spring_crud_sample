package jp.co.opst.spring.controller.user;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.opst.spring.constants.PagingAction;
import jp.co.opst.spring.entity.Goods;
import jp.co.opst.spring.params.Pager;
import jp.co.opst.spring.params.SearchParam;
import jp.co.opst.spring.service.GoodsService;
import jp.co.opst.util.literal.LengthUtil;

@Controller
public class ShoppingController {

    @Autowired
    GoodsService service;

    @Autowired
    private Properties shoppingProperties;

    @RequestMapping(value="/user/shopping"/*, method=RequestMethod.POST*/)
    public String goodsList(Model model, @ModelAttribute SearchParam searchParam, @ModelAttribute Pager pager) {
        int rows = Integer.parseInt(shoppingProperties.getProperty("rows.perPage"));

        int nextPage = 1;

        if(LengthUtil.isNotEmpty(pager.getPagingAction())) {
            nextPage = pager.getCurrentPage();

            switch (PagingAction.of(pager.getPagingAction())) {
            case NEXT:
                nextPage++;
                break;

            case PREVIOUS:
                nextPage--;
                break;

            default:
                // do nothing;
            }
        }

        List<Goods> goodsList;

        if (searchParam.hasCondition()) {
            goodsList = service.findByCondition(searchParam);
        } else {
            goodsList = service.byId(null, nextPage, rows);
//            goodsList = service.findAll();
        }

        model.addAttribute("goodsList", goodsList);
        model.addAttribute("pageNum", nextPage);
        model.addAttribute("isLastPage", service.isLastGoods(goodsList.get(goodsList.size()-1)));
        return "user/shopping/goodsList";
    }

}
