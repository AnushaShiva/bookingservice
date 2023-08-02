package com.example.bookingservice;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class BookingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingserviceApplication.class, args);
	}



	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("RailWay BOOKINGSERVICE").apiInfo(apiInfo()).select()
				.paths(regex("/bookingdetails.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("BOOKINGDETAILS-Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our RailWay BOOKINGDETAILS SERVICE Rest API")
				.termsOfServiceUrl("www.anu.com")
				.license("anusha")
				.licenseUrl("www.anu.com").version("1.0").build();
	}


}


































