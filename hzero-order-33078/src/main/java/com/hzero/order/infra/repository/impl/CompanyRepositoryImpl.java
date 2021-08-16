package com.hzero.order.infra.repository.impl;

import org.apache.commons.collections.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.repository.CompanyRepository;
import com.hzero.order.infra.mapper.CompanyMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Company)资源库
 *
 * @author chw
 * @since 2021-08-02 14:04:30
 */
@Component
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public List<Company> selectList(Company company) {
        return companyMapper.selectList(company);
    }

    @Override
    public Company selectByPrimary(Long companyId) {
        Company company = new Company();
        company.setCompanyId(companyId);
        List<Company> companys = companyMapper.selectList(company);
        if (CollectionUtils.isEmpty(companys)) {
            return null;
        }
        return companys.get(0);
    }

}
