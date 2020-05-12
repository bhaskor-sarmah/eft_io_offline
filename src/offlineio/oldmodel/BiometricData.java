package offlineio.models;

public class BiometricData {

    public static final String BIOMETRIC_DATA_TABLE = "biometric_data";

    public static final String COLUMN_FK_SUSPECT_ID="fk_suspect_id";
    public static final String COLUMN_LEFT_THUMB_IMG="left_thumb_img";
    public static final String COLUMN_LEFT_INDEX_IMG="left_index_img";
    public static final String COLUMN_LEFT_MIDDLE_IMG="left_middle_img";
    public static final String COLUMN_LEFT_RING_IMG="left_ring_img";
    public static final String COLUMN_LEFT_LITTLE_IMG="left_little_img";
    public static final String COLUMN_RIGHT_THUMB_IMG="right_thumb_img";
    public static final String COLUMN_RIGHT_INDEX_IMG="right_index_img";
    public static final String COLUMN_RIGHT_MIDDLE_IMG="right_middle_img";
    public static final String COLUMN_RIGHT_RING_IMG="right_ring_img";
    public static final String COLUMN_RIGHT_LITTLE_IMG="right_little_img";

    public static final String COLUMN_LEFT_IRISH="left_irish";
    public static final String COLUMN_RIGHT_IRICH="right_irich";

    public static final String COLUMN_LEFT_THUMB_IMG_BYTE="left_thumb_img_byte";
    public static final String COLUMN_LEFT_INDEX_IMG_BYTE="left_index_img_byte";
    public static final String COLUMN_LEFT_MIDDLE_IMG_BYTE="left_middle_img_byte";
    public static final String COLUMN_LEFT_RING_IMG_BYTE="left_ring_img_byte";
    public static final String COLUMN_LEFT_LITTLE_IMG_BYTE="left_little_img_byte";
    public static final String COLUMN_RIGHT_THUMB_IMG_BYTE="right_thumb_img_byte";
    public static final String COLUMN_RIGHT_INDEX_IMG_BYTE="right_index_img_byte";
    public static final String COLUMN_RIGHT_MIDDLE_IMG_BYTE="right_middle_img_byte";
    public static final String COLUMN_RIGHT_RING_IMG_BYTE="right_ring_img_byte";
    public static final String COLUMN_RIGHT_LITTLE_IMG_BYTE="right_little_img_byte";


    public static final String COLUMN_LEFT_IRISH_RAW="left_irish_raw";
    public static final String COLUMN_RIGHT_IRICH_RAW="right_irich_raw";

    public static final String COLUMN_LEFT_IRISH_RAW_FILE="left_irish_raw_file";
    public static final String COLUMN_RIGHT_IRICH_RAW_FILE="right_irich_raw_file";

    public static  final  String  COLUMN_CAPTURED_AT  ="captured_at";
    public static  final  String  COLUMN_CAPTURED_BY  ="captured_by";
    public static final String COLUMN_IS_READY_FOR_SYNC="is_ready_for_sync";
    public static final String COLUMN_SYNC_STATUS="sync_status";

    public static final String COLUMN_ONLINE_ID = "online_id";
    public static final String COLUMN_PARENT_SYNC = "parent_sync";


    public static final String COLUMN_HAS_IRISH = "has_irish";
    public static final String COLUMN_HAS_FINGER = "has_finger";


    public static final String CREATE_BIOMETRIC_DATA_TABLE=
            "CREATE TABLE  IF NOT EXISTS " + BIOMETRIC_DATA_TABLE + "("
                    + COLUMN_FK_SUSPECT_ID +"  TEXT PRIMARY KEY,"
                    + COLUMN_LEFT_THUMB_IMG +"  TEXT  ,"
                    + COLUMN_LEFT_INDEX_IMG +"  TEXT  ,"
                    + COLUMN_LEFT_MIDDLE_IMG +"  TEXT  ,"
                    + COLUMN_LEFT_RING_IMG +"  TEXT  ,"
                    + COLUMN_LEFT_LITTLE_IMG +"  TEXT  ,"
                    + COLUMN_RIGHT_THUMB_IMG +"  TEXT  ,"
                    + COLUMN_RIGHT_INDEX_IMG +"  TEXT  ,"
                    + COLUMN_RIGHT_MIDDLE_IMG +"  TEXT  ,"
                    + COLUMN_RIGHT_RING_IMG +"  TEXT  ,"
                    + COLUMN_RIGHT_LITTLE_IMG +"  TEXT  ,"
                    + COLUMN_LEFT_IRISH +"  TEXT  ,"
                    + COLUMN_RIGHT_IRICH +"  TEXT  ,"

