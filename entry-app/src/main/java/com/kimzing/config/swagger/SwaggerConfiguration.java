package com.kimzing.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.kimzing.config.swagger.properties.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableKnife4j
@Configuration
@EnableConfigurationProperties(value = SwaggerProperties.class)
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi(SwaggerProperties swaggerProperties) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title(swaggerProperties.getTitle())
                                .description(swaggerProperties.getDescription())
                                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                                .contact(new Contact(swaggerProperties.getAuthorName(),
                                        swaggerProperties.getAuthorUrl(),
                                        swaggerProperties.getAuthorEmail()))
                                .version(swaggerProperties.getVersion())
                                .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

}