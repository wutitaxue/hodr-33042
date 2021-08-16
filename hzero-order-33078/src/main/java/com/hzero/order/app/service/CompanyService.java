package com.hzero.order.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import com.hzero.order.domain.entity.Company;

import java.util.List;

/**
 * (Company)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:04:30
 */
public interface CompanyService {

    /**
     * 查询数据
     *
     * @param pageRequest 分页参数
     * @param companys    查询条件
     * @return 返回值
     */
    Page<Company> selectList(PageRequest pageRequest, Company companys);

    /**
     * 保存数据
     *
     * @param companys 数据
     */
    void saveData(List<Company> companys);

}
