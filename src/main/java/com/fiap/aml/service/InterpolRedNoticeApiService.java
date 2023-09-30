package com.fiap.aml.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.aml.converter.InterpolToAmlConverter;
import com.fiap.aml.dao.LanguageSpokenDAO;
import com.fiap.aml.dao.NationalityDAO;
import com.fiap.aml.dao.WantedDAO;
import com.fiap.aml.entity.Wanted;
import com.fiap.aml.temp.InterpolRedNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InterpolRedNoticeApiService {
    private final String apiUrl = "https://ws-public.interpol.int/notices/v1/red?freeText=a&page=1&resultPerPage=200";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final WantedDAO wantedDAO;
    private final NationalityDAO nationalityDAO;
    private final LanguageSpokenDAO languageSpokenDAO;

    @Autowired
    public InterpolRedNoticeApiService(RestTemplate restTemplate, ObjectMapper objectMapper, WantedDAO wantedDAO, NationalityDAO nationalityDAO, LanguageSpokenDAO languageSpokenDAO) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.wantedDAO = wantedDAO;
        this.nationalityDAO = nationalityDAO;
        this.languageSpokenDAO = languageSpokenDAO;
    }

    public void fetchRedNotices() {
        // Fetch the data from the API URL
        JsonNode jsonResponse = restTemplate.getForObject(apiUrl, JsonNode.class);

        if (jsonResponse != null) {
            try {
                JsonNode noticesNode = jsonResponse.get("_embedded").get("notices");

                // Process each red notice
                for (JsonNode notice : noticesNode) {

                    // Extract the link to each item specifically
                    String itemLink = notice.get("_links").get("self").get("href").asText();

                    // Initializing imagesLink
                    String imagesLink = null;

                    // Extract the image link if present
                    if (notice.get("_links").has("images")) {
                        imagesLink = notice.get("_links").get("images").get("href").asText();
                    }

                    // Fetch data from the item-specific link
                    String itemJsonResponse = restTemplate.getForObject(itemLink, String.class);

                    if (itemJsonResponse != null) {
                        // Parse the JSON response into an InterpolRedNotice object
                        InterpolRedNotice redNotice = objectMapper.readValue(itemJsonResponse, InterpolRedNotice.class);

                        // Initialize the image link variable
                        String imageLink = null;


                        // Nested conditionals to ensure that entities that do not have image links do not break the code
                        if (imagesLink != null) {
                            String imagesJsonResponse = restTemplate.getForObject(imagesLink, String.class);

                            if (imagesJsonResponse != null) {
                                JsonNode imagesNode = objectMapper.readTree(imagesJsonResponse);

                                if (imagesNode != null && imagesNode.has("_embedded") && imagesNode.get("_embedded").has("images")) {
                                    JsonNode imagesArray = imagesNode.get("_embedded").get("images");

                                    if (imagesArray != null && imagesArray.isArray() && imagesArray.size() > 0) {
                                        imageLink = imagesArray.get(0).get("_links").get("self").get("href").asText();
                                    }
                                }
                            }
                        }

                        InterpolToAmlConverter converter = new InterpolToAmlConverter(redNotice, nationalityDAO, languageSpokenDAO);
                        Wanted wanted = converter.getWanted();

                        // Setting image and url
                        wanted.setInterpolUrl(itemLink);
                        wanted.setImagePath(imageLink);
                        System.out.println(wanted); //TODO REMOVE

                        // Saving the Wanted entity
                        wantedDAO.save(wanted);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
