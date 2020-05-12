package  offlineio.models;

public class ImmigrationRoute {
    public static final String MASTER_IMMIGRATION_ROUTE_TABLE = "master_immigration_route";

    public static final String COLUMN_IMMIGRATION_ROUTE_CODE = "route_code";
    public static final String COLUMN_IMMIGRATION_ROUTE_NAME_EN = "route_name";
    public static final String COLUMN_IMMIGRATION_ROUTE_IS_ACTIVE= "is_active";
    public static final String COLUMN_VERSION = "version";
    private String version;

    private String route_code;
    private String route_name;
    private String is_active;





    public static final String CREATE_TABLE_MASTER_IMMIGRATION_ROUTE=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_IMMIGRATION_ROUTE_TABLE + "("
                    + COLUMN_IMMIGRATION_ROUTE_CODE + " TEXT PRIMARY KEY ,"
                    + COLUMN_IMMIGRATION_ROUTE_NAME_EN + " TEXT,"
                    + COLUMN_IMMIGRATION_ROUTE_IS_ACTIVE + " TEXT, "
                    + COLUMN_VERSION + " TEXT "
                    + ")";

    public ImmigrationRoute(String route_code, String route_name, String is_active, String version) {
        this.route_code = route_code;
        this.route_name = route_name;
        this.is_active = is_active;
        this.version = version;
    }

    public String getRoute_code() {
        return route_code;
    }

    public void setRoute_code(String route_code) {
        this.route_code = route_code;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
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
