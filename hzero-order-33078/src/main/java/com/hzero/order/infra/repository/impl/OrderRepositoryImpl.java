package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.OrderServiceRepository;
import com.hzero.order.domain.vo.OrderVO;
import com.hzero.order.infra.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class OrderRepositoryImpl implements OrderServiceRepository {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public List<OrderVO> selectList(SoHeader soHeader) {
        return orderMapper.selectList(soHeader);
    }
}
