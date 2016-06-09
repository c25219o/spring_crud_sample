package jp.co.opst.spring.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * カートクラス
 *
 * @author Yui
 *
 */
@Component
public class Cart {

    private Map<String, Integer> items = new HashMap<>();

    public void addToCart(String[] goodsNum, Integer[] count) {
        // 数が合わない場合はどこではじくか
        for (int i = 0; i < count.length; i++) {
            this.add(goodsNum[i], count[i]);
        }
    }

    private void add(String goodsNum, int count) {

        // 既にカートの中身がある場合
        if (items.containsKey(goodsNum)) {
            int previousCount = items.get(goodsNum);
            items.put(goodsNum, previousCount + count);

        // まだカートの中身がない場合
        } else {
            items.put(goodsNum, count);
        }
    }

    public int getCount(String goodsNum) {
        return items.get(goodsNum);
    }

}
