package com.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hzero.order.domain.entity.SoHeader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 销售订单头信息(SoHeader)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:07:07
 */
@Mapper
public interface SoHeaderMapper extends BaseMapper<SoHeader> {
    Long closeOrderStatus();
    List<SoHeader> selectList(SoHeader soHeader);
}
