package offlineio.util;

public class URLS {
    public static  final String BASE_URL="http://3.6.23.223:8080/eftapi";
    public static  final String BASE_URL2="http://192.168.29.32:9002";

    public static  final String BASE_URL1="http://192.168.43.166:9002";
    //public static  String BASE_URL="http://192.168.43.253:9002";

    public static  final String SIGN_IN_URL=BASE_URL+"/api/auth/signin";
    public static  final String GET_PIN_CODE_URL=BASE_URL+"/api/passcode";
    public static  final String GET_MASTER_VERSION_URL=BASE_URL+"/api/masterversion";
    public static  final String GET_MASTER_DATA_URL=BASE_URL+"/api/masters";
    public static  final String GET_DEPENDENT_MASTER_DATA_URL=BASE_URL+"/api/villagemaster";
    public static  final String UPDATE_PASSWORD_URL=BASE_URL+"/api/changepassword";


    public static  final String POST_SUSPECT_DATA_URL=BASE_URL+"/api/suspect-register";
    public static  final String POST_SUSPECT_DOCUMENT_URL=BASE_URL+"/api/sync-doc";
    public static  final String POST_SUSPECT_BIOMETRIC_URL=BASE_URL+"/api/sync-biometric";
    public static  final String POST_ASSIGN_PIN_URL=BASE_URL+"/api/assign-pin";



    public static  final String GET_PENDING_INVESTIGATION_LIST_URL=BASE_URL+"/api/communication-request";
//    public static  final String GET_PENDING_INVESTIGATION_BY_ID=BASE_URL+"/api/communication-reply";
    public static  final String POST_PENDING_INVESTIGATION_SUBMIT=BASE_URL+"/api/communication-reply";


    ///http://192.168.29.253:8081/api/auth/signin
}
