package  offlineio.models;

public class Thana {
    public static final String MASTER_THANA_TABLE = "master_thana";


    public static final String COLUMN_THANA_CODE = "thana_code";
    public static final String COLUMN_FK_DISTRICT_CODE = "fk_district_code";
    public static final String COLUMN_THANA_NAME_EN = "thana_name";
    public static final String COLUMN_THANA_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String thana_code;
    private String fk_district_code;
    private String thana_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_THANA=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_THANA_TABLE + "("
                    + COLUMN_THANA_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_FK_DISTRICT_CODE + " TEXT,"
                    + COLUMN_THANA_NAME_EN + " TEXT,"
                    + COLUMN_THANA_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public Thana(String thana_code, String fk_district_code, String thana_name, String is_active, String version) {
        this.thana_code = thana_code;
        this.fk_district_code = fk_district_code;
        this.thana_name = thana_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getThana_code() {
        return thana_code;
    }

    public void setThana_code(String thana_code) {
        this.thana_code = thana_code;
    }

    public String getFk_state_code() {
        return fk_district_code;
    }

    public void setFk_state_code(String fk_district_code) {
        this.fk_district_code = fk_district_code;
    }

    public String getThana_name() {
        return thana_name;
    }

    public void setThana_name(String thana_name) {
        this.thana_name = thana_name;
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
