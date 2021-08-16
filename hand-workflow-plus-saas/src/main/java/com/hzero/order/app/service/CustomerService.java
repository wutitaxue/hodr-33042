package com.hzero.order.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hzero.order.domain.entity.Customer;

import java.util.List;

/**
 * (Customer)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:00:42
 */
public interface CustomerService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param customers   查询条件
     * @return 返回值
     */
    Page<Customer> selectList(PageRequest pageRequest, Customer customers);

    /**
     * 保存数据
     *
     * @param customers 数据
     */
    void saveData(List<Customer> customers);

}
