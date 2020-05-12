package  offlineio.models;

public class MasterTableStatus {

    public static final String MASTER_TABLE_STATUS = "master_table_status";

    public static final String COLUMN_TABLE_NAME = "table_name";
    public static final String COLUMN_NICK_NAME = "table_alias_name";
    public static final String COLUMN_OFFLINE_VERSION = "offline_version";
    public static final String COLUMN_ONLINE_VERSION = "online_version";
    public static final String COLUMN_UPDATED_TIME = "updated_time";

    private String table_name;
    private String nic_name;
    private String offline_version;
    private String online_version;
    private String updated_time;

    public static final String CREATE_MASTER_TABLE_STATUS=
            "CREATE TABLE  IF NOT EXISTS " + MASTER_TABLE_STATUS + "("
                    + COLUMN_NICK_NAME  + " TEXT PRIMARY KEY ,"
                    + COLUMN_TABLE_NAME + " TEXT,"
                    + COLUMN_OFFLINE_VERSION + " TEXT, "
                    + COLUMN_ONLINE_VERSION + " TEXT ,"
                    + COLUMN_UPDATED_TIME + " TEXT "
                    + ")";

    public MasterTableStatus(String nic_name,String table_name,String offline_version, String online_version, String updated_time) {
        this.table_name = table_name;
        this.nic_name = nic_name;
        this.offline_version = offline_version;
        this.online_version = online_version;
        this.updated_time = updated_time;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getNic_name() {
        return nic_name;
    }

    public void setNic_name(String nic_name) {
        this.nic_name = nic_name;
    }

    public String getOffline_version() {
        return offline_version;
    }

    public void setOffline_version(String offline_version) {
        this.offline_version = offline_version;
    }

    public String getOnline_version() {
        return online_version;
    }

    public void setOnline_version(String online_version) {
        this.online_version = online_version;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }
}
