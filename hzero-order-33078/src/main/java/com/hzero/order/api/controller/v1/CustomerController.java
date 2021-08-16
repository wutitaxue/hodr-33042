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
import com.hzero.order.app.service.CustomerService;
import com.hzero.order.domain.entity.Customer;
import com.hzero.order.domain.repository.CustomerRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * (Customer)表控制层
 *
 * @author chw
 * @since 2021-08-02 14:02:12
 */

@RestController("customerController.v1")
@RequestMapping("/v1/{organizationId}/hodr-customers")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Customer>> list(Customer customer, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = Customer.FIELD_CUSTOMER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Customer> list = customerService.selectList(pageRequest, customer);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> detail(@PathVariable Long customerId) {
        Customer customer = customerRepository.selectByPrimary(customerId);
        return Results.success(customer);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<List<Customer>> save(@PathVariable Long organizationId, @RequestBody List<Customer> customers) {
        validObject(customers);
        SecurityTokenHelper.validTokenIgnoreInsert(customers);
        customerService.saveData(customers);
        return Results.success(customers);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Customer customer) {
        SecurityTokenHelper.validToken(customer);
        customerRepository.deleteByPrimaryKey(customer);
        return Results.success();
    }

}
