package com.hzero.order.app.service;

import com.hzero.order.domain.DTO.ItemDTO;
import com.hzero.order.domain.vo.SolineVo;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hzero.order.domain.entity.SoLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SoLine)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:08:04
 */
public interface SoLineService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param soLines     查询条件
     * @return 返回值
     */
    Page<SoLine> selectList(PageRequest pageRequest, SoLine soLines);

    /**
     * 保存数据
     *
     * @param soLine 数据
     */
//    void saveData(List<SoLine> soLines);

    Page<SolineVo> listBySoHeaderId(Long organizationId, SoLine soLine, PageRequest pageRequest);

    SoLine detail(Long organizationId, Long soLineId);

    SoLine create(Long organizationId,  SoLine soLine);

    SoLine update(Long organizationId, SoLine soLine);

    void remove(Long organizationId,ItemDTO itemDTO);
}
