package jp.co.opst.spring.params;

import java.sql.Date;

public class SearchParam {

    private String goodsName;
    private String minPrice;
    private String maxPrice;
    private String goodsExp;
    private String maker;

    public boolean hasCondition() {
        // TODO 条件が設定されているか確認、ひとつでも設定がある場合はtrue
        return false;
    }

    /**
     * @return the goodsName
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName the goodsName to set
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * @return the minPrice
     */
    public String getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice the minPrice to set
     */
    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @return the maxPrice
     */
    public String getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param maxPrice the maxPrice to set
     */
    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return the goodsExp
     */
    public String getGoodsExp() {
        return goodsExp;
    }

    /**
     * @param goodsExp the goodsExp to set
     */
    public void setGoodsExp(String goodsExp) {
        this.goodsExp = goodsExp;
    }

    /**
     * @return the maker
     */
    public String getMaker() {
        return maker;
    }

    /**
     * @param maker the maker to set
     */
    public void setMaker(String maker) {
        this.maker = maker;
    }


}