                    + COLUMN_LEFT_THUMB_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_LEFT_INDEX_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_LEFT_MIDDLE_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_LEFT_RING_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_LEFT_LITTLE_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_RIGHT_THUMB_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_RIGHT_INDEX_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_RIGHT_MIDDLE_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_RIGHT_RING_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_RIGHT_LITTLE_IMG_BYTE +"  BLOB  ,"
                    + COLUMN_LEFT_IRISH_RAW +"  BLOB  ,"
                    + COLUMN_RIGHT_IRICH_RAW +"  BLOB  ,"





                    + COLUMN_LEFT_IRISH_RAW_FILE +"  TEXT  ,"
                    + COLUMN_RIGHT_IRICH_RAW_FILE +"  TEXT  ,"

                    + COLUMN_CAPTURED_AT +"  TEXT  ,"
                    + COLUMN_CAPTURED_BY +"  TEXT  ,"
                    + COLUMN_IS_READY_FOR_SYNC +"  TEXT  ,"
                    + COLUMN_SYNC_STATUS +"  TEXT , "
                    + COLUMN_ONLINE_ID +"  TEXT  ,"
                    + COLUMN_PARENT_SYNC +"  TEXT,  "

                    + COLUMN_HAS_IRISH +"  TEXT  ,"
                    + COLUMN_HAS_FINGER +"  TEXT  "

                    + ")";


    public   String  fk_suspect_id;
    public   String  left_thumb_img;
    public   String  left_index_img;
    public   String  left_middle_img;
    public   String  left_ring_img;
    public   String  left_little_img;
    public   String  right_thumb_img;
    public   String  right_index_img;
    public   String  right_middle_img;
    public   String  right_ring_img;
    public   String  right_little_img;
    public   String  left_irish;
    public   String  right_irich;


    public   byte[]   left_thumb_img_byte;
    public   byte[]   left_index_img_byte;
    public   byte[]   left_middle_img_byte;
    public   byte[]   left_ring_img_byte;
    public   byte[]   left_little_img_byte;
    public   byte[]   right_thumb_img_byte;
    public   byte[]   right_index_img_byte;
    public   byte[]   right_middle_img_byte;
    public   byte[]   right_ring_img_byte;
    public   byte[]   right_little_img_byte;
    public   byte[]    left_iris_raw;
    public   byte[]    right_iris_raw;



    public   String  left_iris_raw_file;
    public   String  right_iris_raw_file;


    public   String  captured_at;
    public   String  captured_by;

    public   String  is_ready_for_sync;
    public   String  sync_status;

    public String online_id;
    public String parent_sync;

    public String has_irish;
    public String has_finger;



    public BiometricData(String fk_suspect_id, String left_thumb_img, String left_index_img, String left_middle_img, String left_ring_img, String left_little_img, String right_thumb_img, String right_index_img, String right_middle_img, String right_ring_img, String right_little_img, String left_irish, String right_irich,String captured_at, String captured_by, String is_ready_for_sync, String sync_status,String online_id
            , byte[] left_thumb_img_byte, byte[] left_index_img_byte, byte[] left_middle_img_byte, byte[] left_ring_img_byte, byte[] left_little_img_byte, byte[] right_thumb_img_byte, byte[] right_index_img_byte, byte[] right_middle_img_byte, byte[] right_ring_img_byte, byte[] right_little_img_byte,  byte[]  left_irish_raw,  byte[]  right_irich_raw
            ,String has_irish,String has_finger   ,String left_iris_raw_file,String right_iris_raw_file  ) {
        this.fk_suspect_id = fk_suspect_id;
        this.left_thumb_img = left_thumb_img;
        this.left_index_img = left_index_img;
        this.left_middle_img = left_middle_img;
        this.left_ring_img = left_ring_img;
        this.left_little_img = left_little_img;
        this.right_thumb_img = right_thumb_img;
        this.right_index_img = right_index_img;
        this.right_middle_img = right_middle_img;
        this.right_ring_img = right_ring_img;
        this.right_little_img = right_little_img;
        this.left_irish = left_irish;
        this.right_irich = right_irich;
        this.captured_at = captured_at;
        this.captured_by = captured_by;
        this.is_ready_for_sync = is_ready_for_sync;
        this.sync_status = sync_status;
        this.online_id = online_id;

        this.left_thumb_img_byte = left_thumb_img_byte;
        this.left_index_img_byte = left_index_img_byte;
        this.left_middle_img_byte = left_middle_img_byte;
        this.left_ring_img_byte = left_ring_img_byte;
        this.left_little_img_byte = left_little_img_byte;
        this.right_thumb_img_byte = right_thumb_img_byte;
        this.right_index_img_byte = right_index_img_byte;
        this.right_middle_img_byte = right_middle_img_byte;
        this.right_ring_img_byte = right_ring_img_byte;
        this.right_little_img_byte = right_little_img_byte;
        this.left_iris_raw = left_irish_raw;
        this.right_iris_raw = right_irich_raw;

        this.has_finger = has_finger;
        this.has_irish = has_irish;

        this.left_iris_raw_file = left_iris_raw_file;
        this.right_iris_raw_file = right_iris_raw_file;

    }

