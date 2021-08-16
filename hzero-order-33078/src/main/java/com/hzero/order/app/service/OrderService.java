package com.hzero.order.app.service;

import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.vo.OrderVO;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

public interface OrderService {

    Page<OrderVO> list(Long organizationId, SoHeader soHeader, PageRequest pageRequest);
}
