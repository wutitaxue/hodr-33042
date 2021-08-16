package com.hzero.order.domain.repository;

import com.hzero.order.app.service.OrderService;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.vo.OrderVO;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

public interface OrderServiceRepository  {
    /**
     * 查询
     *
     * @param soHeader 查询条件
     * @return 返回值
     */
    List<OrderVO> selectList(SoHeader soHeader);
}
