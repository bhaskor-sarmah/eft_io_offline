package  offlineio.models;

public class MaritalStatus {
    public static final String MASTER_MARITAL_STATUS_TABLE = "master_marital_status";

    public static final String COLUMN_MARITAL_STATUS_CODE = "marital_status_code";
    public static final String COLUMN_MARITAL_STATUS_NAME_EN = "marital_status_name";
    public static final String COLUMN_MARITAL_STATUS_IS_ACTIVE= "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String marital_status_code;
    private String marital_status_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_MARITAL_STATUS=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_MARITAL_STATUS_TABLE + "("
                    + COLUMN_MARITAL_STATUS_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_MARITAL_STATUS_NAME_EN + " TEXT,"
                    + COLUMN_MARITAL_STATUS_IS_ACTIVE + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public MaritalStatus(String marital_status_code, String marital_status_name, String is_active, String version) {
        this.marital_status_code = marital_status_code;
        this.marital_status_name = marital_status_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getMarital_status_code() {
        return marital_status_code;
    }

    public void setMarital_status_code(String marital_status_code) {
        this.marital_status_code = marital_status_code;
    }

    public String getMarital_status_name() {
        return marital_status_name;
    }

    public void setMarital_status_name(String marital_status_name) {
        this.marital_status_name = marital_status_name;
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