    public BiometricData(String fk_suspect_id, String left_thumb_img, String left_index_img, String left_middle_img, String left_ring_img, String left_little_img, String right_thumb_img, String right_index_img, String right_middle_img, String right_ring_img, String right_little_img, String left_irish, String right_irich,String captured_at, String captured_by, String is_ready_for_sync, String sync_status, byte[] left_thumb_img_byte, byte[] left_index_img_byte, byte[] left_middle_img_byte, byte[] left_ring_img_byte, byte[] left_little_img_byte, byte[] right_thumb_img_byte, byte[] right_index_img_byte, byte[] right_middle_img_byte, byte[] right_ring_img_byte, byte[] right_little_img_byte,  byte[]  left_irish_raw,  byte[]  right_irich_raw,String has_irish,String has_finger,String left_iris_raw_file,String right_iris_raw_file
    ) {
        this.fk_suspect_id = fk_suspect_id;
        this.left_thumb_img = left_thumb_img;
        this.left_index_img = left_index_img;
        this.left_middle_img = left_middle_img;
        this.left_ring_img = left_ring_img;
        this.left_little_img = left_little_img;
        this.right_thumb_img = right_thumb_img;
        this.right_index_img = right_index_img;
        this.right_middle_img = right_middle_img;
        this.right_ring_img = right_ring_img;
        this.right_little_img = right_little_img;
        this.left_irish = left_irish;
        this.right_irich = right_irich;
        this.left_thumb_img_byte = left_thumb_img_byte;
        this.left_index_img_byte = left_index_img_byte;
        this.left_middle_img_byte = left_middle_img_byte;
        this.left_ring_img_byte = left_ring_img_byte;
        this.left_little_img_byte = left_little_img_byte;
        this.right_thumb_img_byte = right_thumb_img_byte;
        this.right_index_img_byte = right_index_img_byte;
        this.right_middle_img_byte = right_middle_img_byte;
        this.right_ring_img_byte = right_ring_img_byte;
        this.right_little_img_byte = right_little_img_byte;
        this.left_iris_raw = left_irish_raw;
        this.right_iris_raw = right_irich_raw;
        this.captured_at = captured_at;
        this.captured_by = captured_by;
        this.is_ready_for_sync = is_ready_for_sync;
        this.sync_status = sync_status;

        this.has_finger = has_finger;
        this.has_irish = has_irish;

        this.left_iris_raw_file = left_iris_raw_file;
        this.right_iris_raw_file = right_iris_raw_file;
    }

    public String getFk_suspect_id() {
        return fk_suspect_id;
    }

    public void setFk_suspect_id(String fk_suspect_id) {
        this.fk_suspect_id = fk_suspect_id;
    }

    public String getLeft_thumb_img() {
        return left_thumb_img;
    }

    public void setLeft_thumb_img(String left_thumb_img) {
        this.left_thumb_img = left_thumb_img;
    }

    public String getLeft_index_img() {
        return left_index_img;
    }

    public void setLeft_index_img(String left_index_img) {
        this.left_index_img = left_index_img;
    }

    public String getLeft_middle_img() {
        return left_middle_img;
    }

    public void setLeft_middle_img(String left_middle_img) {
        this.left_middle_img = left_middle_img;
    }

    public String getLeft_ring_img() {
        return left_ring_img;
    }

    public void setLeft_ring_img(String left_ring_img) {
        this.left_ring_img = left_ring_img;
    }

    public String getLeft_little_img() {
        return left_little_img;
    }

    public void setLeft_little_img(String left_little_img) {
        this.left_little_img = left_little_img;
    }

    public String getRight_thumb_img() {
        return right_thumb_img;
    }

    public void setRight_thumb_img(String right_thumb_img) {
        this.right_thumb_img = right_thumb_img;
    }

    public String getRight_index_img() {
        return right_index_img;
    }

    public void setRight_index_img(String right_index_img) {
        this.right_index_img = right_index_img;
    }

    public String getRight_middle_img() {
        return right_middle_img;
    }

    public void setRight_middle_img(String right_middle_img) {
        this.right_middle_img = right_middle_img;
    }

    public String getRight_ring_img() {
        return right_ring_img;
    }

    public String getIs_ready_for_sync() {
        return is_ready_for_sync;
    }

    public void setIs_ready_for_sync(String is_ready_for_sync) {
        this.is_ready_for_sync = is_ready_for_sync;
    }

    public String getSync_status() {
        return sync_status;
    }

    public void setSync_status(String sync_status) {
        this.sync_status = sync_status;
    }

