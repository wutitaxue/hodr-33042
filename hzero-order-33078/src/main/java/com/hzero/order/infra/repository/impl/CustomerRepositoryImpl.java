package com.hzero.order.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.repository.CustomerRepository;
import com.hzero.order.infra.mapper.CustomerMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Customer)资源库
 *
 * @author chw
 * @since 2021-08-02 14:02:11
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> selectList(Customer customer) {
        return customerMapper.selectList(customer);
    }

    @Override
    public Customer selectByPrimary(Long customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        List<Customer> customers = customerMapper.selectList(customer);
        if (CollectionUtils.isEmpty(customers)) {
            return null;
        }
        return customers.get(0);
    }

}
