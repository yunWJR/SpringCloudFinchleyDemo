package com.yun.yscd.common.config;

import com.yun.yscd.common.config.properties.QiniuProperties;
import com.yun.yscd.common.config.properties.SwaggerProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: yun
 * @createdOn: 2019-05-07 10:11.
 */

@Data
@ConfigurationProperties(prefix = "yscd")
public class YscdProperties {
    private SwaggerProperties swagger = new SwaggerProperties();
    private QiniuProperties qiniu = new QiniuProperties();
}