package tech.wushi.experiment4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/19 23:38
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder()
                        .contact(new Contact("无诗","https://xn--rgv085f.tech/","david.wushi@foxmail.com"))
                        .title("学生信息管理系统API")
                        .description("无诗的API文档")
                        .version("1.0")
                        .build()
        );
    }
}
