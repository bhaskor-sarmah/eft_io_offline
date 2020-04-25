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
import offlineio.payload.response.PassCode;
import offlineio.util.MySQLConnection;
import offlineio.util.StaticAppData;

/**
 *
 * @author Bhaskor
 */
public class PasscodeDao {

    public static boolean savePasscodeToDb(PassCode[] passCode) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (PassCode p : passCode) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT id FROM pin_master WHERE id = ?");
                ps.setString(index++, p.getPinId());
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
                    ps1 = conn.prepareStatement("INSERT INTO pin_master(`id`, \n"
                            + "	`user_name`, \n"
                            + "	`pin_code`, \n"
                            + "	`ps_code`, \n"
                            + "	`user_mobile`, \n"
                            + "	`user_email`, \n"
                            + "	`pin_status`, \n"
                            + "	`column_version`) VALUES(?,?,?,?,?,?,?,?)");
                    ps1.setString(index++, p.getPinId());
                    ps1.setString(index++, p.getUserName());
                    ps1.setString(index++, p.getPassCode());
                    ps1.setString(index++, p.getDevice().getThana().getThanaCode());
                    ps1.setString(index++, p.getMobileNo());
                    ps1.setString(index++, p.getEmail());
                    ps1.setString(index++, p.getIsActive());
                    ps1.setString(index++, p.getVersion());
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
            }
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return (r == true);
    }

    public static boolean verifyPasscode(String passcode) {
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
            ps = conn.prepareStatement("SELECT id,user_name FROM pin_master WHERE pin_code = ?");
            ps.setString(index++, passcode);
            System.out.println(ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                StaticAppData.setPinUserId(rs.getString("id"));
                StaticAppData.setPinUser((rs.getString("user_name") == null) ? "" : rs.getString("user_name").toUpperCase());
                return true;
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
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return false;
    }
}
