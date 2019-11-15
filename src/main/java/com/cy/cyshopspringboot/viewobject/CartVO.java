package com.cy.cyshopspringboot.viewobject;

import java.math.BigDecimal;

/**
 * @ClassName: CartMessage
 * @Description: 该实体类用于存放购物车所需的信息
 * @Author: 罗海
 * @Date: 2019/11/13 11:24
 **/
public class CartVO {

    private Integer memberId;

    private BigDecimal memberDiscount;

    private String skuName;

    private BigDecimal price;

    private Integer number;

    private String img;

    private Integer skuId;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(BigDecimal memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Override
    public String toString() {
        return "CartMessage{" +
                "memberId=" + memberId +
                ", memberDiscount=" + memberDiscount +
                ", skuName='" + skuName + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", img='" + img + '\'' +
                ", skuId=" + skuId +
                ", description='" + description + '\'' +
                '}';
    }
}
