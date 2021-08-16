package com.hzero.order.api.controller.v1;

import com.hzero.order.app.service.CheckService;
import com.hzero.order.domain.entity.SoHeader;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("checkController.v1")
@RequestMapping("/v1/{organizationId}/check")
public class CheckController extends BaseController {
    @Autowired
    private CheckService checkService;

    @ApiOperation(value = "修改销售订单头信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<SoHeader> update(@PathVariable("organizationId") Long organizationId,
                                           @RequestBody SoHeader soHeader) {
        checkService.update(soHeader);
        return Results.success(soHeader);
    }
}