package jp.co.opst.spring.params;

public class OrderParam {


    private Integer[] price;
    private String [] goodsNum;
    /**
     * @return the price
     */
    public Integer[] getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(Integer[] price) {
        this.price = price;
    }
    /**
     * @return the goodsNum
     */
    public String[] getGoodsNum() {
        return goodsNum;
    }
    /**
     * @param goodsNum the goodsNum to set
     */
    public void setGoodsNum(String[] goodsNum) {
        this.goodsNum = goodsNum;
    }

    public boolean hasOrder() {

        // TODO Utilに配列の空チェックを作成、価格、商品番号ともに入っているかどうかのチェックを行う
        return false;
    }

}
