package com.hand.training.api.controller.v1;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.hand.training.config.SwaggerTags;
import org.hzero.boot.message.entity.Receiver;
import org.hzero.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.hzero.boot.message.MessageClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * API 接口
 */
@Api(tags = SwaggerTags.HAND_MESSAGE)
@RestController("handMessageController.v1")
@RequestMapping("/v1/hand/message")
public class HandMessageController extends BaseController {
    @Autowired
    private MessageClient messageClient;
    @ApiOperation(value = "动态发送消息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "context", value = "CONTEXT", paramType =
                    "path")
    })
    @GetMapping("/{context}")
    public String hello(@PathVariable String context) {
        // TODO
        long tenantId = 0L;
        String serverCode = "HAND_DEMO_006";
        String messageTemplateCode = "HAND_DEMO_007";
        List<Receiver> receiverList = new ArrayList<>();
        Receiver receiver = new Receiver();
        receiver.setEmail("chao.zhang03@hand-china.com");
        receiverList.add(receiver);
        Map<String, String> args = new HashMap<>();
        args.put("parmA", context);
        messageClient.sendEmail(tenantId, serverCode, messageTemplateCode,
                receiverList, args, null);
        return "Hello = " + context;
    } }