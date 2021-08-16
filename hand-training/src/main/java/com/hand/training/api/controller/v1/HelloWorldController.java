package com.hand.training.api.controller.v1;

import com.hand.training.app.service.ExampleService;
import com.hand.training.config.SwaggerTags;
import com.hand.training.domain.entity.Example;
import com.hand.training.domain.repository.ExampleRepository;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API接口
 */
@Api(tags = SwaggerTags.HELLO_WORLD)
@RestController("HelloWorldController.v1")
@RequestMapping("/v1/helloworld")
public class HelloWorldController extends BaseController {

    @ApiOperation(value = "根据ID获取")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "path")
    })
    @GetMapping("/{id}")
    public String hello(@PathVariable Long id) {
        return "HelloWorld = " + id;
    }


}