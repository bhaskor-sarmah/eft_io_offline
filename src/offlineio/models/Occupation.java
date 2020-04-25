package  offlineio.models;

public class Occupation {
    public static final String MASTER_OCCUPATION_TABLE = "master_occupation";

    public static final String COLUMN_OCCUPATION_CODE = "occupation_code";
    public static final String COLUMN_OCCUPATION_NAME_EN = "occupation_name";
    public static final String COLUMN_OCCUPATION_IS_ACTIVE= "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String occupation_code;
    private String occupation_name;
    private String is_active;



    public static final String CREATE_TABLE_MASTER_OCCUPATION=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_OCCUPATION_TABLE + "("
                    + COLUMN_OCCUPATION_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_OCCUPATION_NAME_EN + " TEXT,"
                    + COLUMN_OCCUPATION_IS_ACTIVE + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public Occupation(String occupation_code, String occupation_name, String is_active, String version) {
        this.occupation_code = occupation_code;
        this.occupation_name = occupation_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getOccupation_code() {
        return occupation_code;
    }

    public void setOccupation_code(String occupation_code) {
        this.occupation_code = occupation_code;
    }

    public String getOccupation_name() {
        return occupation_name;
    }

    public void setOccupation_name(String occupation_name) {
        this.occupation_name = occupation_name;
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
