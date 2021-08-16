package com.hzero.order.api.controller.v1;

import com.hzero.order.config.SwaggerTags;
import com.hzero.order.domain.DTO.ItemDTO;
import com.hzero.order.domain.vo.SolineVo;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hzero.order.app.service.SoLineService;
import com.hzero.order.domain.entity.SoLine;
import com.hzero.order.domain.repository.SoLineRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * (SoLine)表控制层
 *
 * @author chw
 * @since 2021-08-02 14:08:05
 */

@Api(tags = SwaggerTags.ORDER_SOLINE)
@RestController("soLineController.v1")
@RequestMapping("/v1/{organizationId}/so-lines")
public class SoLineController extends BaseController {

    private final SoLineService soLineService;

    @Autowired
    public SoLineController(SoLineService soLineService) {
        this.soLineService = soLineService;
    }

    @ApiOperation(value = "通过订单头id 获取销售订单信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<SolineVo>> listBySoHeaderId(@PathVariable("organizationId") Long organizationId, SoLine soLine,
                                                           @ApiIgnore @SortDefault(value = SoLine.FIELD_SO_LINE_ID,
                                                                   direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<SolineVo> list = soLineService.listBySoHeaderId(organizationId, soLine, pageRequest);
        return Results.success(list);
    }

    @ApiOperation(value = "销售订单信息明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{soLineId}")
    public ResponseEntity<SoLine> detail(@PathVariable("organizationId") Long organizationId,
                                         @PathVariable Long soLineId) {
        SoLine soLine = soLineService.detail(organizationId, soLineId);
        return Results.success(soLine);
    }

    @ApiOperation(value = "创建销售订单信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<SoLine> create(@PathVariable("organizationId") Long organizationId,
                                         @RequestBody SoLine soLine) {
        soLineService.create(organizationId, soLine);
        return Results.success(soLine);
    }

    @ApiOperation(value = "修改销售订单信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<SoLine> update(@PathVariable("organizationId") Long organizationId,
                                         @RequestBody SoLine soLine) {
        soLineService.update(organizationId, soLine);
        return Results.success(soLine);
    }

    @ApiOperation(value = "批量删除销售订单信息")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@PathVariable("organizationId") Long organizationId,
                                    @RequestBody ItemDTO itemDTO) {
        soLineService.remove(organizationId,itemDTO);
        return Results.success();
    }

}