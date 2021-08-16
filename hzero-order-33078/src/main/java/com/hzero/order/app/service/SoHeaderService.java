package com.hzero.order.app.service;

import com.hzero.order.infra.mapper.SoHeaderMapper;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hzero.order.domain.entity.SoHeader;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 销售订单头信息(SoHeader)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:07:11
 */
public interface SoHeaderService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param soHeaders   查询条件
     * @return 返回值
     */
    Page<SoHeader> selectList(PageRequest pageRequest, SoHeader soHeaders);

    /**
     * 保存数据
     *
     * @param soHeaders 数据
     */
    void saveData(SoHeader soHeaders);
   SoHeader update(Long organizationId, SoHeader soHeader);

    /**
     * 提交，启动审批流
     * @param organizationId
     * @param soHeaderId
     */
    void orderStartWorkFlow(Long organizationId, String soHeaderId);
}
