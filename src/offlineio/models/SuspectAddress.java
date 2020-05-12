package  offlineio.models;

public class SuspectAddress {

    public    String  address_id;
    public    String  fk_suspect_id;
    public    String  created_by;
    public    String  updated_by;
    public    String  captured_at;
    public    String  captured_by;
    public    String  device_id;
    public    String  house_no;
    public    String  house_owner_name;
    public    String  house_owner_phone_no;
    public    String  ip_address;
    public    String  latitude;
    public    String  longitude;
    public    String  other_country;
    public    String  other_district;
    public    String  other_state;
    public    String  other_thana;
    public    String  other_village;
    public    String  pin_code;
    public    String  post_office;
    public    String  revenue_village_name;
    public    String  village_head_name;
    public    String  village_head_phone_no;
    public    String  fk_address_type_code;
    public    String  fk_country_code;
    public    String  fk_current_status_code;
    public    String  fk_district_code;
    public    String  fk_state_code;
    public    String  fk_suspect_district_code;
    public    String  fk_suspect_ft_code;
    public    String  fk_suspect_state_code;
    public    String  fk_suspect_thana_code;
    public    String  fk_thana_code;
    public    String  fk_village_code;
    public String is_ready_for_sync;
    public String sync_status;

    public SuspectAddress(String address_id, String fk_suspect_id, String fk_address_type_code) {
        this.address_id = address_id;
        this.fk_suspect_id = fk_suspect_id;
        this.fk_address_type_code = fk_address_type_code;
    }

