package  offlineio.models;

public class State {
    public static final String MASTER_STATE_TABLE = "master_state";

    public static final String COLUMN_STATE_CODE = "state_code";
    public static final String COLUMN_FK_COUNTRY_CODE = "fk_country_code";
    public static final String COLUMN_STATE_NAME_EN = "state_name";
    public static final String COLUMN_STATE_NAME_AS = "state_asm";
    public static final String COLUMN_STATE_STATUS = "state_status";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String state_code;
    private String fk_country_code;
    private String state_name;
    private String state_asm;
    private String is_active;


    public static final String CREATE_TABLE_MASTER_STATE=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_STATE_TABLE + "("
                    + COLUMN_STATE_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_FK_COUNTRY_CODE + " TEXT,"
                    + COLUMN_STATE_NAME_EN + " TEXT,"
                    + COLUMN_STATE_NAME_AS + " TEXT,"
                    + COLUMN_STATE_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public State(String state_code, String fk_country_code, String state_name, String state_asm, String is_active, String version) {
        this.state_code = state_code;
        this.fk_country_code = fk_country_code;
        this.state_name = state_name;
        this.state_asm = state_asm;
        this.is_active = is_active;
        this.version = version;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getFk_country_code() {
        return fk_country_code;
    }

    public void setFk_country_code(String fk_country_code) {
        this.fk_country_code = fk_country_code;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_asm() {
        return state_asm;
    }

    public void setState_asm(String state_asm) {
        this.state_asm = state_asm;
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
