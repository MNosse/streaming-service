package br.com.udesc.ceavi.eso.ese.streamingservice

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class StreamingServiceApplication

fun main(args: Array<String>) {
	runApplication<StreamingServiceApplication>(*args)
}

@Configuration
class OpenApiConfig() {
	@Bean
	fun usersMicroserviceOpenApi(): OpenAPI {
		return OpenAPI()
			.info(
				Info().title("Streaming-Web-Service")
					.description("A Streaming web service")
					.version("1.0")
			)
	}
}