    public SuspectAddress(String address_id, String fk_suspect_id, String created_by, String updated_by, String captured_at, String captured_by, String device_id, String house_no, String house_owner_name, String house_owner_phone_no, String ip_address, String latitude, String longitude, String other_country, String other_district, String other_state, String other_thana, String other_village, String pin_code, String post_office, String revenue_village_name, String village_head_name, String village_head_phone_no, String fk_address_type_code, String fk_country_code, String fk_current_status_code, String fk_district_code, String fk_state_code, String fk_suspect_district_code, String fk_suspect_ft_code, String fk_suspect_state_code, String fk_suspect_thana_code, String fk_thana_code, String fk_village_code, String is_ready_for_sync, String sync_status) {
        this.address_id = address_id;
        this.fk_suspect_id = fk_suspect_id;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.captured_at = captured_at;
        this.captured_by = captured_by;
        this.device_id = device_id;
        this.house_no = house_no;
        this.house_owner_name = house_owner_name;
        this.house_owner_phone_no = house_owner_phone_no;
        this.ip_address = ip_address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.other_country = other_country;
        this.other_district = other_district;
        this.other_state = other_state;
        this.other_thana = other_thana;
        this.other_village = other_village;
        this.pin_code = pin_code;
        this.post_office = post_office;
        this.revenue_village_name = revenue_village_name;
        this.village_head_name = village_head_name;
        this.village_head_phone_no = village_head_phone_no;
        this.fk_address_type_code = fk_address_type_code;
        this.fk_country_code = fk_country_code;
        this.fk_current_status_code = fk_current_status_code;
        this.fk_district_code = fk_district_code;
        this.fk_state_code = fk_state_code;
        this.fk_suspect_district_code = fk_suspect_district_code;
        this.fk_suspect_ft_code = fk_suspect_ft_code;
        this.fk_suspect_state_code = fk_suspect_state_code;
        this.fk_suspect_thana_code = fk_suspect_thana_code;
        this.fk_thana_code = fk_thana_code;
        this.fk_village_code = fk_village_code;
        this.is_ready_for_sync = is_ready_for_sync;
        this.sync_status = sync_status;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getFk_suspect_id() {
        return fk_suspect_id;
    }

    public void setFk_suspect_id(String fk_suspect_id) {
        this.fk_suspect_id = fk_suspect_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
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

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getHouse_owner_name() {
        return house_owner_name;
    }

    public void setHouse_owner_name(String house_owner_name) {
        this.house_owner_name = house_owner_name;
    }

    public String getHouse_owner_phone_no() {
        return house_owner_phone_no;
    }

    public void setHouse_owner_phone_no(String house_owner_phone_no) {
        this.house_owner_phone_no = house_owner_phone_no;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOther_country() {
        return other_country;
    }

    public void setOther_country(String other_country) {
        this.other_country = other_country;
    }

    public String getOther_district() {
        return other_district;
    }

    public void setOther_district(String other_district) {
        this.other_district = other_district;
    }

    public String getOther_state() {
        return other_state;
    }

    public void setOther_state(String other_state) {
        this.other_state = other_state;
    }

    public String getOther_thana() {
        return other_thana;
    }

    public void setOther_thana(String other_thana) {
        this.other_thana = other_thana;
    }

    public String getOther_village() {
        return other_village;
    }

    public void setOther_village(String other_village) {
        this.other_village = other_village;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPost_office() {
        return post_office;
    }

    public void setPost_office(String post_office) {
        this.post_office = post_office;
    }

    public String getRevenue_village_name() {
        return revenue_village_name;
    }

    public void setRevenue_village_name(String revenue_village_name) {
        this.revenue_village_name = revenue_village_name;
    }

    public String getVillage_head_name() {
        return village_head_name;
    }

    public void setVillage_head_name(String village_head_name) {
        this.village_head_name = village_head_name;
    }

    public String getVillage_head_phone_no() {
        return village_head_phone_no;
    }

    public void setVillage_head_phone_no(String village_head_phone_no) {
        this.village_head_phone_no = village_head_phone_no;
    }

    public String getFk_address_type_code() {
        return fk_address_type_code;
    }

    public void setFk_address_type_code(String fk_address_type_code) {
        this.fk_address_type_code = fk_address_type_code;
    }

    public String getFk_country_code() {
        return fk_country_code;
    }

    public void setFk_country_code(String fk_country_code) {
        this.fk_country_code = fk_country_code;
    }

    public String getFk_current_status_code() {
        return fk_current_status_code;
    }

    public void setFk_current_status_code(String fk_current_status_code) {
        this.fk_current_status_code = fk_current_status_code;
    }

    public String getFk_district_code() {
        return fk_district_code;
    }

    public void setFk_district_code(String fk_district_code) {
        this.fk_district_code = fk_district_code;
    }

    public String getFk_state_code() {
        return fk_state_code;
    }

    public void setFk_state_code(String fk_state_code) {
        this.fk_state_code = fk_state_code;
    }

    public String getFk_suspect_district_code() {
        return fk_suspect_district_code;
    }

    public void setFk_suspect_district_code(String fk_suspect_district_code) {
        this.fk_suspect_district_code = fk_suspect_district_code;
    }

    public String getFk_suspect_ft_code() {
        return fk_suspect_ft_code;
    }

    public void setFk_suspect_ft_code(String fk_suspect_ft_code) {
        this.fk_suspect_ft_code = fk_suspect_ft_code;
    }

    public String getFk_suspect_state_code() {
        return fk_suspect_state_code;
    }

    public void setFk_suspect_state_code(String fk_suspect_state_code) {
        this.fk_suspect_state_code = fk_suspect_state_code;
    }

    public String getFk_suspect_thana_code() {
        return fk_suspect_thana_code;
    }

    public void setFk_suspect_thana_code(String fk_suspect_thana_code) {
        this.fk_suspect_thana_code = fk_suspect_thana_code;
    }

    public String getFk_thana_code() {
        return fk_thana_code;
    }

    public void setFk_thana_code(String fk_thana_code) {
        this.fk_thana_code = fk_thana_code;
    }

    public String getFk_village_code() {
        return fk_village_code;
    }

    public void setFk_village_code(String fk_village_code) {
        this.fk_village_code = fk_village_code;
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
}
