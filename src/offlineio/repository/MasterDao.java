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
import java.util.ArrayList;
import java.util.List;
import offlineio.payload.response.DocumentModel;
import offlineio.payload.response.KeyValuePair;
import offlineio.util.MySQLConnection;

/**
 *
 * @author Bhaskor
 */
public class MasterDao {

    public List<KeyValuePair> getVillageList(String thana_code) {
        List<KeyValuePair> villList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT village_code,village_name FROM master_village WHERE thana_code = ? ORDER BY village_name");
            ps.setString(index++, thana_code);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                villList.add(k);
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
        return villList;
    }

    public List<KeyValuePair> getRelationList() {
        List<KeyValuePair> relList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT relation_code,relation_name FROM master_relation ORDER BY relation_name");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                relList.add(k);
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
        return relList;
    }

    public String getDistrictCodeByThana(String thana_code) {
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
            ps = conn.prepareStatement("SELECT district_code FROM master_thana WHERE thana_code = ?");
            ps.setString(index++, thana_code);
            System.out.println(ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
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
        return "";
    }

    public List<KeyValuePair> getOccupationList() {
        List<KeyValuePair> occupationList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT occupation_code,occupation_name FROM master_occupation");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                occupationList.add(k);
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
        return occupationList;
    }

    public List<KeyValuePair> getImmigrationList() {
        List<KeyValuePair> immigrationList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT route_code,route_name FROM master_route");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                immigrationList.add(k);
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
        return immigrationList;
    }

    public List<KeyValuePair> getEmpTypeList() {
        List<KeyValuePair> empTypeList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT employment_type_code,employment_type_name FROM master_employment_type");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                empTypeList.add(k);
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
        return empTypeList;
    }

    public List<KeyValuePair> getDocTypeList() {
        List<KeyValuePair> docList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT document_code,document_name FROM master_document ORDER BY document_name");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                docList.add(k);
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
        return docList;
    }

    public List<KeyValuePair> getStateList() {
        List<KeyValuePair> stateList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT state_code,state_name FROM master_state WHERE state_code NOT IN (\"00\",\"99\") ORDER BY state_name");
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                stateList.add(k);
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
        return stateList;
    }
    
    public List<KeyValuePair> getDistrictList(String stateCode) {
        List<KeyValuePair> distList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT district_code,district_name FROM master_district WHERE state_code = ? ORDER BY district_name");
            ps.setString(1, stateCode);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                distList.add(k);
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
        return distList;
    }
    
    public List<KeyValuePair> getThanaList(String distCode) {
        List<KeyValuePair> thanaList = new ArrayList<>();

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
            ps = conn.prepareStatement("SELECT thana_code,thana_name FROM master_thana WHERE district_code = ? ORDER BY thana_name");
            ps.setString(1, distCode);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                KeyValuePair k = new KeyValuePair(rs.getString(1), rs.getString(2));
                thanaList.add(k);
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
        return thanaList;
    }
    
}
