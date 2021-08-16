package com.hzero.order.app.service.impl;


import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hzero.order.app.service.CustomerService;
import org.springframework.stereotype.Service;
import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.repository.CustomerRepository;

import java.util.List;

/**
 * (Customer)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:00:43
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> selectList(PageRequest pageRequest, Customer customer) {
        return PageHelper.doPageAndSort(pageRequest, () -> customerRepository.selectList(customer));
    }

    @Override
    public void saveData(List<Customer> customers) {
        customers.forEach(item -> {
            if (item.getCustomerId() == null) {
                customerRepository.insertSelective(item);
            } else {
                customerRepository.updateByPrimaryKeySelective(item);
            }
        });
    }
}
