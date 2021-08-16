package com.hzero.order.infra.mapper;

import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.vo.OrderVO;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 销售订单头信息(SoHeader)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:07:07
 */
public interface OrderMapper  {
    /**
     * 基础查询
     *
     * @param soHeader 查询条件
     * @return 返回值
     */
    List<OrderVO> selectList(SoHeader soHeader);
}
