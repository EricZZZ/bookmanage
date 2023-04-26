package com.eric.bookmanage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * SpringDoc配置
 * 
 * @author EricZhao
 * @since 2023-04-26
 */
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI creatOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("BookManage API")
                        .description("BookManage API文档")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation().description("BookManage API文档").url("https://www.baidu.com"));

    }

}
