package com.hzero.order.domain.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class SolineVo {
    @ApiModelProperty("物料ID(主键)")
    private Long itemId;

    @ApiModelProperty(value = "物料编码")
    private String itemCode;

    @ApiModelProperty(value = "物料描述")
    private String itemDescription;

    @ApiModelProperty("订单行ID(主键)")
    private Long soLineId;

    @ApiModelProperty(value = "订单头ID")
    private Long soHeaderId;

    @ApiModelProperty(value = "版本号")
    private Long objectVersionNumber;

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    @ApiModelProperty(value = "行号")
    private Long lineNumber;

    @ApiModelProperty(value = "数量")
    private BigDecimal orderQuality;

    @ApiModelProperty(value = "产品单位")
    private String orderQualityUom;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal unitSellingPrice;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "附加信息1")
    private String addition1;

    @ApiModelProperty(value = "附加信息2")
    private String addition2;

    @ApiModelProperty(value = "附加信息3")
    private String addition3;

    @ApiModelProperty(value = "附加信息4")
    private String addition4;

    @ApiModelProperty(value = "附加信息5")
    private String addition5;

    public BigDecimal getOrderQuality() {
        return orderQuality;
    }

    public void setOrderQuality(BigDecimal orderQuality) {
        this.orderQuality = orderQuality;
    }

    public String getOrderQualityUom() {
        return orderQualityUom;
    }

    public void setOrderQualityUom(String orderQualityUom) {
        this.orderQualityUom = orderQualityUom;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }


    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }
}


