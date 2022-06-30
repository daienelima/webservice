package com.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class HttpService {
    public static final String APPLICATION_JSON = "application/json";
    public static final String ACCEPT = "Accept";
    private final HttpClient httpClient= HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    public <T> List<T> sendGetReturnList(String url, Class<T> responseType) throws IOException, InterruptedException, IOException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).header(ACCEPT, APPLICATION_JSON).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, responseType));
    }
}
