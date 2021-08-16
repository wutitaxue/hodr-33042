package com.hzero.order.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hzero.order.domain.entity.SoHeader;

import java.util.List;

/**
 * 销售订单头信息(SoHeader)资源库
 *
 * @author chw
 * @since 2021-08-02 14:07:09
 */
public interface SoHeaderRepository extends BaseRepository<SoHeader> {
    /**
     * 查询
     *
     * @param soHeader 查询条件
     * @return 返回值
     */
    List<SoHeader> selectList(SoHeader soHeader);

    /**
     * 根据主键查询（可关联表）
     *
     * @param soHeaderId 主键
     * @return 返回值
     */
    SoHeader selectByPrimary(Long soHeaderId);
}
