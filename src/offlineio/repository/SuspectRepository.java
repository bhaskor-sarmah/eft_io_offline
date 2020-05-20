/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import offlineio.models.SuspectAddress;
import offlineio.models.SuspectBasicDetails;
import offlineio.util.MySQLConnection;

/**
 *
 * @author Bhaskor
 */
public class SuspectRepository {

    public static boolean saveSuspectBasic(SuspectBasicDetails suspect) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("INSERT INTO trans_suspect("
                    + "         `suspect_id`,\n"
                    + "		`temp_id`, \n"
                    + "		`first_name`, \n"
                    + "		`middle_name`, \n"
                    + "		`last_name`,\n"
                    + "		`father_name`,\n"
                    + "		`captured_at`, \n"
                    + "		`captured_by`, \n"
                    + "		`device_id`, \n"
                    + "		`captured_loc_lat`, \n"
                    + "		`captured_loc_lan`,\n"
                    + "		`is_ready_for_sync`, \n"
                    + "		`sync_status`, \n"
                    + "		`final_save_basic`, \n"
                    + "		`final_save_address`, \n"
                    + "		`final_save_family`, \n"
                    + "		`final_save_biometric`, \n"
                    + "		`final_save_document`, \n"
                    + "		`bio_sync_status`, \n"
                    + "		`doc_sync_status`,"
                    + "         `village_of_detection`) "
                    + "VALUES"
                    + "("
                    + "NULL,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?,"
                    + "?"
                    + ")");
            ps.setString(index++, suspect.getTemp_id());
            ps.setString(index++, suspect.getFirst_name());
            ps.setString(index++, suspect.getMiddle_name());
            ps.setString(index++, suspect.getLast_name());
            ps.setString(index++, suspect.getFather_name());
            ps.setString(index++, getDateTime());
            ps.setString(index++, suspect.getCaptured_by());
            ps.setString(index++, suspect.getDevice_id());
            ps.setString(index++, suspect.getCaptured_loc_lan());
            ps.setString(index++, suspect.getCaptured_loc_lat());
            ps.setString(index++, suspect.getIs_ready_for_sync());
            ps.setString(index++, suspect.getSync_status());
            ps.setString(index++, suspect.getFinal_save_basic());
            ps.setString(index++, suspect.getFinal_save_address());
            ps.setString(index++, suspect.getFinal_save_family());
            ps.setString(index++, suspect.getFinal_save_biometric());
            ps.setString(index++, suspect.getFinal_save_document());
            ps.setString(index++, suspect.getBio_sync_status());
            ps.setString(index++, suspect.getDoc_sync_status());
            ps.setString(index++, suspect.getVillage_of_detection());
            System.out.println(ps);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return false;
    }

    public static boolean deleteSuspectBasic(String temp_id) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("DELETE FROM trans_suspect WHERE temp_id = ?");
            ps.setString(index++, temp_id);
            System.out.println(ps);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return false;
    }

    private static String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);

    }

    public static List<SuspectBasicDetails> getAllPendingList() {
        List<SuspectBasicDetails> suspectList = new ArrayList<>();
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return suspectList;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("SELECT * FROM trans_suspect WHERE is_ready_for_sync = \"N\"");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                SuspectBasicDetails s = new SuspectBasicDetails();
                s.setTemp_id(rs.getString("temp_id"));
                s.setFirst_name(rs.getString("first_name"));
                s.setMiddle_name(rs.getString("middle_name"));
                s.setLast_name(rs.getString("last_name"));
                s.setFather_name(rs.getString("father_name"));
                s.setCaptured_at(rs.getString("captured_at"));
                s.setCaptured_by(rs.getString("captured_by"));

                s.setFinal_save_address(rs.getString("final_save_address"));
                s.setFinal_save_basic(rs.getString("final_save_basic"));
                s.setFinal_save_biometric(rs.getString("final_save_biometric"));
                s.setFinal_save_document(rs.getString("final_save_document"));
                s.setFinal_save_family(rs.getString("final_save_family"));
                suspectList.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return suspectList;
    }

    public static SuspectBasicDetails findSuspectById(String temp_id) {
        SuspectBasicDetails s = new SuspectBasicDetails();
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("SELECT * FROM trans_suspect WHERE temp_id = ?");
            ps.setString(index++, temp_id);
            System.out.println(ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                s.setTemp_id(rs.getString("temp_id"));
                s.setFirst_name(rs.getString("first_name"));
                s.setMiddle_name(rs.getString("middle_name"));
                s.setLast_name(rs.getString("last_name"));
                s.setSuspect_alias_name(rs.getString("suspect_alias_name"));
                s.setFather_name(rs.getString("father_name"));
                s.setMother_name(rs.getString("mother_name"));
                s.setFk_gender_code(rs.getString("fk_gender_code"));
                s.setFk_marital_status_code(rs.getString("fk_marital_status_code"));
                s.setFk_occupation_code(rs.getString("fk_occupation_code"));
                s.setOccupation_name(rs.getString("occupation_name"));
                s.setInitiated_by(rs.getString("initiated_by"));
                s.setWitness1(rs.getString("witness1"));
                s.setWitness2(rs.getString("witness2"));
                s.setAge(rs.getString("age"));
                s.setAge_on_date(rs.getString("age_on_date"));
                s.setDate_of_birth(rs.getString("date_of_birth"));
                s.setPlace_of_birth(rs.getString("place_of_birth"));
                s.setEmail(rs.getString("email"));
                s.setMobile_no(rs.getString("mobile_no"));
                s.setPhoto_path(rs.getString("photo_path"));
                s.setIs_employed(rs.getString("is_employed"));
                s.setFk_employment_type_code(rs.getString("fk_employment_type_code"));
                s.setEmployment_type_name(rs.getString("employment_type_name"));
                s.setEmployer_name(rs.getString("employer_name"));
                s.setIs_voter(rs.getString("is_voter"));
                s.setEpic_no(rs.getString("epic_no"));
                s.setPart_name(rs.getString("part_name"));
                s.setPart_no(rs.getString("part_no"));
                s.setWhen_included_in_er(rs.getString("when_included_in_er"));
                s.setEye(rs.getString("eye"));
                s.setHair(rs.getString("hair"));
                s.setHeight(rs.getString("height"));
                s.setComplexion(rs.getString("complexion"));
                s.setIdentification_mark(rs.getString("identification_mark"));
                s.setHas_foreign_passport(rs.getString("has_foreign_passport"));
                s.setForeign_passport_details(rs.getString("foreign_passport_details"));
                s.setHas_land_house(rs.getString("has_land_house"));
                s.setLand_house_dag_no(rs.getString("land_house_dag_no"));
                s.setLand_house_details(rs.getString("land_house_details"));
                s.setLand_house_from(rs.getString("land_house_from"));
                s.setLand_house_patta_no(rs.getString("land_house_patta_no"));
                s.setSince_when_staying(rs.getString("since_when_staying"));
                s.setFk_immigration_route_code(rs.getString("fk_immigration_route_code"));
                s.setImmigration_route_name(rs.getString("immigration_route_name"));
                s.setFk_foreign_country_code(rs.getString("fk_foreign_country_code"));
                s.setFk_suspect_district_code(rs.getString("fk_suspect_district_code"));
                s.setFk_suspect_state_code(rs.getString("fk_suspect_state_code"));
                s.setForeign_country_name(rs.getString("foreign_country_name"));
                s.setSuspect_district_name(rs.getString("suspect_district_name"));
                s.setSuspect_state_name(rs.getString("suspect_state_name"));
                s.setFk_suspect_thana_code(rs.getString("fk_suspect_thana_code"));
                s.setCaptured_at(rs.getString("captured_at"));
                s.setCaptured_by(rs.getString("captured_by"));
                s.setDevice_id(rs.getString("device_id"));
                s.setIp_address(rs.getString("ip_address"));
                s.setCaptured_loc_lat(rs.getString("captured_loc_lat"));
                s.setCaptured_loc_lan(rs.getString("captured_loc_lan"));
                s.setIs_ready_for_sync(rs.getString("is_ready_for_sync"));
                s.setSync_status(rs.getString("sync_status"));
                s.setFinal_save_basic(rs.getString("final_save_basic"));
                s.setFinal_save_address(rs.getString("final_save_address"));
                s.setFinal_save_family(rs.getString("final_save_family"));
                s.setFinal_save_biometric(rs.getString("final_save_biometric"));
                s.setFinal_save_document(rs.getString("final_save_document"));
                s.setBio_sync_status(rs.getString("bio_sync_status"));
                s.setDoc_sync_status(rs.getString("doc_sync_status"));
                s.setVillage_of_detection(rs.getString("village_of_detection"));
            }
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return s;
    }

    public static boolean updateSuspect(SuspectBasicDetails s) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("UPDATE `trans_suspect` \n"
                    + "	SET\n"
                    + "	`suspect_id` = ? , \n"
                    + "	`first_name` = ? , \n"
                    + "	`middle_name` = ? , \n"
                    + "	`last_name` = ? , \n"
                    + "	`suspect_alias_name` = ? , \n"
                    + "	`father_name` = ? , \n"
                    + "	`mother_name` = ? , \n"
                    + "	`fk_gender_code` = ? , \n"
                    + "	`fk_marital_status_code` = ? , \n"
                    + "	`fk_occupation_code` = ? , \n"
                    + "	`occupation_name` = ? , \n"
                    + "	`initiated_by` = ? , \n"
                    + "	`witness1` = ? , \n"
                    + "	`witness2` = ? , \n"
                    + "	`age` = ? , \n"
                    + "	`age_on_date` = ? , \n"
                    + "	`date_of_birth` = ? , \n"
                    + "	`place_of_birth` = ? , \n"
                    + "	`email` = ? , \n"
                    + "	`mobile_no` = ? , \n"
                    + "	`photo_path` = ? , \n"
                    + "	`is_employed` = ? , \n"
                    + "	`fk_employment_type_code` = ? , \n"
                    + "	`employment_type_name` = ? , \n"
                    + "	`employer_name` = ? , \n"
                    + "	`is_voter` = ? , \n"
                    + "	`epic_no` = ? , \n"
                    + "	`part_name` = ? , \n"
                    + "	`part_no` = ? , \n"
                    + "	`when_included_in_er` = ? , \n"
                    + "	`eye` = ? , \n"
                    + "	`hair` = ? , \n"
                    + "	`height` = ? , \n"
                    + "	`complexion` = ? , \n"
                    + "	`identification_mark` = ? , \n"
                    + "	`has_foreign_passport` = ? , \n"
                    + "	`foreign_passport_details` = ? , \n"
                    + "	`has_land_house` = ? , \n"
                    + "	`land_house_dag_no` = ? , \n"
                    + "	`land_house_details` = ? , \n"
                    + "	`land_house_from` = ? , \n"
                    + "	`land_house_patta_no` = ? , \n"
                    + "	`since_when_staying` = ? , \n"
                    + "	`fk_immigration_route_code` = ? , \n"
                    + "	`immigration_route_name` = ? , \n"
                    + "	`fk_foreign_country_code` = ? , \n"
                    + "	`fk_suspect_district_code` = ? , \n"
                    + "	`fk_suspect_state_code` = ? , \n"
                    + "	`foreign_country_name` = ? , \n"
                    + "	`suspect_district_name` = ? , \n"
                    + "	`suspect_state_name` = ? , \n"
                    + "	`fk_suspect_thana_code` = ? , \n"
                    + "	`captured_at` = ? , \n"
                    + "	`captured_by` = ? , \n"
                    + "	`device_id` = ? , \n"
                    + "	`ip_address` = ? , \n"
                    + "	`captured_loc_lat` = ? , \n"
                    + "	`captured_loc_lan` = ? , \n"
                    + "	`is_ready_for_sync` = ? , \n"
                    + "	`sync_status` = ? , \n"
                    + "	`final_save_basic` = ? , \n"
                    + "	`final_save_address` = ? , \n"
                    + "	`final_save_family` = ? , \n"
                    + "	`final_save_biometric` = ? , \n"
                    + "	`final_save_document` = ? , \n"
                    + "	`bio_sync_status` = ? , \n"
                    + "	`doc_sync_status` = ? \n"
                    + "	\n"
                    + "	WHERE\n"
                    + "	`temp_id` = ?;");
            ps.setString(index++, s.getSuspect_id());
            ps.setString(index++, s.getFirst_name());
            ps.setString(index++, s.getMiddle_name());
            ps.setString(index++, s.getLast_name());
            ps.setString(index++, s.getSuspect_alias_name());
            ps.setString(index++, s.getFather_name());
            ps.setString(index++, s.getMother_name());
            ps.setString(index++, s.getFk_gender_code());
            ps.setString(index++, s.getFk_marital_status_code());
            ps.setString(index++, s.getFk_occupation_code());
            ps.setString(index++, s.getOccupation_name());
            ps.setString(index++, s.getInitiated_by());
            ps.setString(index++, s.getWitness1());
            ps.setString(index++, s.getWitness2());
            ps.setString(index++, s.getAge());
            ps.setString(index++, s.getAge_on_date());
            ps.setString(index++, s.getDate_of_birth());
            ps.setString(index++, s.getPlace_of_birth());
            ps.setString(index++, s.getEmail());
            ps.setString(index++, s.getMobile_no());
            ps.setString(index++, s.getPhoto_path());
            ps.setString(index++, s.getIs_employed());
            ps.setString(index++, s.getFk_employment_type_code());
            ps.setString(index++, s.getEmployment_type_name());
            ps.setString(index++, s.getEmployer_name());
            ps.setString(index++, s.getIs_voter());
            ps.setString(index++, s.getEpic_no());
            ps.setString(index++, s.getPart_name());
            ps.setString(index++, s.getPart_no());
            ps.setString(index++, s.getWhen_included_in_er());
            ps.setString(index++, s.getEye());
            ps.setString(index++, s.getHair());
            ps.setString(index++, s.getHeight());
            ps.setString(index++, s.getComplexion());
            ps.setString(index++, s.getIdentification_mark());
            ps.setString(index++, s.getHas_foreign_passport());
            ps.setString(index++, s.getForeign_passport_details());
            ps.setString(index++, s.getHas_land_house());
            ps.setString(index++, s.getLand_house_dag_no());
            ps.setString(index++, s.getLand_house_details());
            ps.setString(index++, s.getLand_house_from());
            ps.setString(index++, s.getLand_house_patta_no());
            ps.setString(index++, s.getSince_when_staying());
            ps.setString(index++, s.getFk_immigration_route_code());
            ps.setString(index++, s.getImmigration_route_name());
            ps.setString(index++, s.getFk_foreign_country_code());
            ps.setString(index++, s.getFk_suspect_district_code());
            ps.setString(index++, s.getFk_suspect_state_code());
            ps.setString(index++, s.getForeign_country_name());
            ps.setString(index++, s.getSuspect_district_name());
            ps.setString(index++, s.getSuspect_state_name());
            ps.setString(index++, s.getFk_suspect_thana_code());
            ps.setString(index++, s.getCaptured_at());
            ps.setString(index++, s.getCaptured_by());
            ps.setString(index++, s.getDevice_id());
            ps.setString(index++, s.getIp_address());
            ps.setString(index++, s.getCaptured_loc_lat());
            ps.setString(index++, s.getCaptured_loc_lan());
            ps.setString(index++, s.getIs_ready_for_sync());
            ps.setString(index++, s.getSync_status());
            ps.setString(index++, s.getFinal_save_basic());
            ps.setString(index++, s.getFinal_save_address());
            ps.setString(index++, s.getFinal_save_family());
            ps.setString(index++, s.getFinal_save_biometric());
            ps.setString(index++, s.getFinal_save_document());
            ps.setString(index++, s.getBio_sync_status());
            ps.setString(index++, s.getDoc_sync_status());
            ps.setString(index++, s.getTemp_id());
            System.out.println(ps);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return false;
    }

    public static boolean saveAddress(SuspectAddress address) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("INSERT INTO `trans_suspect_address` \n"
                    + "	(`address_id`, \n"
                    + "	`fk_suspect_id`, \n"
                    + "	`created_by`, \n"
                    + "	`captured_at`, \n"
                    + "	`captured_by`, \n"
                    + "	`device_id`, \n"
                    + "	`house_no`, \n"
                    + "	`house_owner_name`, \n"
                    + "	`house_owner_phone_no`, \n"
                    + "	`ip_address`, \n"
                    + "	`latitude`, \n"
                    + "	`longitude`, \n"
                    + "	`other_country`, \n"
                    + "	`other_district`, \n"
                    + "	`other_state`, \n"
                    + "	`other_thana`, \n"
                    + "	`other_village`, \n"
                    + "	`pin_code`, \n"
                    + "	`post_office`, \n"
                    + "	`revenue_village_name`, \n"
                    + "	`village_head_name`, \n"
                    + "	`village_head_phone_no`, \n"
                    + "	`fk_address_type_code`, \n"
                    + "	`fk_country_code`, \n"
                    + "	`fk_current_status_code`, \n"
                    + "	`fk_district_code`, \n"
                    + "	`fk_state_code`, \n"
                    + "	`fk_suspect_district_code`, \n"
                    + "	`fk_suspect_ft_code`, \n"
                    + "	`fk_suspect_state_code`, \n"
                    + "	`fk_suspect_thana_code`, \n"
                    + "	`fk_thana_code`, \n"
                    + "	`fk_village_code`, \n"
                    + "	`is_ready_for_sync`, \n"
                    + "	`sync_status`\n"
                    + "	)\n"
                    + "	VALUES\n"
                    + "	("
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?\n"
                    + "	)");

            ps.setString(index++, address.getAddress_id());
            ps.setString(index++, address.getFk_suspect_id());
            ps.setString(index++, address.getCaptured_by());
            ps.setString(index++, getDateTime());
            ps.setString(index++, address.getCreated_by());
            ps.setString(index++, address.getDevice_id());

            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");

            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");

            ps.setString(index++, address.getFk_address_type_code());
            ps.setString(index++, address.getFk_country_code());
            ps.setString(index++, "");
            ps.setString(index++, address.getFk_district_code());
            ps.setString(index++, address.getFk_state_code());
            ps.setString(index++, address.getFk_suspect_district_code());
            ps.setString(index++, "");
            ps.setString(index++, address.getFk_suspect_state_code());
            ps.setString(index++, address.getFk_suspect_thana_code());
            ps.setString(index++, address.getFk_thana_code());
            ps.setString(index++, address.getFk_village_code());

            // IS READY FOR SYNC & SYNC STATUS
            ps.setString(index++, "N");
            ps.setString(index++, "N");

            System.out.println(ps);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return false;
    }

    public static boolean updateAddress(SuspectAddress suspectAddress) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("UPDATE `trans_suspect_address` \n"
                    + "	SET\n"
                    + "`fk_suspect_id` = ? ,\n"
                    + "`created_by` = ? ,\n"
                    + "`updated_by` = ? ,\n"
                    + "`captured_at` = ? ,\n"
                    + "`captured_by` = ? ,\n"
                    + "`device_id` = ? ,\n"
                    + "`house_no` = ? ,\n"
                    + "`house_owner_name` = ? ,\n"
                    + "`house_owner_phone_no` = ? ,\n"
                    + "`ip_address` = ? ,\n"
                    + "`latitude` = ? ,\n"
                    + "`longitude` = ? ,\n"
                    + "`other_country` = ? ,\n"
                    + "`other_district` = ? ,\n"
                    + "`other_state` = ? ,\n"
                    + "`other_thana` = ? ,\n"
                    + "`other_village` = ? ,\n"
                    + "`pin_code` = ? ,\n"
                    + "`post_office` = ? ,\n"
                    + "`revenue_village_name` = ? ,\n"
                    + "`village_head_name` = ? ,\n"
                    + "`village_head_phone_no` = ? ,\n"
                    + "`fk_address_type_code` = ? ,\n"
                    + "`fk_country_code` = ? ,\n"
                    + "`fk_current_status_code` = ? ,\n"
                    + "`fk_district_code` = ? ,\n"
                    + "`fk_state_code` = ? ,\n"
                    + "`fk_suspect_district_code` = ? ,\n"
                    + "`fk_suspect_ft_code` = ? ,\n"
                    + "`fk_suspect_state_code` = ? ,\n"
                    + "`fk_suspect_thana_code` = ? ,\n"
                    + "`fk_thana_code` = ? ,\n"
                    + "`fk_village_code` = ? ,\n"
                    + "`is_ready_for_sync` = ? ,\n"
                    + "`sync_status` = ?"
                    + "WHERE"
                    + "`address_id` = ?");
            ps.setString(index++, suspectAddress.getFk_suspect_id());
            ps.setString(index++, suspectAddress.getCreated_by());
            ps.setString(index++, suspectAddress.getUpdated_by());
            ps.setString(index++, suspectAddress.getCaptured_at());
            ps.setString(index++, suspectAddress.getCaptured_by());
            ps.setString(index++, suspectAddress.getDevice_id());
            ps.setString(index++, suspectAddress.getHouse_no());
            ps.setString(index++, suspectAddress.getHouse_owner_name());
            ps.setString(index++, suspectAddress.getHouse_owner_phone_no());
            ps.setString(index++, suspectAddress.getIp_address());
            ps.setString(index++, suspectAddress.getLatitude());
            ps.setString(index++, suspectAddress.getLongitude());
            ps.setString(index++, suspectAddress.getOther_country());
            ps.setString(index++, suspectAddress.getOther_district());
            ps.setString(index++, suspectAddress.getOther_state());
            ps.setString(index++, suspectAddress.getOther_thana());
            ps.setString(index++, suspectAddress.getOther_village());

            ps.setString(index++, suspectAddress.getPin_code());
            ps.setString(index++, suspectAddress.getPost_office());
            ps.setString(index++, suspectAddress.getRevenue_village_name());
            ps.setString(index++, suspectAddress.getVillage_head_name());
            ps.setString(index++, suspectAddress.getVillage_head_phone_no());
            ps.setString(index++, suspectAddress.getFk_address_type_code());
            ps.setString(index++, suspectAddress.getFk_country_code());
            ps.setString(index++, suspectAddress.getFk_current_status_code());
            ps.setString(index++, suspectAddress.getFk_district_code());
            ps.setString(index++, suspectAddress.getFk_state_code());
            ps.setString(index++, suspectAddress.getFk_suspect_district_code());
            ps.setString(index++, suspectAddress.getFk_suspect_ft_code());
            ps.setString(index++, suspectAddress.getFk_suspect_state_code());
            ps.setString(index++, suspectAddress.getFk_suspect_thana_code());
            ps.setString(index++, suspectAddress.getFk_thana_code());
            ps.setString(index++, suspectAddress.getFk_village_code());
            ps.setString(index++, suspectAddress.getIs_ready_for_sync());
            ps.setString(index++, suspectAddress.getSync_status());

            ps.setString(index++, suspectAddress.getAddress_id());
            System.out.println(ps);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return false;
    }

    public static boolean saveSuspectAddress(SuspectAddress address) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int index = 1;
            ps = conn.prepareStatement("INSERT INTO `trans_suspect_address` \n"
                    + "	(`address_id`, \n"
                    + "	`fk_suspect_id`, \n"
                    + "	`created_by`, \n"
                    + "	`captured_at`, \n"
                    + "	`captured_by`, \n"
                    + "	`device_id`, \n"
                    + "	`house_no`, \n"
                    + "	`house_owner_name`, \n"
                    + "	`house_owner_phone_no`, \n"
                    + "	`ip_address`, \n"
                    + "	`latitude`, \n"
                    + "	`longitude`, \n"
                    + "	`other_country`, \n"
                    + "	`other_district`, \n"
                    + "	`other_state`, \n"
                    + "	`other_thana`, \n"
                    + "	`other_village`, \n"
                    + "	`pin_code`, \n"
                    + "	`post_office`, \n"
                    + "	`revenue_village_name`, \n"
                    + "	`village_head_name`, \n"
                    + "	`village_head_phone_no`, \n"
                    + "	`fk_address_type_code`, \n"
                    + "	`fk_country_code`, \n"
                    + "	`fk_current_status_code`, \n"
                    + "	`fk_district_code`, \n"
                    + "	`fk_state_code`, \n"
                    + "	`fk_suspect_district_code`, \n"
                    + "	`fk_suspect_ft_code`, \n"
                    + "	`fk_suspect_state_code`, \n"
                    + "	`fk_suspect_thana_code`, \n"
                    + "	`fk_thana_code`, \n"
                    + "	`fk_village_code`, \n"
                    + "	`is_ready_for_sync`, \n"
                    + "	`sync_status`\n"
                    + "	)\n"
                    + "	VALUES\n"
                    + "	("
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + " ?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?\n"
                    + "	)");

            ps.setString(index++, address.getAddress_id());
            ps.setString(index++, address.getFk_suspect_id());
            ps.setString(index++, address.getCaptured_by());
            ps.setString(index++, getDateTime());
            ps.setString(index++, address.getCreated_by());
            ps.setString(index++, address.getDevice_id());

            ps.setString(index++, "");
            ps.setString(index++, address.getHouse_owner_name());
            ps.setString(index++, address.getHouse_owner_phone_no());
            ps.setString(index++, "");
            ps.setString(index++, "");
            ps.setString(index++, "");

            ps.setString(index++, address.getOther_country());
            ps.setString(index++, address.getOther_district());
            ps.setString(index++, address.getOther_state());
            ps.setString(index++, address.getOther_thana());
            ps.setString(index++, address.getOther_village());
            ps.setString(index++, address.getPin_code());
            ps.setString(index++, address.getPost_office());
            ps.setString(index++, address.getRevenue_village_name());
            ps.setString(index++, address.getVillage_head_name());
            ps.setString(index++, address.getVillage_head_phone_no());

            ps.setString(index++, address.getFk_address_type_code());
            ps.setString(index++, address.getFk_country_code());
            ps.setString(index++, "");
            ps.setString(index++, address.getFk_district_code());
            ps.setString(index++, address.getFk_state_code());
            ps.setString(index++, address.getFk_suspect_district_code());
            ps.setString(index++, "");
            ps.setString(index++, address.getFk_suspect_state_code());
            ps.setString(index++, address.getFk_suspect_thana_code());
            ps.setString(index++, address.getFk_thana_code());
            ps.setString(index++, address.getFk_village_code());

            // IS READY FOR SYNC & SYNC STATUS
            ps.setString(index++, "N");
            ps.setString(index++, "N");

            System.out.println(ps);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
        return false;
    }

    public static boolean updateOrSaveAddress(SuspectAddress suspectAddress) {
        Connection conn = null;
        boolean isAlreadySaved = false;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;
        if (null != suspectAddress.getAddress_id()) {
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM trans_suspect_address WHERE address_id = ?");
                ps.setString(index, suspectAddress.getAddress_id());
                rs = ps.executeQuery();
                if (rs.next()) {
                    isAlreadySaved = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {

                }
                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {

                }
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {

                }
            }
        }
        if (isAlreadySaved) {
            return updateAddress(suspectAddress);
        } else {
            return saveSuspectAddress(suspectAddress);
        }
    }

    public static List<SuspectAddress> getSuspectAddressList(String suspectId) {
        List<SuspectAddress> suspectAddress = new ArrayList<>();
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return suspectAddress;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int index = 1;
            ps = conn.prepareStatement("SELECT * FROM trans_suspect_address WHERE fk_suspect_id = ?");
            ps.setString(index, suspectId);
            rs = ps.executeQuery();
            while (rs.next()) {
                SuspectAddress address = new SuspectAddress();
                address.setAddress_id(rs.getString("address_id"));
                address.setFk_suspect_id(rs.getString("fk_suspect_id"));
                address.setCreated_by(rs.getString("created_by"));
                address.setUpdated_by(rs.getString("updated_by"));
                address.setCaptured_at(rs.getString("captured_at"));
                address.setCaptured_by(rs.getString("captured_by"));
                address.setDevice_id(rs.getString("device_id"));
                address.setHouse_no(rs.getString("house_no"));
                address.setHouse_owner_name(rs.getString("house_owner_name"));
                address.setHouse_owner_phone_no(rs.getString("house_owner_phone_no"));
                address.setIp_address(rs.getString("ip_address"));
                address.setLatitude(rs.getString("latitude"));
                address.setLongitude(rs.getString("longitude"));
                address.setOther_country(rs.getString("other_country"));
                address.setOther_district(rs.getString("other_district"));
                address.setOther_state(rs.getString("other_state"));
                address.setOther_thana(rs.getString("other_thana"));
                address.setOther_village(rs.getString("other_village"));
                address.setPin_code(rs.getString("pin_code"));
                address.setPost_office(rs.getString("post_office"));
                address.setRevenue_village_name(rs.getString("revenue_village_name"));
                address.setVillage_head_name(rs.getString("village_head_name"));
                address.setVillage_head_phone_no(rs.getString("village_head_phone_no"));
                address.setFk_address_type_code(rs.getString("fk_address_type_code"));
                address.setFk_country_code(rs.getString("fk_country_code"));
                address.setFk_current_status_code(rs.getString("fk_current_status_code"));
                address.setFk_district_code(rs.getString("fk_district_code"));
                address.setFk_state_code(rs.getString("fk_state_code"));
                address.setFk_suspect_district_code(rs.getString("fk_suspect_district_code"));
                address.setFk_suspect_ft_code(rs.getString("fk_suspect_ft_code"));
                address.setFk_suspect_state_code(rs.getString("fk_suspect_state_code"));
                address.setFk_suspect_thana_code(rs.getString("fk_suspect_thana_code"));
                address.setFk_thana_code(rs.getString("fk_thana_code"));
                address.setFk_village_code(rs.getString("fk_village_code"));
                address.setIs_ready_for_sync(rs.getString("is_ready_for_sync"));
                address.setSync_status(rs.getString("sync_status"));
                suspectAddress.add(address);
            }
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
            return suspectAddress;
        }
    }
}
