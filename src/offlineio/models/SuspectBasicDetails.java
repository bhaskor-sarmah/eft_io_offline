package  offlineio.models;

public class SuspectBasicDetails {
  public static final String SUSPECT_BASIC_DETAILS_TABLE = "trans_suspect";

  public static final String COLUMN_SUSPECT_ID = "suspect_id";
  public static final String COLUMN_OFFLINE_ID = "temp_id";
  public static final String COLUMN_SUSPECT_FIRST_NAME = "first_name";
  public static final String COLUMN_SUSPECT_MIDDLE_NAME = "middle_name";
  public static final String COLUMN_SUSPECT_LAST_NAME = "last_name";
  public static final String COLUMN_ALIAS_NAME = "suspect_alias_name";
  public static final String COLUMN_FATHER_NAME = "father_name";
  public static final String COLUMN_MOTHER_NO = "mother_name";
  public static final String COLUMN_FK_GENDER_CODE = "fk_gender_code";
  public static final String COLUMN_FK_MARITAL_STATUS_CODE = "fk_marital_status_code";
  public static final String COLUMN_OCCUPATION_CODE = "fk_occupation_code";
  public static final String COLUMN_OCCUPATION_NAME = "occupation_name";
  public static final String COLUMN_INITIATED_BY = "initiated_by";
  public static final String COLUMN_WITNESS1 = "witness1";
  public static final String COLUMN_WITNESS2 = "witness2";

  public static final String COLUMN_AGE = "age";
  public static final String COLUMN_AGE_ON_DATE = "age_on_date";
  public static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
  public static final String COLUMN_PLACE_OF_BIRTH = "place_of_birth";
  public static final String COLUMN_EMAIL = "email";
  public static final String COLUMN_MOBILE_NO = "mobile_no";
  public static final String COLUMN_PHOTO_PATH = "photo_path";
  public static final String COLUMN_IS_EMPLOYED = "is_employed";
  public static final String COLUMN_FK_EMPLOYMENT_TYPE_CODE = "fk_employment_type_code";
  public static final String COLUMN_EMPLOYMENT_TYPE_NAME = "employment_type_name";
  public static final String COLUMN_EMPLOYEE_NAME = "employer_name";
  public static final String COLUMN_IS_VOTER = "is_voter";
  public static final String COLUMN_EPIC_NO = "epic_no";
  public static final String COLUMN_PART_NAME = "part_name";
  public static final String COLUMN_PART_NO = "part_no";
  public static final String COLUMN_WHEN_INCLUDED_IN_ER = "when_included_in_er";

  public static final String COLUMN_EYE = "eye";
  public static final String COLUMN_HAIR = "hair";
  public static final String COLUMN_HEIGHT = "height";
  public static final String COLUMN_COMPLEXION = "complexion";
  public static final String COLUMN_IDENTIFICATION_MARK = "identification_mark";

  public static final String COLUMN_HAS_FOREIGN_PASSPORT = "has_foreign_passport";
  public static final String COLUMN_FOREIGN_DETAILS = "foreign_passport_details";
  public static final String COLUMN_HAS_LAND_HOUSE = "has_land_house";
  public static final String COLUMN_LAND_HOUSE_DAG_NO = "land_house_dag_no";
  public static final String COLUMN_LAND_HOUSE_DETAILS = "land_house_details";
  public static final String COLUMN_LAND_HOUSE_FROM = "land_house_from";
  public static final String COLUMN_LAND_HOUSE_PATTA_NO = "land_house_patta_no";


  public static final String COLUMN_SINCE_WHEN_STAYING = "since_when_staying";
  public static final String COLUMN_FK_IMMIGRATION_ROUTE_CODE = "fk_immigration_route_code";
  public static final String COLUMN_IMMIGRATION_ROUTE_NAME = "immigration_route_name";

