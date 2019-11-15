package com.cy.cyshopspringboot.viewobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
public class ConfirmOrderVO implements Serializable {
    private String skuImg;
    private String spuName;
    private String skuName;
    private BigDecimal nums;
//    单价
    private BigDecimal unitPrice;
//    商品总价
    private BigDecimal price;
    private BigDecimal postPrice;
    private BigDecimal orderPrice;
    private Integer skuId;
    private Integer spuId;
    private Integer paymentId;

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getNums() {
        return nums;
    }

    public void setNums(BigDecimal nums) {
        this.nums = nums;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(BigDecimal postPrice) {
        this.postPrice = postPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "ConfirmOrderVO{" +
                "skuImg='" + skuImg + '\'' +
                ", spuName='" + spuName + '\'' +
                ", skuName='" + skuName + '\'' +
                ", nums=" + nums +
                ", unitPrice=" + unitPrice +
                ", price=" + price +
                ", postPrice=" + postPrice +
                ", orderPrice=" + orderPrice +
                ", skuId=" + skuId +
                ", spuId=" + spuId +
                ", paymentId=" + paymentId +
                '}';
    }
}
