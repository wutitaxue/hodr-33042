package com.hzero.order.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hzero.order.app.service.CompanyService;
import com.hzero.order.domain.entity.Company;
import com.hzero.order.domain.repository.CompanyRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * (Company)表控制层
 *
 * @author chw
 * @since 2021-08-02 14:04:31
 */

@RestController("companyController.v1")
@RequestMapping("/v1/{organizationId}/hodr-companys")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Company>> list(Company company, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = Company.FIELD_COMPANY_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Company> list = companyService.selectList(pageRequest, company);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> detail(@PathVariable Long companyId) {
        Company company = companyRepository.selectByPrimary(companyId);
        return Results.success(company);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<Company>> save(@PathVariable Long organizationId, @RequestBody List<Company> companys) {
        validObject(companys);
        SecurityTokenHelper.validTokenIgnoreInsert(companys);
        companyService.saveData(companys);
        return Results.success(companys);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Company company) {
        SecurityTokenHelper.validToken(company);
        companyRepository.deleteByPrimaryKey(company);
        return Results.success();
    }

}
