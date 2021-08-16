package com.hzero.order.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hzero.order.domain.entity.Customer;

import java.util.List;

/**
 * (Customer)资源库
 *
 * @author chw
 * @since 2021-08-02 14:02:10
 */
public interface CustomerRepository extends BaseRepository<Customer> {
    /**
     * 查询
     *
     * @param customer 查询条件
     * @return 返回值
     */
    List<Customer> selectList(Customer customer);

    /**
     * 根据主键查询（可关联表）
     *
     * @param customerId 主键
     * @return 返回值
     */
    Customer selectByPrimary(Long customerId);
}
