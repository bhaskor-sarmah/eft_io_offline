/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Bhaskor
 */
public class CommunicationHttpClient {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public CustomHttpResponse sendGET(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(AppSettings.BASE_URL + url))
                    //                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // print response headers
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

            // print status code
            int responseCode = response.statusCode();
            System.out.println(responseCode);

            // print response body
            String responseBody = response.body();
            System.out.println(responseBody);
            return new CustomHttpResponse(responseCode, responseBody);
        } catch (IOException | InterruptedException e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return null;
    }

    public CustomHttpResponse sendPOST(String url, String json, String jwt) {
        try {
            // add json header
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create(AppSettings.BASE_URL + url))
                    //                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + jwt)
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // print status code
            int responseCode = response.statusCode();
            System.out.println(responseCode);

            // print response body
            String responseBody = response.body();
            System.out.println(responseBody);
            return new CustomHttpResponse(responseCode, responseBody);

        } catch (IOException | InterruptedException e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return null;
    }

    public CustomHttpResponse sendPOST(String url, String json) {
        try {
            // add json header
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create(AppSettings.BASE_URL + url))
                    //                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // print status code
            int responseCode = response.statusCode();
            System.out.println(responseCode);

            // print response body
            String responseBody = response.body();
            System.out.println(responseBody);
            return new CustomHttpResponse(responseCode, responseBody);

        } catch (IOException | InterruptedException e) {
            System.out.println("Exception : " + e.getMessage());
        }
        return null;
    }

}
