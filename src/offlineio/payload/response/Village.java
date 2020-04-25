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
public class Village
{
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String villageCode;

    private Thana thana;

    private String districtCode;

    private String villageName;

    private String villageAsm;

    private String typeOfVillage;

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
    public void setVillageCode(String villageCode){
        this.villageCode = villageCode;
    }
    public String getVillageCode(){
        return this.villageCode;
    }
    public void setThana(Thana thana){
        this.thana = thana;
    }
    public Thana getThana(){
        return this.thana;
    }
    public void setDistrictCode(String districtCode){
        this.districtCode = districtCode;
    }
    public String getDistrictCode(){
        return this.districtCode;
    }
    public void setVillageName(String villageName){
        this.villageName = villageName;
    }
    public String getVillageName(){
        return this.villageName;
    }
    public void setVillageAsm(String villageAsm){
        this.villageAsm = villageAsm;
    }
    public String getVillageAsm(){
        return this.villageAsm;
    }
    public void setTypeOfVillage(String typeOfVillage){
        this.typeOfVillage = typeOfVillage;
    }
    public String getTypeOfVillage(){
        return this.typeOfVillage;
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
