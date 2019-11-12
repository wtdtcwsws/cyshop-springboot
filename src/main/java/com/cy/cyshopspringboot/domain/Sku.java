package com.cy.cyshopspringboot.domain;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "`sku`")
public class Sku {
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * sku名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 价格
     */
    @Column(name = "`price`")
    private BigDecimal price;

    /**
     * 库存
     */
    @Column(name = "`stock`")
    private Integer stock;

    /**
     * 模型编号
     */
    @Column(name = "`model_id`")
    private Integer modelId;

    /**
     * spu编号
     */
    @Column(name = "`spu_id`")
    private Integer spuId;

    /**
     * sku描述，包含属性，属性值
     */
    @Column(name = "`description`")
    private String description;

    /**
     * sku属性组合
     */
    @Column(name = "`sku_attri_group_id`")
    private Integer skuAttriGroupId;

    /**
     * sku状态，1表示上架，0表示下架
     */
    @Column(name = "`sku_status`")
    private Integer skuStatus;

    /**
     * sku库存预警
     */
    @Column(name = "`stock_warning`")
    private Integer stockWarning;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取sku名称
     *
     * @return name - sku名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置sku名称
     *
     * @param name sku名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取模型编号
     *
     * @return model_id - 模型编号
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * 设置模型编号
     *
     * @param modelId 模型编号
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取spu编号
     *
     * @return spu_id - spu编号
     */
    public Integer getSpuId() {
        return spuId;
    }

    /**
     * 设置spu编号
     *
     * @param spuId spu编号
     */
    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    /**
     * 获取sku描述，包含属性，属性值
     *
     * @return description - sku描述，包含属性，属性值
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置sku描述，包含属性，属性值
     *
     * @param description sku描述，包含属性，属性值
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取sku属性组合
     *
     * @return sku_attri_group_id - sku属性组合
     */
    public Integer getSkuAttriGroupId() {
        return skuAttriGroupId;
    }

    /**
     * 设置sku属性组合
     *
     * @param skuAttriGroupId sku属性组合
     */
    public void setSkuAttriGroupId(Integer skuAttriGroupId) {
        this.skuAttriGroupId = skuAttriGroupId;
    }

    /**
     * 获取sku状态，1表示上架，0表示下架
     *
     * @return sku_status - sku状态，1表示上架，0表示下架
     */
    public Integer getSkuStatus() {
        return skuStatus;
    }

    /**
     * 设置sku状态，1表示上架，0表示下架
     *
     * @param skuStatus sku状态，1表示上架，0表示下架
     */
    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
    }

    /**
     * 获取sku库存预警
     *
     * @return stock_warning - sku库存预警
     */
    public Integer getStockWarning() {
        return stockWarning;
    }

    /**
     * 设置sku库存预警
     *
     * @param stockWarning sku库存预警
     */
    public void setStockWarning(Integer stockWarning) {
        this.stockWarning = stockWarning;
    }
}