package com.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hzero.order.domain.entity.Customer;

import java.util.List;

/**
 * (Customer)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:00:34
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 基础查询
     *
     * @param customer 查询条件
     * @return 返回值
     */
    List<Customer> selectList(Customer customer);
}
