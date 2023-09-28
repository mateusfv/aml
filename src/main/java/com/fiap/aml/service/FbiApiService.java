package com.fiap.aml.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.aml.temp.FbiWanted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FbiApiService {

    private static final String FBI_API_BASE_URL = "https://api.fbi.gov/@wanted?pageSize=20&page=";
    private static final int TOTAL_PAGES = 51;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public FbiApiService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public List<FbiWanted> fetchDataFromFbiApi() {
        List<FbiWanted> processedItems = new ArrayList<>();

        for (int page = 1; page <= TOTAL_PAGES; page++) {
            String apiUrl = FBI_API_BASE_URL + page + "&sort_on=modified&sort_order=desc";

            String response = restTemplate.getForObject(apiUrl, String.class);
            JsonNode jsonNode = parseJson(response);

            JsonNode items = jsonNode.get("items");

            for (JsonNode item : items) {
                try {
                    FbiWanted fbiWanted = objectMapper.readValue(item.toString(), FbiWanted.class);
                    System.out.println(fbiWanted);
                } catch (Exception e) {
                throw new RuntimeException("Error mapping JSON item to Java object", e);
            }
            }
        }
        return processedItems;
    }

    private JsonNode parseJson(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}