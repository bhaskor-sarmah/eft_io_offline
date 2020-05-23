/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.models;

/**
 *
 * @author Bhaskor
 */
public class SuspectFamily {

    public String member_id;
    public String fk_suspect_id;
    public String created_at;
    public String updated_at;
    public String updated_by;
    public String captured_at;
    public String captured_by;
    public String device_id;
    public String ip_address;
    public String fk_suspect_district_code;
    public String fk_suspect_ft_code;
    public String fk_suspect_state_code;
    public String fk_suspect_thana_code;
    public String age;
    public String age_on_date;
    public String date_of_birth;
    public String member_name;
    public String place_of_birth;
    public String fk_current_status_code;
    public String fk_gender_code;
    public String fk_relation_code;

    public String is_ready_for_sync;
    public String sync_status;

    public SuspectFamily() {
    }

    public SuspectFamily(String member_id, String fk_suspect_id, String created_at, String updated_at, String updated_by, String captured_at, String captured_by, String device_id, String fk_suspect_district_code, String fk_suspect_state_code, String fk_suspect_thana_code) {
        this.member_id = member_id;
        this.fk_suspect_id = fk_suspect_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.captured_at = captured_at;
        this.captured_by = captured_by;
        this.device_id = device_id;
        this.fk_suspect_district_code = fk_suspect_district_code;
        this.fk_suspect_state_code = fk_suspect_state_code;
        this.fk_suspect_thana_code = fk_suspect_thana_code;
    }

    public SuspectFamily(String member_id, String fk_suspect_id, String created_at, String updated_at, String updated_by, String age, String age_on_date, String captured_at, String captured_by, String date_of_birth, String device_id, String ip_address, String member_name, String place_of_birth, String fk_current_status_code, String fk_gender_code, String fk_relation_code, String fk_suspect_district_code, String fk_suspect_ft_code, String fk_suspect_state_code, String fk_suspect_thana_code, String is_ready_for_sync, String sync_status) {
        this.member_id = member_id;
        this.fk_suspect_id = fk_suspect_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.age = age;
        this.age_on_date = age_on_date;
        this.captured_at = captured_at;
        this.captured_by = captured_by;
        this.date_of_birth = date_of_birth;
        this.device_id = device_id;
        this.ip_address = ip_address;
        this.member_name = member_name;
        this.place_of_birth = place_of_birth;
        this.fk_current_status_code = fk_current_status_code;
        this.fk_gender_code = fk_gender_code;
        this.fk_relation_code = fk_relation_code;
        this.fk_suspect_district_code = fk_suspect_district_code;
        this.fk_suspect_ft_code = fk_suspect_ft_code;
        this.fk_suspect_state_code = fk_suspect_state_code;
        this.fk_suspect_thana_code = fk_suspect_thana_code;
        this.is_ready_for_sync = is_ready_for_sync;
        this.sync_status = sync_status;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getFk_suspect_id() {
        return fk_suspect_id;
    }

    public void setFk_suspect_id(String fk_suspect_id) {
        this.fk_suspect_id = fk_suspect_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
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

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getFk_current_status_code() {
        return fk_current_status_code;
    }

    public void setFk_current_status_code(String fk_current_status_code) {
        this.fk_current_status_code = fk_current_status_code;
    }

    public String getFk_gender_code() {
        return fk_gender_code;
    }

    public void setFk_gender_code(String fk_gender_code) {
        this.fk_gender_code = fk_gender_code;
    }

    public String getFk_relation_code() {
        return fk_relation_code;
    }

    public void setFk_relation_code(String fk_relation_code) {
        this.fk_relation_code = fk_relation_code;
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
