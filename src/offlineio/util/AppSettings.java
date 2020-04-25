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

}
