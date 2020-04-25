/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.payload.request;

/**
 *
 * @author Bhaskor
 */
public class PasscodeRequest {
    
    private String deviceId;
    private String macId;
    private String thanaCode;

    public PasscodeRequest() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getThanaCode() {
        return thanaCode;
    }

    public void setThanaCode(String thanaCode) {
        this.thanaCode = thanaCode;
    }
    
    
}
