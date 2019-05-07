package com.yun.yscd.common.config.properties;

import lombok.Data;

@Data
public class SwaggerProperties {

    private String title = "接口文档";

    private String description = "接口文档";

    private String version = "1.0.0";

    private String license = "license";

    private String licenseUrl = "licenseUrl";

    private String contactName = "yun";

    private String contactUrl = "yun";

    private String contactEmail = "yun";

    private Boolean enable = true;
}