    public void setRight_ring_img(String right_ring_img) {
        this.right_ring_img = right_ring_img;
    }

    public String getRight_little_img() {
        return right_little_img;
    }

    public void setRight_little_img(String right_little_img) {
        this.right_little_img = right_little_img;
    }

    public String getLeft_irish() {
        return left_irish;
    }

    public void setLeft_irish(String left_irish) {
        this.left_irish = left_irish;
    }

    public String getRight_irich() {
        return right_irich;
    }

    public void setRight_irich(String right_irich) {
        this.right_irich = right_irich;
    }

    public String getCaptured_at() {
        return captured_at;
    }

    public void setCaptured_at(String captured_at) {
        this.captured_at = captured_at;
    }

    public String getCaptured_by() {
        return captured_by;
    }

    public void setCaptured_by(String captured_by) {
        this.captured_by = captured_by;
    }

    public String getOnline_id() {
        return online_id;
    }

    public void setOnline_id(String online_id) {
        this.online_id = online_id;
    }

    public String getParent_sync() {
        return parent_sync;
    }

    public void setParent_sync(String parent_sync) {
        this.parent_sync = parent_sync;
    }

    public byte[] getLeft_thumb_img_byte() {
        return left_thumb_img_byte;
    }

    public void setLeft_thumb_img_byte(byte[] left_thumb_img_byte) {
        this.left_thumb_img_byte = left_thumb_img_byte;
    }

    public byte[] getLeft_index_img_byte() {
        return left_index_img_byte;
    }

    public void setLeft_index_img_byte(byte[] left_index_img_byte) {
        this.left_index_img_byte = left_index_img_byte;
    }

    public byte[] getLeft_middle_img_byte() {
        return left_middle_img_byte;
    }

    public void setLeft_middle_img_byte(byte[] left_middle_img_byte) {
        this.left_middle_img_byte = left_middle_img_byte;
    }

    public byte[] getLeft_ring_img_byte() {
        return left_ring_img_byte;
    }

    public void setLeft_ring_img_byte(byte[] left_ring_img_byte) {
        this.left_ring_img_byte = left_ring_img_byte;
    }

    public byte[] getLeft_little_img_byte() {
        return left_little_img_byte;
    }

    public void setLeft_little_img_byte(byte[] left_little_img_byte) {
        this.left_little_img_byte = left_little_img_byte;
    }

    public byte[] getRight_thumb_img_byte() {
        return right_thumb_img_byte;
    }

    public void setRight_thumb_img_byte(byte[] right_thumb_img_byte) {
        this.right_thumb_img_byte = right_thumb_img_byte;
    }

    public byte[] getRight_index_img_byte() {
        return right_index_img_byte;
    }

    public void setRight_index_img_byte(byte[] right_index_img_byte) {
        this.right_index_img_byte = right_index_img_byte;
    }

    public byte[] getRight_middle_img_byte() {
        return right_middle_img_byte;
    }

    public void setRight_middle_img_byte(byte[] right_middle_img_byte) {
        this.right_middle_img_byte = right_middle_img_byte;
    }

    public byte[] getRight_ring_img_byte() {
        return right_ring_img_byte;
    }

    public void setRight_ring_img_byte(byte[] right_ring_img_byte) {
        this.right_ring_img_byte = right_ring_img_byte;
    }

    public byte[] getRight_little_img_byte() {
        return right_little_img_byte;
    }

    public void setRight_little_img_byte(byte[] right_little_img_byte) {
        this.right_little_img_byte = right_little_img_byte;
    }

    public byte[] getLeft_irish_raw() {
        return left_iris_raw;
    }

    public void setLeft_irish_raw(byte[]  left_irish_raw) {
        this.left_iris_raw= left_irish_raw;
    }

    public byte[]  getRight_irich_raw() {
        return right_iris_raw;
    }

    public void setRight_irich_raw(byte[]  right_irich_raw) {
        this.right_iris_raw = right_irich_raw;
    }

    public String getHas_irish() {
        return has_irish;
    }

    public void setHas_irish(String has_irish) {
        this.has_irish = has_irish;
    }

    public String getHas_finger() {
        return has_finger;
    }

    public void setHas_finger(String has_finger) {
        this.has_finger = has_finger;
    }

    public static String getBiometricDataTable() {
        return BIOMETRIC_DATA_TABLE;
    }

    public String getLeft_iris_raw_file() {
        return left_iris_raw_file;
    }

    public void setLeft_iris_raw_file(String left_iris_raw_file) {
        this.left_iris_raw_file = left_iris_raw_file;
    }

    public String getRight_iris_raw_file() {
        return right_iris_raw_file;
    }

    public void setRight_iris_raw_file(String right_iris_raw_file) {
        this.right_iris_raw_file = right_iris_raw_file;
    }
}
