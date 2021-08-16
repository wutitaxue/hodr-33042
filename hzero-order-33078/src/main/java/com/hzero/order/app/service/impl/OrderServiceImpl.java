package com.hzero.order.app.service.impl;

import com.hzero.order.app.service.OrderService;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.OrderServiceRepository;
import com.hzero.order.domain.vo.OrderVO;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderServiceRepository orderServiceRepository;
    @Override
    public Page<OrderVO> list(Long organizationId, SoHeader soHeader, PageRequest pageRequest) {
        return  PageHelper.doPageAndSort(pageRequest, () -> orderServiceRepository.selectList(soHeader));
    }
}
