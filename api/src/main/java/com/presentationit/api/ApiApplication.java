package com.presentationit.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public DozerBeanMapper mapper() {
		List<String> mappingFiles = Arrays.asList("mappings.xml");
		return new DozerBeanMapper(mappingFiles);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.presentationit.api.controller"))
				.paths(PathSelectors.ant("/api/*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Posts REST API", "Description de l'API pour la présentation.", "0.0.1-SNAPSHOT", "Service",
				new Contact("Presentation IT", "www.presentation-it-guinee.com", "admin@presentation-it-guinee.com"),
				"Licence de l'API", "l'URL de la licence de l'API", Collections.emptyList());
	}
}
