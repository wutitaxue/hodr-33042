package com.hzero.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerTags {

    public static final String EXAMPLE = "Example";
    public static final String ORDER_SOLINE = "SoLine";
    public static final String HAND_MESSAGE = "hand message";
    public static final String HAND_WORKFLOW="hand workflow";
    public static final String HAND_WORKFLOW_PLUS="hand workflow plus";


    @Autowired
    public SwaggerTags(Docket docket) {
        docket.tags(
                new Tag(EXAMPLE, "EXAMPLE 案例")
        );
    }
}
