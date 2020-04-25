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
public class Document {
    private String createdBy;

    private String createdAt;

    private String updatedBy;

    private String updatedAt;

    private String docCode;

    private String docName;

    private String docAsm;

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
    public void setDocCode(String docCode){
        this.docCode = docCode;
    }
    public String getDocCode(){
        return this.docCode;
    }
    public void setDocName(String docName){
        this.docName = docName;
    }
    public String getDocName(){
        return this.docName;
    }
    public void setDocAsm(String docAsm){
        this.docAsm = docAsm;
    }
    public String getDocAsm(){
        return this.docAsm;
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
