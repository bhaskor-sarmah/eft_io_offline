package  offlineio.models;

public class FamilyRelations {

    public static final String MASTER_RELATION_TABLE = "master_relation";

    public static final String COLUMN_RELATION_CODE = "relation_code";
    public static final String COLUMN_RELATION_NAME_EN = "relation_name";
    public static final String COLUMN_RELATION_STATUS = "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String relation_code;
    private String relation_name;
    private String is_active;

    public static final String CREATE_TABLE_MASTER_FAMILY_RELATION=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_RELATION_TABLE + "("
                    + COLUMN_RELATION_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_RELATION_NAME_EN + " TEXT,"
                    + COLUMN_RELATION_STATUS + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public FamilyRelations(String relation_code, String relation_name, String is_active, String version) {
        this.relation_code = relation_code;
        this.relation_name = relation_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getRelation_code() {
        return relation_code;
    }

    public void setRelation_code(String relation_code) {
        this.relation_code = relation_code;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
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
