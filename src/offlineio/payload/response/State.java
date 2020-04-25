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
public class State
{
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String stateCode;

    private Country country;

    private String stateName;

    private String stateAsm;

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
    public void setStateCode(String stateCode){
        this.stateCode = stateCode;
    }
    public String getStateCode(){
        return this.stateCode;
    }
    public void setCountry(Country country){
        this.country = country;
    }
    public Country getCountry(){
        return this.country;
    }
    public void setStateName(String stateName){
        this.stateName = stateName;
    }
    public String getStateName(){
        return this.stateName;
    }
    public void setStateAsm(String stateAsm){
        this.stateAsm = stateAsm;
    }
    public String getStateAsm(){
        return this.stateAsm;
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
