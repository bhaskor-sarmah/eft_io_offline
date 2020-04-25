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
public class District
{
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String districtCode;

    private State state;

    private String districtName;

    private String districtAsm;

    private String typeOfDistrict;

    private String version;

    private String isActive;

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    public String getCreatedBy(){
        return this.createdBy;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt(){
        return this.updatedAt;
    }
    public void setDistrictCode(String districtCode){
        this.districtCode = districtCode;
    }
    public String getDistrictCode(){
        return this.districtCode;
    }
    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return this.state;
    }
    public void setDistrictName(String districtName){
        this.districtName = districtName;
    }
    public String getDistrictName(){
        return this.districtName;
    }
    public void setDistrictAsm(String districtAsm){
        this.districtAsm = districtAsm;
    }
    public String getDistrictAsm(){
        return this.districtAsm;
    }
    public void setTypeOfDistrict(String typeOfDistrict){
        this.typeOfDistrict = typeOfDistrict;
    }
    public String getTypeOfDistrict(){
        return this.typeOfDistrict;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return this.version;
    }
    public void setIsActive(String isActive){
        this.isActive = isActive;
    }
    public String getIsActive(){
        return this.isActive;
    }
}
