package com.cy.cyshopspringboot.viewobject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 1.0.0
 * @ClassName OrderInfoVO
 * @Description TODO
 * @Author 王苑鹏
 * @date 2019/11/13 11:39
 */
public class OrderInfoVO {
    /**
     * 需要的数据
     * 订单数据
     * 订单商品数据
     * 商品数据
     */

    /**
     * 订单编号
     */
    private Integer oid;

    /**
     * 用户id
     */
    private Integer mid;
    /**
     * 地址id
     */
    private Integer address;
    /**
     * 订单创建时间
     */
    private Date time;
    /**
     * 支付时间
     */
    private Date ptime;
    /**
     * 总价
     */
    private BigDecimal totle;
    /**
     * 折扣
     */
    private BigDecimal discounts;
    /**
     * 邮费
     */
    private BigDecimal postPrice;
    /**
     * 支付金额
     */
    private BigDecimal payment;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 假删编号
     */
    private Integer deleteStatus;
    /**
     * 购买数量
     */
    private Integer nums;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 支付方式
     */
    private String payway;

    /**
     * sku
     */
    private Integer sid;

    /**
     * 款式
     */
    private String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public BigDecimal getTotle() {
        return totle;
    }

    public void setTotle(BigDecimal totle) {
        this.totle = totle;
    }

    public BigDecimal getDiscounts() {
        return discounts;
    }

    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }

    public BigDecimal getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(BigDecimal postPrice) {
        this.postPrice = postPrice;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "oid=" + oid +
                ", mid=" + mid +
                ", address=" + address +
                ", time=" + time +
                ", ptime=" + ptime +
                ", totle=" + totle +
                ", discounts=" + discounts +
                ", postPrice=" + postPrice +
                ", payment=" + payment +
                ", status=" + status +
                ", deleteStatus=" + deleteStatus +
                ", nums=" + nums +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", payway='" + payway + '\'' +
                ", sid=" + sid +
                ", des='" + des + '\'' +
                '}';
    }
}
