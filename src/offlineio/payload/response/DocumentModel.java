/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.payload.response;

import java.io.File;

/**
 *
 * @author Bhaskor
 */
public class DocumentModel {
    private String id;
    private File file;

    public DocumentModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public DocumentModel(String id, File file) {
        this.id = id;
        this.file = file;
    }
    
    
}
