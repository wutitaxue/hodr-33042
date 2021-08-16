package com.hzero.order.api.controller.v1;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.hzero.order.config.SwaggerTags;
import org.hzero.boot.interfaces.sdk.dto.RequestPayloadDTO;
import org.hzero.boot.interfaces.sdk.dto.ResponsePayloadDTO;
import org.hzero.boot.interfaces.sdk.invoke.InterfaceInvokeSdk;
import org.hzero.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * API 接口
 */
@Api(tags = SwaggerTags.HAND_WORKFLOW)
@RestController("handInterfaceController.v1")
@RequestMapping("/v1/{organizationId}/hand/interface")
public class HandInterfaceController extends BaseController {
    @Autowired
    private InterfaceInvokeSdk interfaceInvokeSdk;
    @ApiOperation(value = "调用一个接口")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/invoke")
    public ResponsePayloadDTO invoke(@PathVariable long organizationId) {
        // TODO
        String namespace = "HZERO";
        String interfaceCode = "HAND_DEMO_037000001";
        String serverCode = "HAND_DEMO_037";
        RequestPayloadDTO payload = new RequestPayloadDTO();
        ResponsePayloadDTO responsePayloadDTO =
                interfaceInvokeSdk.invoke(namespace,
                        serverCode,
                        interfaceCode,
                        payload);
        return responsePayloadDTO;
    } }