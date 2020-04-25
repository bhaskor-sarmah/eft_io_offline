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
public class Lac
{
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String lacCode;

    private String lacName;

    private String lacAsm;

    private String loksabha;

    private String version;

    private String isActive;

    private District district;

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
    public void setLacCode(String lacCode){
        this.lacCode = lacCode;
    }
    public String getLacCode(){
        return this.lacCode;
    }
    public void setLacName(String lacName){
        this.lacName = lacName;
    }
    public String getLacName(){
        return this.lacName;
    }
    public void setLacAsm(String lacAsm){
        this.lacAsm = lacAsm;
    }
    public String getLacAsm(){
        return this.lacAsm;
    }
    public void setLoksabha(String loksabha){
        this.loksabha = loksabha;
    }
    public String getLoksabha(){
        return this.loksabha;
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
    public void setDistrict(District district){
        this.district = district;
    }
    public District getDistrict(){
        return this.district;
    }
}
