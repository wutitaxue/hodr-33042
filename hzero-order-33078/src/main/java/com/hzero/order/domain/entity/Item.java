package com.hzero.order.domain.entity;

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
 * 物料(Item)实体类
 *
 * @author chw
 * @since 2021-08-02 14:06:19
 */
@ApiModel("物料")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_item")
public class Item extends AuditDomain {
    private static final long serialVersionUID = 572239457947726424L;

    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ITEM_CODE = "itemCode";
    public static final String FIELD_ITEM_UOM = "itemUom";
    public static final String FIELD_ITEM_DESCRIPTION = "itemDescription";
    public static final String FIELD_SALEABLE_FLAG = "saleableFlag";
    public static final String FIELD_START_ACTIVE_DATE = "startActiveDate";
    public static final String FIELD_END_ACTIVE_DATE = "endActiveDate";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    @ApiModelProperty("物料ID(主键)")
    @Id
    @GeneratedValue
    private Long itemId;

    @ApiModelProperty(value = "物料编码")
    private String itemCode;

    @ApiModelProperty(value = "物料单位")
    private String itemUom;

    @ApiModelProperty(value = "物料描述")
    private String itemDescription;

    @ApiModelProperty(value = "可销售标识(默认为1)")
    private Boolean saleableFlag;

    @ApiModelProperty(value = "生效起始时间")
    private Date startActiveDate;

    @ApiModelProperty(value = "生效结束时间")
    private Date endActiveDate;

    @ApiModelProperty(value = "启用标识")
    private Boolean enabledFlag;


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

    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Boolean getSaleableFlag() {
        return saleableFlag;
    }

    public void setSaleableFlag(Boolean saleableFlag) {
        this.saleableFlag = saleableFlag;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

}
