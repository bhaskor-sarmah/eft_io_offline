package  offlineio.models;

public class EmploymentType {
    public static final String MASTER_EMPLOYMENT_TYPE_TABLE = "master_employment_type";

    public static final String COLUMN_EMPLOYMENT_TYPE_CODE = "employment_type_code";
    public static final String COLUMN_EMPLOYMENT_TYPE_NAME_EN = "employment_type_name";
    public static final String COLUMN_EMPLOYMENT_TYPE_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String employment_type_code;
    private String employment_type_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_EMPLOYMENT_TYPE=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_EMPLOYMENT_TYPE_TABLE + "("
                    + COLUMN_EMPLOYMENT_TYPE_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_EMPLOYMENT_TYPE_NAME_EN + " TEXT,"
                    + COLUMN_EMPLOYMENT_TYPE_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public EmploymentType(String employment_type_code, String employment_type_name, String is_active, String version) {
        this.employment_type_code = employment_type_code;
        this.employment_type_name = employment_type_name;
        this.is_active = is_active;
        this.version = version;
    }

    public static String getMasterEmploymentTypeTable() {
        return MASTER_EMPLOYMENT_TYPE_TABLE;
    }

    public String getEmployment_type_code() {
        return employment_type_code;
    }

    public void setEmployment_type_code(String employment_type_code) {
        this.employment_type_code = employment_type_code;
    }

    public String getEmployment_type_name() {
        return employment_type_name;
    }

    public void setEmployment_type_name(String employment_type_name) {
        this.employment_type_name = employment_type_name;
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


