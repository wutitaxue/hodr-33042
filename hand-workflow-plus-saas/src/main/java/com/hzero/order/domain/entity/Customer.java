package com.hzero.order.domain.entity;

import java.util.Date;

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
 * (Customer)实体类
 *
 * @author chw
 * @since 2021-08-02 14:00:28
 */
@ApiModel("")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "hodr_customer")
public class Customer extends AuditDomain {
    private static final long serialVersionUID = 241998385326911264L;

    public static final String FIELD_CUSTOMER_ID = "customerId";
    public static final String FIELD_CUSTOMER_NUMBER = "customerNumber";
    public static final String FIELD_CUSTOMER_NAME = "customerName";
    public static final String FIELD_COMAPNY_ID = "comapnyId";
    public static final String FIELD_ENABLED_FLAG = "enabledFlag";
    public static final String FIELD_CREATED_DATE = "createdDate";
    @ApiModelProperty("客户ID（主键）")
    @Id
    @GeneratedValue
    private Long customerId;

    @ApiModelProperty(value = "客户编号")
    private String customerNumber;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "公司ID")
    private Long comapnyId;

    @ApiModelProperty(value = "启用标识")
    private Boolean enabledFlag;

    @ApiModelProperty(value = "创建日期")
    private Date createdDate;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getComapnyId() {
        return comapnyId;
    }

    public void setComapnyId(Long comapnyId) {
        this.comapnyId = comapnyId;
    }

    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
