/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

/**
 *
 * @author Bhaskor
 */
public class AppSettings {

    // ========================================================================
    // # Database Connection Properties
    // ========================================================================
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/offline_io?characterEncoding=UTF-8&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final int MAX_CONNECTION = 20;

    // ========================================================================
    // # API URL DETAILS
    // ========================================================================
    public static final String BASE_URL = "http://3.6.23.223:8080/eftapi/";
    public static final String LOGIN_URL = "api/auth/signin";
    public static final String PASSCODE_URL = "api/passcode";
    public static final String MASTER_VERSION_URL = "api/masterversion";
    public static final String MASTER_DATA_URL = "api/masters";
    public static final String VILLAGE_DATA_URL = "api/villagemaster";

    // ========================================================================
    // # DEVICE SPECIFIC SETTINGS
    // ========================================================================
    public static final String DEVICE_ID = "6ecf105e666d4830";
    public static final String DEVICE_MAC = "20:39:56:6C:FC:A8";

    // ========================================================================
    // # ADDRESS TYPE CODES
    // ========================================================================
    public static final String ADDRESS_OF_DETECTION = "01";
    public static final String ADDRESS_IN_INDIA = "02";
    public static final String ADDRESS_IN_COUNTRY_ORIGIN = "03";
    public static final String ADDRESS_OF_HOUSE_OWNER = "04";
    public static final String ADDRESS_OF_EMPLOYER = "05";

    // ========================================================================
    // # OTHER COUNTRY, STATE, DISTRICT CODES
    // ========================================================================
    public static final String OTHER_THEN_LISTED_COUNTRY = "00";

    public static final String OTHER_THEN_LISTED_STATE_IN_INDIA = "99";
    public static final String OTHER_THEN_LISTED_STATE_OUTSIDE_INDIA = "00";

    public static final String OTHER_THEN_LISTED_DISTRICT_IN_INDIA = "999";
    public static final String OTHER_THEN_LISTED_DISTRICT_OUT_SIDE_INDIA = "000";

    public static final String OTHER_THEN_LISTED_THANA_IN_INDIA = "99999999";
    public static final String OTHER_THEN_LISTED_THANA_OUT_SIDE_INDIA = "0000000";

    public static final String OTHER_THEN_LISTED_VILLAGE_IN_INDIA = "999999";
    public static final String OTHER_THEN_LISTED_VILLAGE_OUT_SIDE_INDIA = "000000";

    // ========================================================================
    // # Document saving path
    // ========================================================================
    public static final String DOC_SAVING_PATH = "E:\\OFFLINE_IO_DOC\\";
    
}
