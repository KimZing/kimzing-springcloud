package com.kimzing.config.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Swagger文档属性.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/1/16 11:11
 */
@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    /**
     * 标题
     */
    private String title;

    /**
     * 文档描述
     */
    private String description;

    /**
     * 项目路径
     */
    private String termsOfServiceUrl;

    /**
     * 作者
     */
    private String authorName;

    /**
     * 邮箱
     */
    private String authorEmail;

    /**
     * 作者主页
     */
    private String authorUrl;

    /**
     * 版本
     */
    private String version;

    /**
     * 扫描的路径
     */
    private String basePackage;

}
