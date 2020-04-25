package  offlineio.models;

public class SuspectDoc {
    public static final String SUSPECT_DOCUMENT_TABLE = "suspect_doc";

    public static final String COLUMN_DOC_ID="doc_id";
    public static final String COLUMN_CREATED_AT="created_at";
    public static final String COLUMN_CREATED_BY="created_by";
    public static final String COLUMN_UPDATED_AT="updated_at";
    public static final String COLUMN_UPDATED_BY="updated_by";
    public static final String COLUMN_COMM_ID="comm_id";
    public static final String COLUMN_DOC_DETAILS="doc_details";
    public static final String COLUMN_DOC_PATH="doc_path";
    public static final String COLUMN_OTHER_DOCUMENT="other_document";
    public static final String COLUMN_FK_CURRENT_STATUS_CODE="fk_current_status_code";
    public static final String COLUMN_FK_DOC_CODE="fk_doc_code";
    public static final String COLUMN_FK_SUSPECT_ID="fk_suspect_id";
    public static final String COLUMN_FK_SUSPECT_DISTRICT_CODE="fk_suspect_district_code";
    public static final String COLUMN_FK_SUSPECT_FT_CODE="fk_suspect_ft_code";
    public static final String COLUMN_FK_SUSPECT_STATE_CODE="fk_suspect_state_code";
    public static final String COLUMN_FK_SUSPECT_THANA_CODE="fk_suspect_thana_code";
    public static final String COLUMN_IS_READY_FOR_SYNC = "is_ready_for_sync";
    public static final String COLUMN_SYNC_STATUS = "sync_status";
    public static final String COLUMN_ONLINE_ID = "online_id";
    public static final String COLUMN_PARENT_SYNC = "parent_sync";


    public String  doc_id;
    public String  created_at;
    public String  created_by;
    public String  updated_at;
    public String  updated_by;
    public String  comm_id;
    public String  doc_details;
    public String  doc_path;
    public String  other_document;
    public String  fk_current_status_code;
    public String  fk_doc_code;
    public String  fk_suspect_id;
    public String  fk_suspect_district_code;
    public String  fk_suspect_ft_code;
    public String  fk_suspect_state_code;
    public String  fk_suspect_thana_code;
    public String is_ready_for_sync;
    public String sync_status;
    public String online_id;
    public String parent_sync;


    public boolean isTemp=false;

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

    public static final String CREATE_TABLE_SUSPECT_DOCUMENT_TABLE=
            "CREATE TABLE  IF NOT EXISTS " + SUSPECT_DOCUMENT_TABLE + "( "
                    + COLUMN_DOC_ID + "  TEXT PRIMARY KEY,"
                    + COLUMN_CREATED_AT +"   TEXT, "
                    + COLUMN_CREATED_BY +"   TEXT, "
                    + COLUMN_UPDATED_AT +"   TEXT, "
                    + COLUMN_UPDATED_BY +"   TEXT, "
                    + COLUMN_COMM_ID +"   TEXT, "
                    + COLUMN_DOC_DETAILS +"   TEXT, "
                    + COLUMN_DOC_PATH +"   TEXT, "
                    + COLUMN_OTHER_DOCUMENT +"   TEXT, "
                    + COLUMN_FK_CURRENT_STATUS_CODE +"   TEXT, "
                    + COLUMN_FK_DOC_CODE +"   TEXT, "
                    + COLUMN_FK_SUSPECT_ID +"   TEXT, "
                    + COLUMN_FK_SUSPECT_DISTRICT_CODE +"   TEXT, "
                    + COLUMN_FK_SUSPECT_FT_CODE +"   TEXT, "
                    + COLUMN_FK_SUSPECT_STATE_CODE +"   TEXT, "
                    + COLUMN_FK_SUSPECT_THANA_CODE +"   TEXT, "

                    +  COLUMN_IS_READY_FOR_SYNC +  "  TEXT,  "
                    +  COLUMN_SYNC_STATUS +  "  TEXT,  "

                    +  COLUMN_ONLINE_ID +  "  TEXT,  "
                    +  COLUMN_PARENT_SYNC +  "  TEXT  "

                    + ")";
    public SuspectDoc(){

    }

    public boolean isTemp() {
        return isTemp;
    }

    public void setTemp(boolean temp) {
        isTemp = temp;
    }

    public SuspectDoc(String doc_id, String created_at, String created_by, String updated_at, String updated_by, String comm_id, String doc_details, String doc_path, String other_document, String fk_current_status_code, String fk_doc_code, String fk_suspect_id, String fk_suspect_district_code, String fk_suspect_ft_code, String fk_suspect_state_code, String fk_suspect_thana_code, String is_ready_for_sync, String sync_status) {
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
    }

    public SuspectDoc(String doc_id, String created_at, String created_by, String updated_at, String updated_by, String comm_id, String doc_details, String doc_path, String other_document, String fk_current_status_code, String fk_doc_code, String fk_suspect_id, String fk_suspect_district_code, String fk_suspect_ft_code, String fk_suspect_state_code, String fk_suspect_thana_code, String is_ready_for_sync, String sync_status, String onlineid) {
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
        this.online_id = onlineid;

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
}
