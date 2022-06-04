package com;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket generateMyDoc() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com"))
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		Contact c = new Contact("Tejas Shah", "", "tejas14all@gmail.com");
		ApiInfo apiInfo = new ApiInfo("dummyApi", "apis for demo", "1.0", "T&C", c, "Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
//ClassPathXmlApplicationContext context 