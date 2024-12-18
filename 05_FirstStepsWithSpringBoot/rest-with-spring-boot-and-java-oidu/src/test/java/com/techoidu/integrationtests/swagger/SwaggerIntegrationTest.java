package com.techoidu.integrationtests.swagger;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import  org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.techoidu.configs.TestConfigs;
import com.techoidu.integrationtests.testcontainers.AbstractIntegrationtest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationtest {

	@Test
	public void shouldDisplaySwaggerUIPage() {
		var content =
		given()
		.basePath("/swagger-ui/index.html")
		.port(TestConfigs.SERVER_PORTT)
		.when()
			.get()
		.then()
			.statusCode(200)
		.extract()
			.body()
				.asString();
		assertTrue(content.contains("Swagger UI"));
	}

}
