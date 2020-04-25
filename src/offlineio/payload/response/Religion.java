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
public class Religion {
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String religionCode;

    private String religionName;

    private String religionAsm;

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
    public void setReligionCode(String religionCode){
        this.religionCode = religionCode;
    }
    public String getReligionCode(){
        return this.religionCode;
    }
    public void setReligionName(String religionName){
        this.religionName = religionName;
    }
    public String getReligionName(){
        return this.religionName;
    }
    public void setReligionAsm(String religionAsm){
        this.religionAsm = religionAsm;
    }
    public String getReligionAsm(){
        return this.religionAsm;
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