  public static final String COLUMN_FK_FOREIGN_COUNTRY_CODE = "fk_foreign_country_code";
  public static final String COLUMN_FK_SUSPECT_DISTRICT_CODE = "fk_suspect_district_code";
  public static final String COLUMN_FK_SUSPECT_STATE_CODE = "fk_suspect_state_code";
  public static final String COLUMN_FOREIGN_COUNTRY_NAME  = "foreign_country_name";
  public static final String COLUMN_SUSPECT_DISTRICT_NAME  = "suspect_district_name";
  public static final String COLUMN_SUSPECT_STATE_NAME = "suspect_state_name";

  public static final String COLUMN_FK_SUSPECT_THANA_CODE = "fk_suspect_thana_code";
  public static final String COLUMN_CAPTURED_AT = "captured_at";
  public static final String COLUMN_CAPTURED_BY = "captured_by";
  public static final String COLUMN_DEVICE_ID = "device_id";
  public static final String COLUMN_IP_ADDRESS = "ip_address";
  public static final String COLUMN_CAPTURED_LOCATION_LAT = "captured_loc_lat";
  public static final String COLUMN_CAPTURED_LOCATION_LAN = "captured_loc_lan";
  public static final String COLUMN_IS_READY_FOR_SYNC = "is_ready_for_sync";
  public static final String COLUMN_SYNC_STATUS = "sync_status";



  public static final String COLUMN_FINAL_SAVE_BASIC_DETAILS= "final_save_basic";
  public static final String COLUMN_FINAL_SAVE_ADDRESS_DETAILS= "final_save_address";
  public static final String COLUMN_FINAL_SAVE_FAMILY_DETAILS= "final_save_family";
  public static final String COLUMN_FINAL_SAVE_BIOMETRIC_DETAILS= "final_save_biometric";
  public static final String COLUMN_FINAL_SAVE_DOCUMENT_DETAILS= "final_save_document";

  public static final String COLUMN_BIOMETRIC_SYNC= "bio_sync_status";
  public static final String COLUMN_DOCUMENT_SYNC= "doc_sync_status";






  private String temp_id ;
  private String suspect_id ;
  private String first_name ;
  private String middle_name ;
  private String last_name ;
  private String suspect_alias_name ;

  private String father_name ;
  private String mother_name ;

  private String fk_gender_code ;
  private String fk_marital_status_code ;

  private String fk_occupation_code ;
  private String occupation_name ;
  private String initiated_by ;
  private String witness1 ;
  private String witness2 ;
  private String age ;
  private String age_on_date ;
  private String date_of_birth ;
  private String place_of_birth ;
  private String email ;
  private String mobile_no ;
  private String photo_path ;
  private String is_employed ;
  private String fk_employment_type_code ;
  private String employment_type_name ;
  private String employer_name ;
  private String is_voter ;
  private String epic_no ;
  private String part_name ;
  private String part_no ;
  private String when_included_in_er ;
  private String eye ;
  private String hair ;
  private String height ;
  private String complexion ;
  private String identification_mark ;
  private String has_foreign_passport ;
  private String fk_foreign_country_code ;
  private String foreign_country_name ;
  private String foreign_passport_details ;
  private String has_land_house ;
  private String land_house_dag_no ;
  private String land_house_details ;
  private String land_house_from ;
  private String land_house_patta_no ;


  private String since_when_staying ;
  private String fk_immigration_route_code ;
  private String immigration_route_name ;


  /************  Thana details ******************/
  private String fk_suspect_state_code ;
  private String fk_suspect_district_code ;
  private String suspect_district_name ;
  private String suspect_state_name ;
  private String fk_suspect_thana_code ;

  private String captured_at ;
  private String captured_by ;
  private String device_id ;
  private String ip_address ;
  private String captured_loc_lat ;
  private String captured_loc_lan ;
  private String is_ready_for_sync;
  private String sync_status;

  private String final_save ;
  private String final_save_address ;
  private String final_save_family ;
  private String final_save_biometric ;
  private String final_save_document ;


  private String bio_sync_status ;
  private String doc_sync_status ;


  public static final String CREATE_TABLE_SUSPECT_BASIC_DETAILS=
          "CREATE TABLE IF NOT EXISTS " + SUSPECT_BASIC_DETAILS_TABLE + "("

