/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import offlineio.payload.request.MasterVersionForm;
import offlineio.payload.response.AddressType;
import offlineio.payload.response.Country;
import offlineio.payload.response.District;
import offlineio.payload.response.Document;
import offlineio.payload.response.EmploymentType;
import offlineio.payload.response.Gender;
import offlineio.payload.response.Lac;
import offlineio.payload.response.MaritalStatus;
import offlineio.payload.response.MasterVersion;
import offlineio.payload.response.Occupation;
import offlineio.payload.response.Relation;
import offlineio.payload.response.Religion;
import offlineio.payload.response.Route;
import offlineio.payload.response.State;
import offlineio.payload.response.Thana;
import offlineio.payload.response.Village;
import offlineio.util.MySQLConnection;

/**
 *
 * @author Bhaskor
 */
public class MasterDataDao {

    public static boolean saveAddressType(List<AddressType> addressList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (AddressType a : addressList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_address_type WHERE address_type_code = ?");
                ps.setString(index++, a.getAddressTypeCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_address_type` \n"
                            + "	(`address_type_code`, \n"
                            + "	`address_type_name`, \n"
                            + "	`address_type_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, a.getAddressTypeCode());
                    ps1.setString(index++, a.getAddressTypeName());
                    ps1.setString(index++, a.getAddressTypeAsm());
                    ps1.setString(index++, a.getVersion());
                    ps1.setString(index++, a.getIsActive());
                    ps1.setString(index++, a.getCreatedBy());
                    ps1.setString(index++, a.getCreatedAt());
                    ps1.setString(index++, a.getUpdatedBy());
                    ps1.setString(index++, a.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_address_type` \n"
                            + "	SET\n"
                            + "	`address_type_name` = ? , \n"
                            + "	`address_type_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`address_type_code` = ?");
                    ps1.setString(index++, a.getAddressTypeName());
                    ps1.setString(index++, a.getAddressTypeAsm());
                    ps1.setString(index++, a.getVersion());
                    ps1.setString(index++, a.getIsActive());
                    ps1.setString(index++, a.getCreatedBy());
                    ps1.setString(index++, a.getCreatedAt());
                    ps1.setString(index++, a.getUpdatedBy());
                    ps1.setString(index++, a.getUpdatedAt());
                    ps1.setString(index++, a.getAddressTypeCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterCountry(List<Country> contryList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Country c : contryList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_country WHERE country_code = ?");
                ps.setString(index++, c.getCountryCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_country` \n"
                            + "	(`country_code`, \n"
                            + "	`country_name`, \n"
                            + "	`country_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, c.getCountryCode());
                    ps1.setString(index++, c.getCountryName());
                    ps1.setString(index++, c.getCountryAsm());
                    ps1.setString(index++, c.getVersion());
                    ps1.setString(index++, c.getIsActive());
                    ps1.setString(index++, c.getCreatedBy());
                    ps1.setString(index++, c.getCreatedAt());
                    ps1.setString(index++, c.getUpdatedBy());
                    ps1.setString(index++, c.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_country` \n"
                            + "	SET\n"
                            + "	`country_name` = ? , \n"
                            + "	`country_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`country_code` = ?");
                    ps1.setString(index++, c.getCountryName());
                    ps1.setString(index++, c.getCountryAsm());
                    ps1.setString(index++, c.getVersion());
                    ps1.setString(index++, c.getIsActive());
                    ps1.setString(index++, c.getCreatedBy());
                    ps1.setString(index++, c.getCreatedAt());
                    ps1.setString(index++, c.getUpdatedBy());
                    ps1.setString(index++, c.getUpdatedAt());
                    ps1.setString(index++, c.getCountryCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterState(List<State> stateList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (State s : stateList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_state WHERE state_code = ?");
                ps.setString(index++, s.getStateCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_state` \n"
                            + "	(`state_code`, \n"
                            + "	`state_name`, \n"
                            + "	`state_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`, \n"
                            + "	`country_code`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
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
                    ps1.setString(index++, s.getStateCode());
                    ps1.setString(index++, s.getStateName());
                    ps1.setString(index++, s.getStateAsm());
                    ps1.setString(index++, s.getVersion());
                    ps1.setString(index++, s.getIsActive());
                    ps1.setString(index++, s.getCreatedBy());
                    ps1.setString(index++, s.getCreatedAt());
                    ps1.setString(index++, s.getUpdatedBy());
                    ps1.setString(index++, s.getUpdatedAt());
                    ps1.setString(index++, s.getCountry().getCountryCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_state` \n"
                            + "	SET\n"
                            + "	`state_name` = ? , \n"
                            + "	`state_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ?, \n"
                            + "	`country_code` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`state_code` = ?");
                    ps1.setString(index++, s.getStateName());
                    ps1.setString(index++, s.getStateAsm());
                    ps1.setString(index++, s.getVersion());
                    ps1.setString(index++, s.getIsActive());
                    ps1.setString(index++, s.getCreatedBy());
                    ps1.setString(index++, s.getCreatedAt());
                    ps1.setString(index++, s.getUpdatedBy());
                    ps1.setString(index++, s.getUpdatedAt());
                    ps1.setString(index++, s.getCountry().getCountryCode());
                    ps1.setString(index++, s.getStateCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterDistrict(List<District> districtList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (District d : districtList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_district WHERE district_code = ?");
                ps.setString(index++, d.getDistrictCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_district` \n"
                            + "	(`district_code`, \n"
                            + "	`district_name`, \n"
                            + "	`district_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`, \n"
                            + "	`type_of_district`, \n"
                            + "	`state_code`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
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
                    ps1.setString(index++, d.getDistrictCode());
                    ps1.setString(index++, d.getDistrictName());
                    ps1.setString(index++, d.getDistrictAsm());
                    ps1.setString(index++, d.getVersion());
                    ps1.setString(index++, d.getIsActive());
                    ps1.setString(index++, d.getCreatedBy());
                    ps1.setString(index++, d.getCreatedAt());
                    ps1.setString(index++, d.getUpdatedBy());
                    ps1.setString(index++, d.getUpdatedAt());
                    ps1.setString(index++, d.getTypeOfDistrict());
                    ps1.setString(index++, d.getState().getStateCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_district` \n"
                            + "	SET\n"
                            + "	`district_name` = ? , \n"
                            + "	`district_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ?, \n"
                            + "	`type_of_district` = ?, \n"
                            + "	`state_code` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`district_code` = ?");
                    ps1.setString(index++, d.getDistrictName());
                    ps1.setString(index++, d.getDistrictAsm());
                    ps1.setString(index++, d.getVersion());
                    ps1.setString(index++, d.getIsActive());
                    ps1.setString(index++, d.getCreatedBy());
                    ps1.setString(index++, d.getCreatedAt());
                    ps1.setString(index++, d.getUpdatedBy());
                    ps1.setString(index++, d.getUpdatedAt());
                    ps1.setString(index++, d.getTypeOfDistrict());
                    ps1.setString(index++, d.getState().getStateCode());
                    ps1.setString(index++, d.getDistrictCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterThana(List<Thana> thanaList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Thana t : thanaList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_thana WHERE thana_code = ?");
                ps.setString(index++, t.getThanaCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_thana` \n"
                            + "	(`thana_code`, \n"
                            + "	`thana_name`, \n"
                            + "	`thana_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`, \n"
                            + "	`district_code`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
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
                    ps1.setString(index++, t.getThanaCode());
                    ps1.setString(index++, t.getThanaName());
                    ps1.setString(index++, t.getThanaAsm());
                    ps1.setString(index++, t.getVersion());
                    ps1.setString(index++, t.getIsActive());
                    ps1.setString(index++, t.getCreatedBy());
                    ps1.setString(index++, t.getCreatedAt());
                    ps1.setString(index++, t.getUpdatedBy());
                    ps1.setString(index++, t.getUpdatedAt());
                    ps1.setString(index++, t.getDistrict().getDistrictCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_thana` \n"
                            + "	SET\n"
                            + "	`thana_name` = ? , \n"
                            + "	`thana_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ?, \n"
                            + "	`district_code` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`thana_code` = ?");
                    ps1.setString(index++, t.getThanaName());
                    ps1.setString(index++, t.getThanaAsm());
                    ps1.setString(index++, t.getVersion());
                    ps1.setString(index++, t.getIsActive());
                    ps1.setString(index++, t.getCreatedBy());
                    ps1.setString(index++, t.getCreatedAt());
                    ps1.setString(index++, t.getUpdatedBy());
                    ps1.setString(index++, t.getUpdatedAt());
                    ps1.setString(index++, t.getDistrict().getDistrictCode());
                    ps1.setString(index++, t.getThanaCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterLac(List<Lac> lacList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Lac l : lacList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_lac WHERE lac_code = ?");
                ps.setString(index++, l.getLacCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_lac` \n"
                            + "	(`lac_code`, \n"
                            + "	`lac_name`, \n"
                            + "	`lac_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`, \n"
                            + "	`lok_sabha`, \n"
                            + "	`district_code`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
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
                    ps1.setString(index++, l.getLacCode());
                    ps1.setString(index++, l.getLacName());
                    ps1.setString(index++, l.getLacAsm());
                    ps1.setString(index++, l.getVersion());
                    ps1.setString(index++, l.getIsActive());
                    ps1.setString(index++, l.getCreatedBy());
                    ps1.setString(index++, l.getCreatedAt());
                    ps1.setString(index++, l.getUpdatedBy());
                    ps1.setString(index++, l.getUpdatedAt());
                    ps1.setString(index++, l.getLoksabha());
                    ps1.setString(index++, l.getDistrict().getDistrictCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_lac` \n"
                            + "	SET\n"
                            + "	`lac_name` = ? , \n"
                            + "	`lac_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ?, \n"
                            + "	`lok_sabha` = ?, \n"
                            + "	`district_code` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`lac_code` = ?");
                    ps1.setString(index++, l.getLacName());
                    ps1.setString(index++, l.getLacAsm());
                    ps1.setString(index++, l.getVersion());
                    ps1.setString(index++, l.getIsActive());
                    ps1.setString(index++, l.getCreatedBy());
                    ps1.setString(index++, l.getCreatedAt());
                    ps1.setString(index++, l.getUpdatedBy());
                    ps1.setString(index++, l.getUpdatedAt());
                    ps1.setString(index++, l.getLoksabha());
                    ps1.setString(index++, l.getDistrict().getDistrictCode());
                    ps1.setString(index++, l.getLacCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterRelation(List<Relation> relationList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Relation rel : relationList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_relation WHERE relation_code = ?");
                ps.setString(index++, rel.getRelationCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_relation` \n"
                            + "	(`relation_code`, \n"
                            + "	`relation_name`, \n"
                            + "	`relation_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, rel.getRelationCode());
                    ps1.setString(index++, rel.getRelationName());
                    ps1.setString(index++, rel.getRelationAsm());
                    ps1.setString(index++, rel.getVersion());
                    ps1.setString(index++, rel.getIsActive());
                    ps1.setString(index++, rel.getCreatedBy());
                    ps1.setString(index++, rel.getCreatedAt());
                    ps1.setString(index++, rel.getUpdatedBy());
                    ps1.setString(index++, rel.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_relation` \n"
                            + "	SET\n"
                            + "	`relation_name` = ? , \n"
                            + "	`relation_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`relation_code` = ?");
                    ps1.setString(index++, rel.getRelationName());
                    ps1.setString(index++, rel.getRelationAsm());
                    ps1.setString(index++, rel.getVersion());
                    ps1.setString(index++, rel.getIsActive());
                    ps1.setString(index++, rel.getCreatedBy());
                    ps1.setString(index++, rel.getCreatedAt());
                    ps1.setString(index++, rel.getUpdatedBy());
                    ps1.setString(index++, rel.getUpdatedAt());
                    ps1.setString(index++, rel.getRelationCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterGender(List<Gender> genderList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Gender g : genderList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_gender WHERE gender_code = ?");
                ps.setString(index++, g.getGenderCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_gender` \n"
                            + "	(`gender_code`, \n"
                            + "	`gender_name`, \n"
                            + "	`gender_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, g.getGenderCode());
                    ps1.setString(index++, g.getGenderName());
                    ps1.setString(index++, g.getGenderAsm());
                    ps1.setString(index++, g.getVersion());
                    ps1.setString(index++, g.getIsActive());
                    ps1.setString(index++, g.getCreatedBy());
                    ps1.setString(index++, g.getCreatedAt());
                    ps1.setString(index++, g.getUpdatedBy());
                    ps1.setString(index++, g.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_gender` \n"
                            + "	SET\n"
                            + "	`gender_name` = ? , \n"
                            + "	`gender_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`gender_code` = ?");
                    ps1.setString(index++, g.getGenderName());
                    ps1.setString(index++, g.getGenderAsm());
                    ps1.setString(index++, g.getVersion());
                    ps1.setString(index++, g.getIsActive());
                    ps1.setString(index++, g.getCreatedBy());
                    ps1.setString(index++, g.getCreatedAt());
                    ps1.setString(index++, g.getUpdatedBy());
                    ps1.setString(index++, g.getUpdatedAt());
                    ps1.setString(index++, g.getGenderCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMaritalStatus(List<MaritalStatus> maritialStatusList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (MaritalStatus m : maritialStatusList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_marital_status WHERE marital_status_code = ?");
                ps.setString(index++, m.getMaritalStatusCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_marital_status` \n"
                            + "	(`marital_status_code`, \n"
                            + "	`marital_status_name`, \n"
                            + "	`marital_status_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, m.getMaritalStatusCode());
                    ps1.setString(index++, m.getMaritalStatusName());
                    ps1.setString(index++, m.getMaritalStatusAsm());
                    ps1.setString(index++, m.getVersion());
                    ps1.setString(index++, m.getIsActive());
                    ps1.setString(index++, m.getCreatedBy());
                    ps1.setString(index++, m.getCreatedAt());
                    ps1.setString(index++, m.getUpdatedBy());
                    ps1.setString(index++, m.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_marital_status` \n"
                            + "	SET\n"
                            + "	`marital_status_name` = ? , \n"
                            + "	`marital_status_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`marital_status_code` = ?");
                    ps1.setString(index++, m.getMaritalStatusName());
                    ps1.setString(index++, m.getMaritalStatusAsm());
                    ps1.setString(index++, m.getVersion());
                    ps1.setString(index++, m.getIsActive());
                    ps1.setString(index++, m.getCreatedBy());
                    ps1.setString(index++, m.getCreatedAt());
                    ps1.setString(index++, m.getUpdatedBy());
                    ps1.setString(index++, m.getUpdatedAt());
                    ps1.setString(index++, m.getMaritalStatusCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterOccupation(List<Occupation> occupationList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Occupation o : occupationList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_occupation WHERE occupation_code = ?");
                ps.setString(index++, o.getOccupationCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_occupation` \n"
                            + "	(`occupation_code`, \n"
                            + "	`occupation_name`, \n"
                            + "	`occupation_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, o.getOccupationCode());
                    ps1.setString(index++, o.getOccupationName());
                    ps1.setString(index++, o.getOccupationAsm());
                    ps1.setString(index++, o.getVersion());
                    ps1.setString(index++, o.getIsActive());
                    ps1.setString(index++, o.getCreatedBy());
                    ps1.setString(index++, o.getCreatedAt());
                    ps1.setString(index++, o.getUpdatedBy());
                    ps1.setString(index++, o.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_occupation` \n"
                            + "	SET\n"
                            + "	`occupation_name` = ? , \n"
                            + "	`occupation_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`occupation_code` = ?");
                    ps1.setString(index++, o.getOccupationName());
                    ps1.setString(index++, o.getOccupationAsm());
                    ps1.setString(index++, o.getVersion());
                    ps1.setString(index++, o.getIsActive());
                    ps1.setString(index++, o.getCreatedBy());
                    ps1.setString(index++, o.getCreatedAt());
                    ps1.setString(index++, o.getUpdatedBy());
                    ps1.setString(index++, o.getUpdatedAt());
                    ps1.setString(index++, o.getOccupationCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterReligion(List<Religion> religionList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Religion rel : religionList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_religion WHERE religion_code = ?");
                ps.setString(index++, rel.getReligionCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_religion` \n"
                            + "	(`religion_code`, \n"
                            + "	`religion_name`, \n"
                            + "	`religion_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, rel.getReligionCode());
                    ps1.setString(index++, rel.getReligionName());
                    ps1.setString(index++, rel.getReligionAsm());
                    ps1.setString(index++, rel.getVersion());
                    ps1.setString(index++, rel.getIsActive());
                    ps1.setString(index++, rel.getCreatedBy());
                    ps1.setString(index++, rel.getCreatedAt());
                    ps1.setString(index++, rel.getUpdatedBy());
                    ps1.setString(index++, rel.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_religion` \n"
                            + "	SET\n"
                            + "	`religion_name` = ? , \n"
                            + "	`religion_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`religion_code` = ?");
                    ps1.setString(index++, rel.getReligionName());
                    ps1.setString(index++, rel.getReligionAsm());
                    ps1.setString(index++, rel.getVersion());
                    ps1.setString(index++, rel.getIsActive());
                    ps1.setString(index++, rel.getCreatedBy());
                    ps1.setString(index++, rel.getCreatedAt());
                    ps1.setString(index++, rel.getUpdatedBy());
                    ps1.setString(index++, rel.getUpdatedAt());
                    ps1.setString(index++, rel.getReligionCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterDocument(List<Document> documentList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Document d : documentList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_document WHERE document_code = ?");
                ps.setString(index++, d.getDocCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_document` \n"
                            + "	(`document_code`, \n"
                            + "	`document_name`, \n"
                            + "	`document_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, d.getDocCode());
                    ps1.setString(index++, d.getDocName());
                    ps1.setString(index++, d.getDocAsm());
                    ps1.setString(index++, d.getVersion());
                    ps1.setString(index++, d.getIsActive());
                    ps1.setString(index++, d.getCreatedBy());
                    ps1.setString(index++, d.getCreatedAt());
                    ps1.setString(index++, d.getUpdatedBy());
                    ps1.setString(index++, d.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_document` \n"
                            + "	SET\n"
                            + "	`document_name` = ? , \n"
                            + "	`document_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`document_code` = ?");
                    ps1.setString(index++, d.getDocName());
                    ps1.setString(index++, d.getDocAsm());
                    ps1.setString(index++, d.getVersion());
                    ps1.setString(index++, d.getIsActive());
                    ps1.setString(index++, d.getCreatedBy());
                    ps1.setString(index++, d.getCreatedAt());
                    ps1.setString(index++, d.getUpdatedBy());
                    ps1.setString(index++, d.getUpdatedAt());
                    ps1.setString(index++, d.getDocCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterEmploymentType(List<EmploymentType> employmentTypeList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (EmploymentType emp : employmentTypeList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_employment_type WHERE employment_type_code = ?");
                ps.setString(index++, emp.getEmploymentTypeCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_employment_type` \n"
                            + "	(`employment_type_code`, \n"
                            + "	`employment_type_name`, \n"
                            + "	`employment_type_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, emp.getEmploymentTypeCode());
                    ps1.setString(index++, emp.getEmploymentTypeName());
                    ps1.setString(index++, emp.getEmploymentTypeAsm());
                    ps1.setString(index++, emp.getVersion());
                    ps1.setString(index++, emp.getIsActive());
                    ps1.setString(index++, emp.getCreatedBy());
                    ps1.setString(index++, emp.getCreatedAt());
                    ps1.setString(index++, emp.getUpdatedBy());
                    ps1.setString(index++, emp.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_employment_type` \n"
                            + "	SET\n"
                            + "	`employment_type_name` = ? , \n"
                            + "	`employment_type_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`employment_type_code` = ?");
                    ps1.setString(index++, emp.getEmploymentTypeName());
                    ps1.setString(index++, emp.getEmploymentTypeAsm());
                    ps1.setString(index++, emp.getVersion());
                    ps1.setString(index++, emp.getIsActive());
                    ps1.setString(index++, emp.getCreatedBy());
                    ps1.setString(index++, emp.getCreatedAt());
                    ps1.setString(index++, emp.getUpdatedBy());
                    ps1.setString(index++, emp.getUpdatedAt());
                    ps1.setString(index++, emp.getEmploymentTypeCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static boolean saveMasterRoute(List<Route> routeList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Route rou : routeList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_route WHERE route_code = ?");
                ps.setString(index++, rou.getRouteCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_route` \n"
                            + "	(`route_code`, \n"
                            + "	`route_name`, \n"
                            + "	`route_asm`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at` \n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?\n"
                            + "	)");
                    ps1.setString(index++, rou.getRouteCode());
                    ps1.setString(index++, rou.getRouteName());
                    ps1.setString(index++, rou.getRouteAsm());
                    ps1.setString(index++, rou.getVersion());
                    ps1.setString(index++, rou.getIsActive());
                    ps1.setString(index++, rou.getCreatedBy());
                    ps1.setString(index++, rou.getCreatedAt());
                    ps1.setString(index++, rou.getUpdatedBy());
                    ps1.setString(index++, rou.getUpdatedAt());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_route` \n"
                            + "	SET\n"
                            + "	`route_name` = ? , \n"
                            + "	`route_asm` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? \n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`route_code` = ?");
                    ps1.setString(index++, rou.getRouteName());
                    ps1.setString(index++, rou.getRouteAsm());
                    ps1.setString(index++, rou.getVersion());
                    ps1.setString(index++, rou.getIsActive());
                    ps1.setString(index++, rou.getCreatedBy());
                    ps1.setString(index++, rou.getCreatedAt());
                    ps1.setString(index++, rou.getUpdatedBy());
                    ps1.setString(index++, rou.getUpdatedAt());
                    ps1.setString(index++, rou.getRouteCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

    public static List<District> getAllDistrict() {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        PreparedStatement ps = null, ps1 = null;
        ResultSet rs = null, rs1 = null;
        String version = "0.1";
        try {
            ps1 = conn.prepareStatement("SELECT offline_version FROM master_table_status WHERE table_name = \"villageList\"");
            System.out.println(ps1);
            rs1 = ps1.executeQuery();
            while (rs1.next()) {
                version = rs1.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
            return null;
        } finally {
            try {
                if (rs1 != null) {
                    rs1.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (ps1 != null) {
                    ps1.close();
                }
            } catch (SQLException e) {

            }
        }

        List<District> districtList = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM master_district ORDER BY CAST(district_code AS UNSIGNED INT)");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                District d = new District();
                d.setDistrictCode(rs.getString("district_code"));
                d.setDistrictName(rs.getString("district_name"));
                d.setVersion(version); // Setting VillageList version for all District
                districtList.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Exception : " + e.getMessage());
            return null;
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
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return districtList;
    }

    public static boolean saveMasterVillage(List<Village> villageList) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (Village vill : villageList) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT * FROM master_village WHERE village_code = ?");
                ps.setString(index++, vill.getVillageCode());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
                }
            } catch (SQLException e) {
                System.out.println("Exception : " + e.getMessage());
                return false;
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
            }
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_village` \n"
                            + "	(`village_code`, \n"
                            + "	`village_name`, \n"
                            + "	`village_asm`, \n"
                            + "	`type_of_village`, \n"
                            + "	`version`, \n"
                            + "	`is_active`, \n"
                            + "	`district_code`, \n"
                            + "	`created_by`, \n"
                            + "	`created_at`, \n"
                            + "	`updated_by`, \n"
                            + "	`updated_at`, \n"
                            + "	`thana_code`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
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
                    ps1.setString(index++, vill.getVillageCode());
                    ps1.setString(index++, vill.getVillageName());
                    ps1.setString(index++, vill.getVillageAsm());
                    ps1.setString(index++, vill.getTypeOfVillage());
                    ps1.setString(index++, vill.getVersion());
                    ps1.setString(index++, vill.getIsActive());
                    ps1.setString(index++, vill.getDistrictCode());
                    ps1.setString(index++, vill.getCreatedBy());
                    ps1.setString(index++, vill.getCreatedAt());
                    ps1.setString(index++, vill.getUpdatedBy());
                    ps1.setString(index++, vill.getUpdatedAt());
                    ps1.setString(index++, vill.getThana().getThanaCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res <= 0) {
                        r = false;
                    }
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            } else {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("UPDATE `master_village` \n"
                            + "	SET\n"
                            + "	`village_name` = ? , \n"
                            + "	`village_asm` = ? , \n"
                            + "	`type_of_village` = ? , \n"
                            + "	`version` = ? , \n"
                            + "	`is_active` = ? , \n"
                            + "	`district_code` = ? , \n"
                            + "	`created_by` = ? , \n"
                            + "	`created_at` = ? , \n"
                            + "	`updated_by` = ? , \n"
                            + "	`updated_at` = ? , \n"
                            + "	`thana_code` = ?\n"
                            + "	\n"
                            + "	WHERE\n"
                            + "	`village_code` = ? ");
                    ps1.setString(index++, vill.getVillageName());
                    ps1.setString(index++, vill.getVillageAsm());
                    ps1.setString(index++, vill.getTypeOfVillage());
                    ps1.setString(index++, vill.getVersion());
                    ps1.setString(index++, vill.getIsActive());
                    ps1.setString(index++, vill.getDistrictCode());
                    ps1.setString(index++, vill.getCreatedBy());
                    ps1.setString(index++, vill.getCreatedAt());
                    ps1.setString(index++, vill.getUpdatedBy());
                    ps1.setString(index++, vill.getUpdatedAt());
                    ps1.setString(index++, vill.getThana().getThanaCode());
                    ps1.setString(index++, vill.getVillageCode());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                } catch (SQLException e) {
                    r = false;
                    System.out.println("Exception : " + e.getMessage());
                } finally {
                    try {
                        if (ps1 != null) {
                            ps1.close();
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return r;
    }

}
