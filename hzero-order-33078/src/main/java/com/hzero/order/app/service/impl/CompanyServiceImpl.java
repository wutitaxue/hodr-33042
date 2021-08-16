package com.hzero.order.app.service.impl;


import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.hzero.order.app.service.CompanyService;
import org.springframework.stereotype.Service;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.repository.CompanyRepository;

import java.util.List;

/**
 * (Company)应用服务
 *
 * @author chw
 * @since 2021-08-02 14:04:31
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> selectList(PageRequest pageRequest, Company company) {
        return PageHelper.doPageAndSort(pageRequest, () -> companyRepository.selectList(company));
    }

    @Override
    public void saveData(List<Company> companys) {
        companys.forEach(item -> {
            if (item.getCompanyId() == null) {
                companyRepository.insertSelective(item);
            } else {
                companyRepository.updateByPrimaryKeySelective(item);
            }
        });
    }
}
