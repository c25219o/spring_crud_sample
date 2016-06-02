package jp.co.opst.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.spring.dao.GoodsDao;
import jp.co.opst.spring.entity.Goods;
import jp.co.opst.spring.params.SearchParam;
import jp.co.opst.util.list.ListUtil;
import jp.co.opst.util.literal.LengthUtil;

@Service
public class GoodsService {

    @Autowired
    GoodsDao dao;

    public List<Goods> findByCondition(SearchParam params) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Goods> findAll() {

        // TODO Auto-generated method stub
        return dao.all();
    }

    public Goods findById(String goodsNum) {

        return null;
    }



    /**
     * 主キーによる検索を行います。	<br>
     * 主キーの入力が無かった場合、全件検索を行います。
     * @param num
     * @param nextPage
     * @param rowCount
     * @return
     */
    public List<Goods> byId(String num, int nextPage, int rowCount) {
        if (LengthUtil.isEmpty(num)) {
//            return dao.all();
            return dao.pageAll(nextPage, rowCount);
        }
        return dao.pageById(num, nextPage, rowCount);
    }

    /**
     * 引数で指定したGoodsのGOODS_NUMが、最大であるかどうか検証します。
     * @param goods
     * @return
     */
    public boolean isLastGoods(Goods goods) {

        List<Goods> goodsNumListStr = dao.getOnlyGoodsNum();
        List<Integer> goodsNumList = new ArrayList<>();

        for (Goods eachGoods : goodsNumListStr) {
            goodsNumList.add(Integer.parseInt(eachGoods.getGoodsNum()));
        }

        int max = ListUtil.maxInt(goodsNumList);
        int goodsNum = Integer.parseInt(goods.getGoodsNum());

        if (goodsNum == max) {
            return true;
        } else {
            return false;
        }

    }

}
