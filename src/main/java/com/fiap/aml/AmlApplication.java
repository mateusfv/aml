package com.fiap.aml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.aml.service.FbiApiService;
import com.fiap.aml.temp.FbiWanted;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AmlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AmlApplication.class, args);

		FbiApiService fbiApiService = context.getBean(FbiApiService.class);

		List<FbiWanted> apiData = fbiApiService.fetchDataFromFbiApi();

		System.out.println(apiData);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}