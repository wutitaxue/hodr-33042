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
import com.hzero.order.app.service.SoHeaderService;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.repository.SoHeaderRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 销售订单头信息(SoHeader)表控制层
 *
 * @author chw
 * @since 2021-08-02 14:07:13
 */

@RestController("soHeaderController.v1")
@RequestMapping("/v1/{organizationId}/hodr-so-headers")
public class SoHeaderController extends BaseController {

    @Autowired
    private SoHeaderRepository soHeaderRepository;

    @Autowired
    private SoHeaderService soHeaderService;

    @ApiOperation(value = "销售订单头信息列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<SoHeader>> list(SoHeader soHeader, @PathVariable Long organizationId, @ApiIgnore @SortDefault(value = SoHeader.FIELD_SO_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SoHeader> list = soHeaderService.selectList(pageRequest, soHeader);
        return Results.success(list);
    }

    @ApiOperation(value = "销售订单头信息明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{soHeaderId}")
    public ResponseEntity<SoHeader> detail(@PathVariable Long soHeaderId) {
        SoHeader soHeader = soHeaderRepository.selectByPrimary(soHeaderId);
        return Results.success(soHeader);
    }

    @ApiOperation(value = "创建销售订单头信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<SoHeader> save(@PathVariable Long organizationId, @RequestBody SoHeader soHeaders) {
        validObject(soHeaders);
//        SecurityTokenHelper.validTokenIgnoreInsert(soHeaders);
        soHeaderService.saveData(soHeaders);
        return Results.success(soHeaders);
    }

    @ApiOperation(value = "删除销售订单头信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@PathVariable("organizationId") Long organizationId,
                                    @RequestBody SoHeader soHeader) {
        soHeaderRepository.deleteByPrimaryKey(soHeader);
        return Results.success();
    }

    @ApiOperation(value = "修改销售订单头信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<SoHeader> update(@PathVariable("organizationId") Long organizationId,
                                           @RequestBody SoHeader soHeader) {
        soHeaderService.update(organizationId, soHeader);
        return Results.success(soHeader);
    }


    @ApiOperation(value = "订单提交，启动审批流")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/workflow/{soHeaderId}")
    public ResponseEntity<SoHeader> orderStartWorkFlow(@PathVariable("organizationId") Long organizationId,
                                           @PathVariable String soHeaderId) {
        soHeaderService.orderStartWorkFlow( organizationId,soHeaderId);
        return Results.success();
    }

}
