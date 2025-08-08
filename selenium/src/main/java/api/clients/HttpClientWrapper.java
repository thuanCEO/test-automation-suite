package api.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.LogUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClientWrapper {
    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private final String baseUrl;

    public HttpClientWrapper(String baseUrl) {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.baseUrl = baseUrl;
    }

    public <T> T get(String endpoint, Class<T> responseType) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), responseType);
            } else {
                throw new RuntimeException("Failed GET " + endpoint + " Status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Exception during GET " + endpoint, e);
        }
    }

    public <T> List<T> getList(String endpoint, Class<T> responseItemType) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .GET()
                    .build();

            LogUtils.info("➡️ GET List: " + request.uri());

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            LogUtils.info("⬅️ Status: " + response.statusCode());
            LogUtils.info("⬅️ Body: " + response.body());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(
                        response.body(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, responseItemType)
                );
            } else {
                throw new RuntimeException("❌ Failed GET List " + endpoint + " Status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("❌ Exception during GET List " + endpoint, e);
        }
    }

    public <T> T post(String endpoint, Object body, Class<T> responseType) {
        try {
            String requestBody = objectMapper.writeValueAsString(body);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201 || response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), responseType);
            } else {
                throw new RuntimeException("Failed POST " + endpoint + " Status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Exception during POST " + endpoint, e);
        }
    }

    public <T> T put(String endpoint, Object body, Class<T> responseType) {
        try {
            String requestBody = objectMapper.writeValueAsString(body);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), responseType);
            } else {
                throw new RuntimeException("❌ Failed PUT " + endpoint + " Status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("❌ Exception during PUT " + endpoint, e);
        }
    }

    public <T> T delete(String endpoint, Class<T> responseType) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 || response.statusCode() == 204) {
                return response.body().isEmpty()
                        ? null
                        : objectMapper.readValue(response.body(), responseType);
            } else {
                throw new RuntimeException("❌ Failed DELETE " + endpoint + " Status: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("❌ Exception during DELETE " + endpoint, e);
        }
    }
}