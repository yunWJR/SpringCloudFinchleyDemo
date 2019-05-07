package com.yun.yscd.common.config.properties;

import lombok.Data;

@Data
public class QiniuProperties {
    private String accessKey;
    private String secretKey;
    private String url;
    private String bucket;
}
