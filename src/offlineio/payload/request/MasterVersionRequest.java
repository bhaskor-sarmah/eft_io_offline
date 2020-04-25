/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.payload.request;

import java.util.List;

/**
 *
 * @author Bhaskor
 */
public class MasterVersionRequest {
    private String deviceId;
    private String macId;
    private List<MasterVersionForm> masterVersionForm;

    public MasterVersionRequest() {
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

    public List<MasterVersionForm> getMasterVersionForm() {
        return masterVersionForm;
    }

    public void setMasterVersionForm(List<MasterVersionForm> masterVersionForm) {
        this.masterVersionForm = masterVersionForm;
    }

    
}