                  + COLUMN_OFFLINE_ID  +  " TEXT PRIMARY KEY ,"
                  + COLUMN_SUSPECT_ID  +  " TEXT,"
                  + COLUMN_SUSPECT_FIRST_NAME  +  " TEXT,"
                  + COLUMN_SUSPECT_MIDDLE_NAME  +  " TEXT,"
                  + COLUMN_SUSPECT_LAST_NAME  +  " TEXT,"
                  + COLUMN_ALIAS_NAME  +  " TEXT,"
                  + COLUMN_FATHER_NAME  +  " TEXT,"
                  + COLUMN_MOTHER_NO  +  " TEXT,"
                  + COLUMN_FK_GENDER_CODE  +  " TEXT,"
                  + COLUMN_FK_MARITAL_STATUS_CODE  +  " TEXT,"
                  + COLUMN_OCCUPATION_CODE  +  " TEXT,"
                  + COLUMN_OCCUPATION_NAME  +  " TEXT,"
                  + COLUMN_INITIATED_BY  +  " TEXT,"
                  + COLUMN_WITNESS1  +  " TEXT,"
                  + COLUMN_WITNESS2  +  " TEXT,"

                  + COLUMN_AGE  +  " TEXT,"
                  + COLUMN_AGE_ON_DATE  +  " TEXT,"
                  + COLUMN_DATE_OF_BIRTH  +  " TEXT,"
                  + COLUMN_PLACE_OF_BIRTH  +  " TEXT,"
                  + COLUMN_EMAIL  +  " TEXT,"
                  + COLUMN_MOBILE_NO  +  " TEXT,"
                  + COLUMN_PHOTO_PATH  +  " TEXT,"
                  + COLUMN_IS_EMPLOYED  +  " TEXT,"
                  + COLUMN_FK_EMPLOYMENT_TYPE_CODE  +  " TEXT,"
                  + COLUMN_EMPLOYMENT_TYPE_NAME  +  " TEXT,"
                  + COLUMN_EMPLOYEE_NAME  +  " TEXT,"
                  + COLUMN_IS_VOTER  +  " TEXT,"
                  + COLUMN_EPIC_NO  +  " TEXT,"
                  + COLUMN_PART_NAME  +  " TEXT,"
                  + COLUMN_PART_NO  +  " TEXT,"
                  + COLUMN_WHEN_INCLUDED_IN_ER  +  " TEXT,"

                  + COLUMN_EYE  +  " TEXT,"
                  + COLUMN_HAIR  +  " TEXT,"
                  + COLUMN_HEIGHT  +  " TEXT,"
                  + COLUMN_COMPLEXION  +  " TEXT,"
                  + COLUMN_IDENTIFICATION_MARK  +  " TEXT,"

                  + COLUMN_HAS_FOREIGN_PASSPORT  +  " TEXT,"
                  + COLUMN_FOREIGN_DETAILS  +  " TEXT,"
                  + COLUMN_HAS_LAND_HOUSE  +  " TEXT,"
                  + COLUMN_LAND_HOUSE_DAG_NO  +  " TEXT,"
                  + COLUMN_LAND_HOUSE_DETAILS  +  " TEXT,"
                  + COLUMN_LAND_HOUSE_FROM  +  " TEXT,"
                  + COLUMN_LAND_HOUSE_PATTA_NO  +  " TEXT,"


                  + COLUMN_SINCE_WHEN_STAYING  +  " TEXT,"
                  + COLUMN_FK_IMMIGRATION_ROUTE_CODE  +  " TEXT,"
                  + COLUMN_IMMIGRATION_ROUTE_NAME  +  " TEXT,"

                  + COLUMN_FK_FOREIGN_COUNTRY_CODE  +  " TEXT,"
                  + COLUMN_FK_SUSPECT_DISTRICT_CODE  +  " TEXT,"
                  + COLUMN_FK_SUSPECT_STATE_CODE  +  " TEXT,"
                  + COLUMN_FOREIGN_COUNTRY_NAME   +  " TEXT,"
                  + COLUMN_SUSPECT_DISTRICT_NAME   +  " TEXT,"
                  + COLUMN_SUSPECT_STATE_NAME  +  " TEXT,"

