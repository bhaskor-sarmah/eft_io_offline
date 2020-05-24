/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.models;

import java.io.File;

/**
 *
 * @author Bhaskor
 */
public class SuspectDocument {

    public String doc_id;
    public String created_at;
    public String created_by;
    public String updated_at;
    public String updated_by;
    public String comm_id;
    public String doc_details;
    public String doc_path;
    public String other_document;
    public String fk_current_status_code;
    public String fk_doc_code;
    public String fk_suspect_id;
    public String fk_suspect_district_code;
    public String fk_suspect_ft_code;
    public String fk_suspect_state_code;
    public String fk_suspect_thana_code;
    public String is_ready_for_sync;
    public String sync_status;
    public String online_id;
    public String parent_sync;
    public File doc;

    public SuspectDocument() {
    }

    public SuspectDocument(String doc_id, String created_at, String created_by, String updated_at, String updated_by, String comm_id, String doc_details, String doc_path, String other_document, String fk_current_status_code, String fk_doc_code, String fk_suspect_id, String fk_suspect_district_code, String fk_suspect_ft_code, String fk_suspect_state_code, String fk_suspect_thana_code, String is_ready_for_sync, String sync_status, String online_id, String parent_sync) {
        this.doc_id = doc_id;
        this.created_at = created_at;
        this.created_by = created_by;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.comm_id = comm_id;
        this.doc_details = doc_details;
        this.doc_path = doc_path;
        this.other_document = other_document;
        this.fk_current_status_code = fk_current_status_code;
        this.fk_doc_code = fk_doc_code;
        this.fk_suspect_id = fk_suspect_id;
        this.fk_suspect_district_code = fk_suspect_district_code;
        this.fk_suspect_ft_code = fk_suspect_ft_code;
        this.fk_suspect_state_code = fk_suspect_state_code;
        this.fk_suspect_thana_code = fk_suspect_thana_code;
        this.is_ready_for_sync = is_ready_for_sync;
        this.sync_status = sync_status;
        this.online_id = online_id;
        this.parent_sync = parent_sync;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getComm_id() {
        return comm_id;
    }

    public void setComm_id(String comm_id) {
        this.comm_id = comm_id;
    }

    public String getDoc_details() {
        return doc_details;
    }

    public void setDoc_details(String doc_details) {
        this.doc_details = doc_details;
    }

    public String getDoc_path() {
        return doc_path;
    }

    public void setDoc_path(String doc_path) {
        this.doc_path = doc_path;
    }

    public String getOther_document() {
        return other_document;
    }

    public void setOther_document(String other_document) {
        this.other_document = other_document;
    }

    public String getFk_current_status_code() {
        return fk_current_status_code;
    }

    public void setFk_current_status_code(String fk_current_status_code) {
        this.fk_current_status_code = fk_current_status_code;
    }

    public String getFk_doc_code() {
        return fk_doc_code;
    }

    public void setFk_doc_code(String fk_doc_code) {
        this.fk_doc_code = fk_doc_code;
    }

    public String getFk_suspect_id() {
        return fk_suspect_id;
    }

    public void setFk_suspect_id(String fk_suspect_id) {
        this.fk_suspect_id = fk_suspect_id;
    }

    public String getFk_suspect_district_code() {
        return fk_suspect_district_code;
    }

    public void setFk_suspect_district_code(String fk_suspect_district_code) {
        this.fk_suspect_district_code = fk_suspect_district_code;
    }

    public String getFk_suspect_ft_code() {
        return fk_suspect_ft_code;
    }

    public void setFk_suspect_ft_code(String fk_suspect_ft_code) {
        this.fk_suspect_ft_code = fk_suspect_ft_code;
    }

    public String getFk_suspect_state_code() {
        return fk_suspect_state_code;
    }

    public void setFk_suspect_state_code(String fk_suspect_state_code) {
        this.fk_suspect_state_code = fk_suspect_state_code;
    }

    public String getFk_suspect_thana_code() {
        return fk_suspect_thana_code;
    }

    public void setFk_suspect_thana_code(String fk_suspect_thana_code) {
        this.fk_suspect_thana_code = fk_suspect_thana_code;
    }

    public String getIs_ready_for_sync() {
        return is_ready_for_sync;
    }

    public void setIs_ready_for_sync(String is_ready_for_sync) {
        this.is_ready_for_sync = is_ready_for_sync;
    }

    public String getSync_status() {
        return sync_status;
    }

    public void setSync_status(String sync_status) {
        this.sync_status = sync_status;
    }

    public String getOnline_id() {
        return online_id;
    }

    public void setOnline_id(String online_id) {
        this.online_id = online_id;
    }

    public String getParent_sync() {
        return parent_sync;
    }

    public void setParent_sync(String parent_sync) {
        this.parent_sync = parent_sync;
    }

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }

    
}
