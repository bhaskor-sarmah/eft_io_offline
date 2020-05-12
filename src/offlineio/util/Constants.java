package offlineio.util;

import java.util.regex.Pattern;

public class Constants {
  public static final int LOCATION_REQUEST = 1000;
  public static final int GPS_REQUEST = 1001;
  public static final String INDIA_COUNTRY_CODE = "91";
  public static final String ASSAM_STATE_CODE = "18";

  public static final String LOGIN_TYPE = "LOGIN_TYPE";
  public static final String ACCESS_TOKEN = "accessToken";
  public static final String EYE_REQUEST = "EYE_REQUEST";
  public static final int LEFT_EYE = 1;
  public static final int RIGHT_EYE = 2;

  public static final int FRESH_LOGIN = 1111;
  public static final int DATA_UP_SYNC_LOGIN =2222;
  public static final int DATA_DOWN_SYNC_LOGIN =3333;

    /*
    public static final String OTHER_THEN_LISTED_COUNTRY = "00";
    public static final String OTHER_THEN_LISTED_STATE = "00";
    public static final String OTHER_THEN_LISTED_DISTRICT = "000";
    public static final String OTHER_THEN_LISTED_THANA = "000";
    public static final String OTHER_THEN_LISTED_VILLAGE = "000";
*/


  public static final String OTHER_THEN_LISTED_COUNTRY = "00";
  public static final String OTHER_THEN_LISTED_STATE_IN_INDIA = "99";
  public static final String OTHER_THEN_LISTED_STATE_OUTSIDE_INDIA = "00";

  public static final String OTHER_THEN_LISTED_DISTRICT_IN_INDIA = "999";
  public static final String OTHER_THEN_LISTED_DISTRICT_OUT_SIDE_INDIA = "000";


  public static final String OTHER_THEN_LISTED_THANA_IN_INDIA = "99999999";
  public static final String OTHER_THEN_LISTED_THANA_OUT_SIDE_INDIA = "0000000";


  public static final String OTHER_THEN_LISTED_VILLAGE_IN_INDIA = "999999";
  public static final String OTHER_THEN_LISTED_VILLAGE_OUT_SIDE_INDIA = "000000";

  public static final int REQUEST_MAIN_DASHBOARD = 11;
  public static final int REQUEST_ADD_NEW_SUSPECT = 12;
  public static final int REQUEST_INCOMPLETE_SUSPECT = 13;
  public static final int REQUEST_COMPLETE_SUSPECT = 14;
  public static final int FURTHER_INVESTIGATION = 15;
  public static final int PENDING_SUSPECT_SYNC = 16;
  public static final int MASTER_DATA_SYNC = 17;
  public static final int PASSWORD_RESET = 18;


  public static final String REQUEST_CODE = "REQUEST_CODE";
  public static final String OFFLINE_ID = "OFFLINE_ID";
  public static final String SUSPECT_NAME = "SUSPECT_NAME";
  public static final String FAMILY_MEMBER_ID = "FAMILY_MEMBER_ID";
  public static final String GPS_LAT = "GPS_LAT";
  public static final String GPS_LAN = "GPS_LAN";
  public static final String CAMMERA = "CAMMERA";
  public static final String GALLERY = "GALLERY";
  public static final String BUTTON_VISIBLE = "BUTTON_VISIBLE";



  public static final String LANG_ASSAMESE = "AS";
  public static final String LANG_ENGLISH = "EN";
  public static final String ACTIVE = "Y";


  public static final String ADDRESS_OF_DETECTION= "01";
  public static final String ADDRESS_IN_INDIA= "02";
  public static final String ADDRESS_IN_COUNTRY_ORIGIN= "03";
  public static final String ADDRESS_OF_HOUSE_OWNER= "04";
  public static final String ADDRESS_OF_EMPLOYER= "05";


  public static final String ANSWER_YES = "Y";
  public static final String ANSWER_NO = "N";


}