                  + COLUMN_FK_SUSPECT_THANA_CODE  +  " TEXT,"
                  + COLUMN_CAPTURED_AT  +  " TEXT,"
                  + COLUMN_CAPTURED_BY  +  " TEXT,"
                  + COLUMN_DEVICE_ID  +  " TEXT,"
                  + COLUMN_IP_ADDRESS  +  " TEXT,"
                  + COLUMN_CAPTURED_LOCATION_LAT  +  " TEXT,"
                  + COLUMN_CAPTURED_LOCATION_LAN  +  " TEXT,"
                  + COLUMN_IS_READY_FOR_SYNC  +  " TEXT,"
                  + COLUMN_SYNC_STATUS  +  " TEXT,"


                  + COLUMN_FINAL_SAVE_BASIC_DETAILS  +  " TEXT,"
                  + COLUMN_FINAL_SAVE_ADDRESS_DETAILS  +  " TEXT,"
                  + COLUMN_FINAL_SAVE_FAMILY_DETAILS  +  " TEXT,"
                  + COLUMN_FINAL_SAVE_BIOMETRIC_DETAILS  +  " TEXT,"
                  + COLUMN_FINAL_SAVE_DOCUMENT_DETAILS  +  " TEXT, "
                  + COLUMN_BIOMETRIC_SYNC  +  " TEXT,"
                  + COLUMN_DOCUMENT_SYNC  +  " TEXT "




                  + ")";

  public SuspectBasicDetails() {
  }

  public SuspectBasicDetails(String temp_id, String first_name, String middle_name, String last_name, String father_name, String captured_by, String device_id, String ip_address, String captured_loc_lat, String captured_loc_lan, String is_ready_for_sync, String sync_status) {
    this.temp_id = temp_id;
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.father_name = father_name;
    this.captured_by = captured_by;
    this.device_id = device_id;
    this.ip_address = ip_address;
    this.captured_loc_lat = captured_loc_lat;
    this.captured_loc_lan = captured_loc_lan;
    this.is_ready_for_sync = is_ready_for_sync;
    this.sync_status = sync_status;
  }

  public SuspectBasicDetails(String temp_id, String suspect_id, String first_name, String middle_name, String last_name, String suspect_alias_name, String father_name, String mother_name, String fk_gender_code, String fk_marital_status_code, String fk_occupation_code, String occupation_name, String initiated_by, String witness1, String witness2, String age, String age_on_date, String date_of_birth, String place_of_birth, String email, String mobile_no, String photo_path, String is_employed, String fk_employment_type_code, String employment_type_name, String employer_name, String is_voter, String epic_no, String part_name, String part_no, String when_included_in_er, String eye, String hair, String height, String complexion, String identification_mark, String foreign_passport_details, String has_foreign_passport, String has_land_house, String land_house_dag_no, String land_house_details, String land_house_from, String land_house_patta_no, String since_when_staying, String fk_immigration_route_code, String immigration_route_name, String fk_foreign_country_code, String fk_suspect_district_code, String fk_suspect_state_code, String foreign_country_name, String suspect_district_name, String suspect_state_name, String fk_suspect_thana_code, String captured_at, String captured_by, String device_id, String ip_address, String captured_loc_lat, String captured_loc_lan, String is_ready_for_sync, String sync_status, String final_save, String address_final_save, String family_final_save, String biometric_final_status, String document_final_status      ) {
    this.temp_id = temp_id;
    this.suspect_id = suspect_id;
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.suspect_alias_name = suspect_alias_name;
    this.father_name = father_name;
    this.mother_name = mother_name;
    this.fk_gender_code = fk_gender_code;
    this.fk_marital_status_code = fk_marital_status_code;
    this.fk_occupation_code = fk_occupation_code;
    this.occupation_name = occupation_name;
    this.initiated_by = initiated_by;
    this.witness1 = witness1;
    this.witness2 = witness2;
    this.age = age;
    this.age_on_date = age_on_date;
    this.date_of_birth = date_of_birth;
    this.place_of_birth = place_of_birth;
    this.email = email;
    this.mobile_no = mobile_no;
    this.photo_path = photo_path;
    this.is_employed = is_employed;
    this.fk_employment_type_code = fk_employment_type_code;
    this.employment_type_name = employment_type_name;
    this.employer_name = employer_name;
    this.is_voter = is_voter;
    this.epic_no = epic_no;
    this.part_name = part_name;
    this.part_no = part_no;
    this.when_included_in_er = when_included_in_er;
    this.eye = eye;
    this.hair = hair;
    this.height = height;
    this.complexion = complexion;
    this.identification_mark = identification_mark;
    this.foreign_passport_details = foreign_passport_details;
    this.has_foreign_passport = has_foreign_passport;
    this.has_land_house = has_land_house;
    this.land_house_dag_no = land_house_dag_no;
    this.land_house_details = land_house_details;
    this.land_house_from = land_house_from;
    this.land_house_patta_no = land_house_patta_no;
    this.since_when_staying = since_when_staying;
    this.fk_immigration_route_code = fk_immigration_route_code;
    this.immigration_route_name = immigration_route_name;
    this.fk_foreign_country_code = fk_foreign_country_code;
    this.fk_suspect_district_code = fk_suspect_district_code;
    this.fk_suspect_state_code = fk_suspect_state_code;
    this.foreign_country_name = foreign_country_name;
    this.suspect_district_name = suspect_district_name;
    this.suspect_state_name = suspect_state_name;
    this.fk_suspect_thana_code = fk_suspect_thana_code;
    this.captured_at = captured_at;
    this.captured_by = captured_by;
    this.device_id = device_id;
    this.ip_address = ip_address;
    this.captured_loc_lat = captured_loc_lat;
    this.captured_loc_lan = captured_loc_lan;
    this.is_ready_for_sync = is_ready_for_sync;
    this.sync_status = sync_status;

    this.final_save = final_save;
    this.final_save_address = address_final_save;
    this.final_save_family = family_final_save;
    this.final_save_biometric = biometric_final_status;
    this.final_save_document = document_final_status;


  }

