package com.yun.yscd.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yun
 * @createdOn: 2019-05-07 10:11.
 */

@Configuration
@EnableConfigurationProperties(YscdProperties.class)
public class YscdPropertiesConfig {
}
