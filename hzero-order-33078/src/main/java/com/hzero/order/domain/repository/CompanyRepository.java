package com.hzero.order.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.hzero.order.domain.entity.Company;

import java.util.List;

/**
 * (Company)资源库
 *
 * @author chw
 * @since 2021-08-02 14:04:28
 */
public interface CompanyRepository extends BaseRepository<Company> {
    /**
     * 查询
     *
     * @param company 查询条件
     * @return 返回值
     */
    List<Company> selectList(Company company);

    /**
     * 根据主键查询（可关联表）
     *
     * @param companyId 主键
     * @return 返回值
     */
    Company selectByPrimary(Long companyId);
}
