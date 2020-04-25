/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

/**
 *
 * @author Bhaskor
 */
public class Communication {

    OkHttpClient client = new OkHttpClient();
    // code request code here

//    public Response doGetRequest(String url) throws IOException {
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Response response = client.newCall(request).execute();
//        showNetwork(request, response);
//        return response;
//    }
//
//    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//
//    public Response doPostLogin(String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .header("Content-Type", "application/json")
//                .url()
//                .post(body)
//                .build();
//        Response response = client.newCall(request).execute();
//        System.out.println("Data - "+json);
//        showNetwork(request, response);
//        return response;
//    }
//
//    public Response doPostRequest(String url, String json, String jwt) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + jwt)
//                .url(AppSettings.BASE_URL + url)
//                .post(body)
//                .build();
//        Response response = client.newCall(request).execute();
//        System.out.println("Data - "+json);
//        showNetwork(request, response);
//        return response;
//    }
//
//    private void showNetwork(Request request, Response response) {
////        Gson gson = new GsonBuilder().create();
//        System.out.println("========Request=========");
//        System.out.println(request.headers());
////        System.out.println(gson.toJson(request.body()));
//        System.out.println("========Response=========");
//        System.out.println(response.code());
//        System.out.println(response.headers());
//        System.out.println(response.body().toString());
//    }
}
