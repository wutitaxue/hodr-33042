package com.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hzero.order.domain.entity.SoLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SoLine)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:07:59
 */
public interface SoLineMapper extends BaseMapper<SoLine> {
    /**
     * 基础查询
     *
     * @param soLine 查询条件
     * @return 返回值
     */

    List<SoLine> selectList(SoLine soLine);

    List<SoLine> listSoLineBySoHeaderId(@Param("soLine") SoLine soLine);
}
