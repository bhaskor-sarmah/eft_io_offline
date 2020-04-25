/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

/**
 *
 * @author Bhaskor
 */
public class CustomHttpResponse {
    int code;
    String body;

    public CustomHttpResponse(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public CustomHttpResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
}
