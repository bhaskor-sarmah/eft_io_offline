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
import offlineio.util.MySQLConnection;

/**
 *
 * @author Bhaskor
 */
public class LoginDao {

    public static boolean checkIfPinPresent() {
        boolean pin_found = false;
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
            ps = conn.prepareStatement("SELECT COUNT(*) FROM pin_master");
            System.out.println(ps);
            rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                pin_found = true;
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
        return pin_found;
    }
}
