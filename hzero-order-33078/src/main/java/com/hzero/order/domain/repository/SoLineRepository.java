package com.hzero.order.domain.repository;

import com.hzero.order.domain.vo.SolineVo;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import com.hzero.order.domain.entity.SoLine;

import java.util.List;

/**
 * (SoLine)资源库
 *
 * @author chw
 * @since 2021-08-02 14:08:01
 */
public interface SoLineRepository extends BaseRepository<SoLine> {
    /**
     * 查询
     *
     * @param soLine 查询条件
     * @return 返回值
     */
    List<SoLine> selectList(SoLine soLine);

    /**
     * 根据主键查询（可关联表）
     *
     * @param soLineId 主键
     * @return 返回值
     */
    SoLine selectByPrimary(Long soLineId);

    Page<SolineVo> listBySoHeaderId(SoLine soLine, PageRequest pageRequest);

}
