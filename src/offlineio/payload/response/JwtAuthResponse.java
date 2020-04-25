/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.payload.response;

/**
 *
 * @author Bhaskor
 */
public class JwtAuthResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private ThanaPayload thana;

    public JwtAuthResponse() {
    }

    public JwtAuthResponse(String accessToken, ThanaPayload thana) {
        this.accessToken = accessToken;
        this.thana = thana;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public ThanaPayload getThana() {
        return thana;
    }

    public void setThana(ThanaPayload thana) {
        this.thana = thana;
    }
}
