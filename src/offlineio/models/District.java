package  offlineio.models;

public class District {
    public static final String MASTER_DISTRICT_TABLE = "master_district";


    public static final String COLUMN_DISTRICT_CODE = "district_code";
    public static final String COLUMN_FK_STATE_CODE = "fk_state_code";
    public static final String COLUMN_DISTRICT_NAME_EN = "district_name";
    public static final String COLUMN_DISTRICT_NAME_AS = "district_asm";
    public static final String COLUMN_DISTRICT_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String district_code;
    private String fk_state_code;
    private String district_name;
    private String district_asm;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_DISTRICT=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_DISTRICT_TABLE + "("
                    + COLUMN_DISTRICT_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_FK_STATE_CODE + " TEXT,"
                    + COLUMN_DISTRICT_NAME_EN + " TEXT,"
                    + COLUMN_DISTRICT_NAME_AS + " TEXT,"
                    + COLUMN_DISTRICT_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public District(String district_code, String fk_state_code, String district_name, String district_asm, String is_active, String version) {
        this.district_code = district_code;
        this.fk_state_code = fk_state_code;
        this.district_name = district_name;
        this.district_asm = district_asm;
        this.is_active = is_active;
        this.version = version;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getFk_state_code() {
        return fk_state_code;
    }

    public void setFk_state_code(String fk_state_code) {
        this.fk_state_code = fk_state_code;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getDistrict_asm() {
        return district_asm;
    }

    public void setDistrict_asm(String district_asm) {
        this.district_asm = district_asm;
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
