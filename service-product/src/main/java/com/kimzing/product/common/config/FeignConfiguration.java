package com.kimzing.product.common.config;

        import org.springframework.cloud.openfeign.EnableFeignClients;
        import org.springframework.context.annotation.Configuration;

/**
 * Feign配置类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/20 14:56
 */
@Configuration
@EnableFeignClients(basePackages = {"com.kimzing"})
public class FeignConfiguration {

}
