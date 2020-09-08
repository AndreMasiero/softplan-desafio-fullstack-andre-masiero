package br.com.softplan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {
    @Bean
    public Docket api(@Value("${softplan.api.title}") String apiTitle,
                      @Value("${softplan.description}") String apiDescription) {

        ApiInfo apiInfo = new ApiInfoBuilder().title(apiTitle).license("Proprietary").version("1.0")
                .description(apiDescription).build();

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}