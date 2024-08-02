package com.example.assign2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The inner working of the api
 */
public class APIUtility {

    /**
     * sends request to the given url and returns the data
     * @param uri of the api
     * @return json
     */
    String sendRequest(String uri){
        String json = "";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        }
        catch (Exception e){
            System.err.println("Cannot retrieve request with URI of " + uri);
        }

        return json;
    }
}