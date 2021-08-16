package com.hzero.order.domain.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (SoLine)实体类
 *
 * @author chw
 * @since 2021-08-02 14:07:58
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_so_line")
public class SoLine extends AuditDomain {
    private static final long serialVersionUID = -49245948027828487L;

    public static final String FIELD_SO_LINE_ID = "soLineId";
    public static final String FIELD_SO_HEADER_ID = "soHeaderId";
    public static final String FIELD_LINE_NUMBER = "lineNumber";
    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ORDER_QUALITY = "orderQuality";
    public static final String FIELD_ORDER_QUALITY_UOM = "orderQualityUom";
    public static final String FIELD_UNIT_SELLING_PRICE = "unitSellingPrice";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ADDITION1 = "addition1";
    public static final String FIELD_ADDITION2 = "addition2";
    public static final String FIELD_ADDITION3 = "addition3";
    public static final String FIELD_ADDITION4 = "addition4";
    public static final String FIELD_ADDITION5 = "addition5";
    @ApiModelProperty("订单行ID（主键）")
    @Id
    @GeneratedValue
    private Long soLineId;

    @ApiModelProperty(value = "订单头ID")
    private Long soHeaderId;

    @ApiModelProperty(value = "行号")
    private Integer lineNumber;

//    @ApiModelProperty(value = "创建订单id")
//    private Long CreatedBy;
//
//    @Override
//    public Long getCreatedBy() {
//        return CreatedBy;
//    }
//
//    @Override
//    public void setCreatedBy(Long createdBy) {
//        CreatedBy = createdBy;
//    }

    @ApiModelProperty(value = "产品ID")
    private Long itemId;

    @ApiModelProperty(value = "数量")
    private BigDecimal orderQuality;

    @ApiModelProperty(value = "产品单位")
    private String orderQualityUom;

    @ApiModelProperty(value = "销售单价")
    private BigDecimal unitSellingPrice;

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

    public Integer getLineNumber() {
        return lineNumber;
    }


    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

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
