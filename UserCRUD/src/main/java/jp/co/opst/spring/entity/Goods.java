package jp.co.opst.spring.entity;

import java.sql.Date;

public class Goods {

    private String goodsNum;
    private String goodsName;
    private String goodsPrice;
    private String goodsExp;
    private String maker;
    private Date regDate;
    private Date lstUpdateTime;
    /**
     * @return the goodsNum
     */
    public String getGoodsNum() {
        return goodsNum;
    }
    /**
     * @param goodsNum the goodsNum to set
     */
    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
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
     * @return the goodsPrice
     */
    public String getGoodsPrice() {
        return goodsPrice;
    }
    /**
     * @param goodsPrice the goodsPrice to set
     */
    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
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
    /**
     * @return the regDate
     */
    public Date getRegDate() {
        return regDate;
    }
    /**
     * @param regDate the regDate to set
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    /**
     * @return the lstUpdateTime
     */
    public Date getLstUpdateTime() {
        return lstUpdateTime;
    }
    /**
     * @param lstUpdateTime the lstUpdateTime to set
     */
    public void setLstUpdateTime(Date lstUpdateTime) {
        this.lstUpdateTime = lstUpdateTime;
    }

}
