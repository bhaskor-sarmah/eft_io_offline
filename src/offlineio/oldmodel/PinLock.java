package  offlineio.models;

public class PinLock {
    public static final String PIN_LOCK_TABLE = "pin_master";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_PIN_CODE = "pin_code";
    public static final String COLUMN_PS_CODE = "ps_code";
    public static final String COLUMN_MOBILE = "user_mobile";
    public static final String COLUMN_EMAIL = "user_email";
    public static final String COLUMN_PIN_STATUS = "pin_status";

    public static final String COLUMN_VERSION = "version";
    private String version;

    private String id;
    private String user_name;
    private String pin_code;
    private String ps_code;
    private String user_mobile;
    private String user_email;
    private String pin_status;

    // Create table SQL query
    public static final String CREATE_TABLE_PIN_LOCK =
            "CREATE TABLE " + PIN_LOCK_TABLE + "("
                    + COLUMN_ID + " TEXT PRIMARY KEY ,"
                    + COLUMN_USER_NAME + " TEXT,"
                    + COLUMN_PIN_CODE + " TEXT UNIQUE,"
                    + COLUMN_PS_CODE + " TEXT,"
                    + COLUMN_MOBILE + " TEXT,"
                    + COLUMN_EMAIL + " TEXT,"
                    + COLUMN_PIN_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public PinLock() {
    }

    public PinLock(String id,String user_name, String pin_code, String ps_code,
                   String user_mobile, String user_email,String pin_status, String version) {
        this.id = id;
        this.user_name = user_name;
        this.pin_code = pin_code;
        this.ps_code = ps_code;
        this.user_mobile = user_mobile;
        this.user_email = user_email;
        this.pin_status = pin_status;
        this.version = version;
    }
    public PinLock(String id,String user_name, String pin_code, String ps_code,String user_mobile, String user_email, String pin_status) {
        this.id = id;
        this.user_name = user_name;
        this.pin_code = pin_code;
        this.ps_code = ps_code;
        this.user_email = user_email;
        this.user_mobile = user_mobile;
        this.pin_status = pin_status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPs_code() {
        return ps_code;
    }

    public void setPs_code(String ps_code) {
        this.ps_code = ps_code;
    }

    public String getPin_status() {
        return pin_status;
    }

    public void setPin_status(String pin_status) {
        this.pin_status = pin_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
