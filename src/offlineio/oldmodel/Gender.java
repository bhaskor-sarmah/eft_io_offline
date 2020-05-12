package  offlineio.models;

public class Gender {

    public static final String MASTER_GENDER_TABLE = "master_gender";

    public static final String COLUMN_GENDER_CODE = "gender_code";
    public static final String COLUMN_GENDER_NAME_EN = "gender_name";
    public static final String COLUMN_GENDER_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String gender_code;
    private String gender_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_GENDER=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_GENDER_TABLE + "("
                    + COLUMN_GENDER_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_GENDER_NAME_EN + " TEXT,"
                    + COLUMN_GENDER_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public Gender(String gender_code, String gender_name, String is_active, String version) {
        this.gender_code = gender_code;
        this.gender_name = gender_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getGender_code() {
        return gender_code;
    }

    public void setGender_code(String gender_code) {
        this.gender_code = gender_code;
    }

    public String getGender_name() {
        return gender_name;
    }

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
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
