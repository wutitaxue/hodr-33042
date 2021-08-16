package com.hzero.order.api.controller.v1;

import com.hzero.order.app.service.OrderService;
import com.hzero.order.config.SwaggerTags;
import com.hzero.order.domain.entity.SoHeader;
import com.hzero.order.domain.vo.OrderVO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
@RestController("OrderController.v1")
@RequestMapping("/v1/{organizationId}/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @ApiOperation(value = "销售订单头信息列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<OrderVO>> list(@PathVariable("organizationId") Long organizationId, SoHeader soHeader, @ApiIgnore @SortDefault(value = OrderVO.FIELD_ORDER_NUMBER,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<OrderVO> list = orderService.list(organizationId, soHeader, pageRequest);
        return Results.success(list);
    }

}
