package  offlineio.models;

public class Village {
    public static final String MASTER_VILLAGE_TABLE = "master_village";


    public static final String COLUMN_VILLAGE_CODE = "village_code";
    public static final String COLUMN_FK_THANA_CODE = "fk_thana_code";
    public static final String COLUMN_VILLAGE_NAME_EN = "village_name";
    public static final String COLUMN_VILLAGE_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String village_code;
    private String fk_thana_code;
    private String village_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_VILLAGE=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_VILLAGE_TABLE + "("
                    + COLUMN_VILLAGE_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_FK_THANA_CODE + " TEXT,"
                    + COLUMN_VILLAGE_NAME_EN + " TEXT,"
                    + COLUMN_VILLAGE_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public Village(String village_code, String fk_thana_code, String village_name, String is_active, String version) {
        this.village_code = village_code;
        this.fk_thana_code = fk_thana_code;
        this.village_name = village_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getVillage_code() {
        return village_code;
    }

    public void setVillage_code(String village_code) {
        this.village_code = village_code;
    }

    public String getFk_state_code() {
        return fk_thana_code;
    }

    public void setFk_state_code(String fk_thana_code) {
        this.fk_thana_code = fk_thana_code;
    }

    public String getVillage_name() {
        return village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
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
