package com.hzero.order.infra.repository.impl;

import com.hzero.order.domain.vo.SolineVo;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hzero.order.domain.entity.SoLine;
import com.hzero.order.domain.repository.SoLineRepository;
import com.hzero.order.infra.mapper.SoLineMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SoLine)资源库
 *
 * @author chw
 * @since 2021-08-02 14:08:03
 */
@Component
public class SoLineRepositoryImpl extends BaseRepositoryImpl<SoLine> implements SoLineRepository {
    @Resource
    private SoLineMapper soLineMapper;

    @Override
    public List<SoLine> selectList(SoLine soLine) {
        return soLineMapper.selectList(soLine);
    }

    @Override
    public SoLine selectByPrimary(Long soLineId) {
        SoLine soLine = new SoLine();
        soLine.setSoLineId(soLineId);
        List<SoLine> soLines = soLineMapper.selectList(soLine);
        if (CollectionUtils.isEmpty(soLines)) {
            return null;
        }
        return soLines.get(0);
    }

    @Override
    public Page<SolineVo> listBySoHeaderId(SoLine soLine, PageRequest pageRequest) {
        return PageHelper.doPageAndSort(pageRequest, () -> soLineMapper.listSoLineBySoHeaderId(soLine));
    }

}
