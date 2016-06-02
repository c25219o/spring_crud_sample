package jp.co.opst.spring.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * カートクラス
 *
 * @author Yui
 *
 */
@Component
public class Cart {

    private Map<String, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addToCart(String[] goodsNum, Integer[] count) {
        // 数が合わない場合はどこではじくか
        for (int i = 0; i < count.length; i++) {
            this.add(goodsNum[i], count[i]);
        }
    }

    private void add(String goodsNum, int count) {

        // 既にカートの中身がある場合
        if (items.containsKey(goodsNum)) {
            items.put(goodsNum, count);

        // まだカートの中身がない場合
        } else {
            int previousCount = items.get(goodsNum);
            items.put(goodsNum, previousCount + count);
        }
    }

    public int getCount(String goodsNum) {
        return items.get(goodsNum);
    }

}
