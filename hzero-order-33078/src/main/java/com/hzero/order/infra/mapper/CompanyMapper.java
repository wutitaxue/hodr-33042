package com.hzero.order.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import com.hzero.order.domain.entity.Company;

import java.util.List;

/**
 * (Company)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:04:25
 */
public interface CompanyMapper extends BaseMapper<Company> {
    /**
     * 基础查询
     *
     * @param company 查询条件
     * @return 返回值
     */
    List<Company> selectList(Company company);
}
