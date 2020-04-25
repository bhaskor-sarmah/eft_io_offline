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
public class Thana
{
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String thanaCode;

    private District district;

    private String thanaName;

    private String thanaAsm;

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
    public void setThanaCode(String thanaCode){
        this.thanaCode = thanaCode;
    }
    public String getThanaCode(){
        return this.thanaCode;
    }
    public void setDistrict(District district){
        this.district = district;
    }
    public District getDistrict(){
        return this.district;
    }
    public void setThanaName(String thanaName){
        this.thanaName = thanaName;
    }
    public String getThanaName(){
        return this.thanaName;
    }
    public void setThanaAsm(String thanaAsm){
        this.thanaAsm = thanaAsm;
    }
    public String getThanaAsm(){
        return this.thanaAsm;
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