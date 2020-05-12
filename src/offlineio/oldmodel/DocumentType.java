package  offlineio.models;

public class DocumentType {
    public static final String MASTER_DOCUMENT_TYPE_TABLE = "master_doc_type";

    public static final String COLUMN_DOCUMENT_TYPE_CODE = "doc_type_code";
    public static final String COLUMN_DOCUMENT_TYPE_NAME_EN = "doc_type_name";
    public static final String COLUMN_DOCUMENT_TYPE_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String doc_type_code;
    private String doc_type_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_DOCUMENT_TYPE=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_DOCUMENT_TYPE_TABLE + "("
                    + COLUMN_DOCUMENT_TYPE_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_DOCUMENT_TYPE_NAME_EN + " TEXT,"
                    + COLUMN_DOCUMENT_TYPE_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public DocumentType(String doc_type_code, String doc_type_name, String is_active, String version) {
        this.doc_type_code = doc_type_code;
        this.doc_type_name = doc_type_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getDoc_type_code() {
        return doc_type_code;
    }

    public void setDoc_type_code(String doc_type_code) {
        this.doc_type_code = doc_type_code;
    }

    public String getDoc_type_name() {
        return doc_type_name;
    }

    public void setDoc_type_name(String doc_type_name) {
        this.doc_type_name = doc_type_name;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
