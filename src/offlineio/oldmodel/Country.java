package  offlineio.models;

public class Country {
    public static final String MASTER_COUNTRY_TABLE = "master_country";

    public static final String COLUMN_COUNTRY_CODE = "country_code";
    public static final String COLUMN_COUNTRY_NAME_EN = "country_name";
    public static final String COLUMN_COUNTRY_NAME_AS = "country_asm";
    public static final String COLUMN_COUNTRY_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;


    private String country_code;
    private String country_name;
    private String country_asm;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_COUNTRY=
            "CREATE TABLE IF NOT EXISTS " + MASTER_COUNTRY_TABLE + "("
                    + COLUMN_COUNTRY_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_COUNTRY_NAME_EN + " TEXT,"
                    + COLUMN_COUNTRY_NAME_AS + " TEXT,"
                    + COLUMN_COUNTRY_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public Country(String country_code, String country_name, String country_asm, String is_active, String version) {
        this.country_code = country_code;
        this.country_name = country_name;
        this.country_asm = country_asm;
        this.is_active = is_active;
        this.version = version;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_asm() {
        return country_asm;
    }

    public void setCountry_asm(String country_asm) {
        this.country_asm = country_asm;
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
