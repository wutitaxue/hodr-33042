package com.hzero.order.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import com.hzero.order.infra.mapper.SoHeaderMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * 销售订单头信息(SoHeader)资源库
 *
 * @author chw
 * @since 2021-08-02 14:07:10
 */
@Component
public class SoHeaderRepositoryImpl extends BaseRepositoryImpl<SoHeader> implements SoHeaderRepository {
    @Resource
    private SoHeaderMapper soHeaderMapper;

    @Override
    public List<SoHeader> selectList(SoHeader soHeader) {
        return soHeaderMapper.selectList(soHeader);
    }

    @Override
    public SoHeader selectByPrimary(Long soHeaderId) {
        SoHeader soHeader = new SoHeader();
        soHeader.setSoHeaderId(soHeaderId);
        List<SoHeader> soHeaders = soHeaderMapper.selectList(soHeader);
        if (CollectionUtils.isEmpty(soHeaders)) {
            return null;
        }
        return soHeaders.get(0);
    }

}