  public static String getSuspectBasicDetailsTable() {
    return SUSPECT_BASIC_DETAILS_TABLE;
  }

  public String getSuspect_id() {
    return suspect_id;
  }

  public void setSuspect_id(String suspect_id) {
    this.suspect_id = suspect_id;
  }

  public String getTemp_id() {
    return temp_id;
  }

  public void setTemp_id(String temp_id) {
    this.temp_id = temp_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public void setMiddle_name(String middle_name) {
    this.middle_name = middle_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getSuspect_alias_name() {
    return suspect_alias_name;
  }

  public void setSuspect_alias_name(String suspect_alias_name) {
    this.suspect_alias_name = suspect_alias_name;
  }

  public String getFather_name() {
    return father_name;
  }

  public void setFather_name(String father_name) {
    this.father_name = father_name;
  }

  public String getMother_name() {
    return mother_name;
  }

  public void setMother_name(String mother_name) {
    this.mother_name = mother_name;
  }

  public String getFk_gender_code() {
    return fk_gender_code;
  }

  public void setFk_gender_code(String fk_gender_code) {
    this.fk_gender_code = fk_gender_code;
  }

  public String getFk_marital_status_code() {
    return fk_marital_status_code;
  }

  public void setFk_marital_status_code(String fk_marital_status_code) {
    this.fk_marital_status_code = fk_marital_status_code;
  }

  public String getFk_occupation_code() {
    return fk_occupation_code;
  }

  public void setFk_occupation_code(String fk_occupation_code) {
    this.fk_occupation_code = fk_occupation_code;
  }

  public String getOccupation_name() {
    return occupation_name;
  }

  public void setOccupation_name(String occupation_name) {
    this.occupation_name = occupation_name;
  }

  public String getInitiated_by() {
    return initiated_by;
  }

  public void setInitiated_by(String initiated_by) {
    this.initiated_by = initiated_by;
  }

  public String getWitness1() {
    return witness1;
  }

  public void setWitness1(String witness1) {
    this.witness1 = witness1;
  }

  public String getWitness2() {
    return witness2;
  }

  public void setWitness2(String witness2) {
    this.witness2 = witness2;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAge_on_date() {
    return age_on_date;
  }

  public void setAge_on_date(String age_on_date) {
    this.age_on_date = age_on_date;
  }

  public String getDate_of_birth() {
    return date_of_birth;
  }

  public void setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public String getPlace_of_birth() {
    return place_of_birth;
  }

  public void setPlace_of_birth(String place_of_birth) {
    this.place_of_birth = place_of_birth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile_no() {
    return mobile_no;
  }

  public void setMobile_no(String mobile_no) {
    this.mobile_no = mobile_no;
  }

  public String getPhoto_path() {
    return photo_path;
  }

  public void setPhoto_path(String photo_path) {
    this.photo_path = photo_path;
  }

  public String getIs_employed() {
    return is_employed;
  }

  public void setIs_employed(String is_employed) {
    this.is_employed = is_employed;
  }

  public String getFk_employment_type_code() {
    return fk_employment_type_code;
  }

  public void setFk_employment_type_code(String fk_employment_type_code) {
    this.fk_employment_type_code = fk_employment_type_code;
  }

  public String getEmployment_type_name() {
    return employment_type_name;
  }

  public void setEmployment_type_name(String employment_type_name) {
    this.employment_type_name = employment_type_name;
  }

  public String getEmployer_name() {
    return employer_name;
  }

  public void setEmployer_name(String employer_name) {
    this.employer_name = employer_name;
  }

  public String getIs_voter() {
    return is_voter;
  }

  public void setIs_voter(String is_voter) {
    this.is_voter = is_voter;
  }

  public String getEpic_no() {
    return epic_no;
  }

  public void setEpic_no(String epic_no) {
    this.epic_no = epic_no;
  }

  public String getPart_name() {
    return part_name;
  }

  public void setPart_name(String part_name) {
    this.part_name = part_name;
  }

  public String getPart_no() {
    return part_no;
  }

  public void setPart_no(String part_no) {
    this.part_no = part_no;
  }

  public String getWhen_included_in_er() {
    return when_included_in_er;
  }

  public void setWhen_included_in_er(String when_included_in_er) {
    this.when_included_in_er = when_included_in_er;
  }

  public String getEye() {
    return eye;
  }

  public void setEye(String eye) {
    this.eye = eye;
  }

  public String getHair() {
    return hair;
  }

  public void setHair(String hair) {
    this.hair = hair;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getComplexion() {
    return complexion;
  }

  public void setComplexion(String complexion) {
    this.complexion = complexion;
  }

  public String getIdentification_mark() {
    return identification_mark;
  }

  public void setIdentification_mark(String identification_mark) {
    this.identification_mark = identification_mark;
  }

  public String getForeign_passport_details() {
    return foreign_passport_details;
  }

  public void setForeign_passport_details(String foreign_passport_details) {
    this.foreign_passport_details = foreign_passport_details;
  }

  public String getHas_foreign_passport() {
    return has_foreign_passport;
  }

  public void setHas_foreign_passport(String has_foreign_passport) {
    this.has_foreign_passport = has_foreign_passport;
  }

  public String getHas_land_house() {
    return has_land_house;
  }

  public void setHas_land_house(String has_land_house) {
    this.has_land_house = has_land_house;
  }

  public String getLand_house_dag_no() {
    return land_house_dag_no;
  }

  public void setLand_house_dag_no(String land_house_dag_no) {
    this.land_house_dag_no = land_house_dag_no;
  }

  public String getLand_house_details() {
    return land_house_details;
  }

  public void setLand_house_details(String land_house_details) {
    this.land_house_details = land_house_details;
  }

  public String getLand_house_from() {
    return land_house_from;
  }

  public void setLand_house_from(String land_house_from) {
    this.land_house_from = land_house_from;
  }

  public String getLand_house_patta_no() {
    return land_house_patta_no;
  }

  public void setLand_house_patta_no(String land_house_patta_no) {
    this.land_house_patta_no = land_house_patta_no;
  }

  public String getSince_when_staying() {
    return since_when_staying;
  }

  public void setSince_when_staying(String since_when_staying) {
    this.since_when_staying = since_when_staying;
  }

  public String getFk_immigration_route_code() {
    return fk_immigration_route_code;
  }

  public void setFk_immigration_route_code(String fk_immigration_route_code) {
    this.fk_immigration_route_code = fk_immigration_route_code;
  }

  public String getImmigration_route_name() {
    return immigration_route_name;
  }

  public void setImmigration_route_name(String immigration_route_name) {
    this.immigration_route_name = immigration_route_name;
  }

  public String getFk_foreign_country_code() {
    return fk_foreign_country_code;
  }

  public void setFk_foreign_country_code(String fk_foreign_country_code) {
    this.fk_foreign_country_code = fk_foreign_country_code;
  }

  public String getFk_suspect_district_code() {
    return fk_suspect_district_code;
  }

  public void setFk_suspect_district_code(String fk_suspect_district_code) {
    this.fk_suspect_district_code = fk_suspect_district_code;
  }

  public String getFk_suspect_state_code() {
    return fk_suspect_state_code;
  }

  public void setFk_suspect_state_code(String fk_suspect_state_code) {
    this.fk_suspect_state_code = fk_suspect_state_code;
  }

  public String getForeign_country_name() {
    return foreign_country_name;
  }

  public void setForeign_country_name(String foreign_country_name) {
    this.foreign_country_name = foreign_country_name;
  }

  public String getSuspect_district_name() {
    return suspect_district_name;
  }

  public void setSuspect_district_name(String suspect_district_name) {
    this.suspect_district_name = suspect_district_name;
  }

  public String getSuspect_state_name() {
    return suspect_state_name;
  }

  public void setSuspect_state_name(String suspect_state_name) {
    this.suspect_state_name = suspect_state_name;
  }

  public String getFk_suspect_thana_code() {
    return fk_suspect_thana_code;
  }

  public void setFk_suspect_thana_code(String fk_suspect_thana_code) {
    this.fk_suspect_thana_code = fk_suspect_thana_code;
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

  public String getDevice_id() {
    return device_id;
  }

  public void setDevice_id(String device_id) {
    this.device_id = device_id;
  }

  public String getIp_address() {
    return ip_address;
  }

  public void setIp_address(String ip_address) {
    this.ip_address = ip_address;
  }

  public String getCaptured_loc_lat() {
    return captured_loc_lat;
  }

  public void setCaptured_loc_lat(String captured_loc_lat) {
    this.captured_loc_lat = captured_loc_lat;
  }

  public String getCaptured_loc_lan() {
    return captured_loc_lan;
  }

  public void setCaptured_loc_lan(String captured_loc_lan) {
    this.captured_loc_lan = captured_loc_lan;
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

  public static String getColumnSuspectId() {
    return COLUMN_SUSPECT_ID;
  }

  public String getFinal_save() {
    return final_save;
  }

  public void setFinal_save(String final_save) {
    this.final_save = final_save;
  }

  public static String getColumnOfflineId() {
    return COLUMN_OFFLINE_ID;
  }

  public String getFinal_save_address() {
    return final_save_address;
  }

  public void setFinal_save_address(String final_save_address) {
    this.final_save_address = final_save_address;
  }

  public String getFinal_save_family() {
    return final_save_family;
  }

  public void setFinal_save_family(String final_save_family) {
    this.final_save_family = final_save_family;
  }

  public String getFinal_save_biometric() {
    return final_save_biometric;
  }

  public void setFinal_save_biometric(String final_save_biometric) {
    this.final_save_biometric = final_save_biometric;
  }

  public String getFinal_save_document() {
    return final_save_document;
  }

  public void setFinal_save_document(String final_save_document) {
    this.final_save_document = final_save_document;
  }

  public String getBio_sync_status() {
    return bio_sync_status;
  }

  public void setBio_sync_status(String bio_sync_status) {
    this.bio_sync_status = bio_sync_status;
  }

  public String getDoc_sync_status() {
    return doc_sync_status;
  }

  public void setDoc_sync_status(String doc_sync_status) {
    this.doc_sync_status = doc_sync_status;
  }
}