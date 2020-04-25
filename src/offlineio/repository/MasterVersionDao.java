/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import offlineio.payload.request.MasterVersionForm;
import offlineio.payload.response.MasterVersion;
import offlineio.util.MySQLConnection;

/**
 *
 * @author Bhaskor
 */
public class MasterVersionDao {

    public static List<MasterVersionForm> saveMasterVersion(MasterVersion[] masterVersion) {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        boolean r = true;
        for (MasterVersion m : masterVersion) {
            PreparedStatement ps = null, ps1 = null;
            ResultSet rs = null;
            boolean found = false;
            try {
                int index = 1;
                ps = conn.prepareStatement("SELECT table_alias_name FROM master_table_status WHERE table_alias_name = ?");
                ps.setString(index++, m.getTableAliasName());
                System.out.println(ps);
                rs = ps.executeQuery();
                if (rs.next()) {
                    found = true;
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
            if (!found) {
                try {
                    int index = 1;
                    ps1 = conn.prepareStatement("INSERT INTO `master_table_status` \n"
                            + "	(`version_id`, \n"
                            + "	`table_alias_name`, \n"
                            + "	`table_name`, \n"
                            + "	`offline_version`, \n"
                            + "	`online_version`, \n"
                            + "	`updated_time`\n"
                            + "	)\n"
                            + "	VALUES\n"
                            + "	(?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	?, \n"
                            + "	NOW()\n"
                            + "	)");
                    ps1.setString(index++, m.getVersionId());
                    ps1.setString(index++, m.getTableAliasName());
                    ps1.setString(index++, m.getTableAliasName());
                    ps1.setString(index++, "0.1");
                    ps1.setString(index++, m.getVersion());
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
                    ps1 = conn.prepareStatement("UPDATE `master_table_status` SET `online_version`= ? WHERE table_alias_name = ?");
                    ps1.setString(index++, m.getVersion());
                    ps1.setString(index++, m.getTableAliasName());
                    System.out.println(ps1);
                    int res = ps1.executeUpdate();
                    if (res < 0 || res > 1) {
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

        if (!r) {
            return null;
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
        return getAllMasterVersionRequest();
    }

    public static List<MasterVersionForm> getAllMasterVersionRequest() {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MasterVersionForm> masterVersionList = new ArrayList<>();
        try {
            Gson gson = new GsonBuilder().create();
            ps = conn.prepareStatement("SELECT * FROM master_table_status");
            System.out.println(ps);
            rs = ps.executeQuery();

            while (rs.next()) {
                MasterVersionForm m = new MasterVersionForm();
                m.setTableAliasName(rs.getString("table_alias_name"));
                m.setVersion(rs.getString("offline_version"));
                masterVersionList.add(m);
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
        return masterVersionList;
    }

    public static List<MasterVersion> getAllMasterVersions() {
        Connection conn = null;
        MySQLConnection msconn = new MySQLConnection();
        try {
            conn = msconn.getMySQLConnection();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MasterVersion> masterVersionList = new ArrayList<>();
        try {
            Gson gson = new GsonBuilder().create();
            ps = conn.prepareStatement("SELECT * FROM master_table_status WHERE table_name <> \"pass\" ORDER BY table_name");
            System.out.println(ps);
            rs = ps.executeQuery();
            int counter = 0;
            while (rs.next()) {
                counter++;
                
                String regex = "([a-z])([A-Z]+)";
                String replacement = "$1_$2";
                
                MasterVersion m = new MasterVersion();
                
                m.setTableName(rs.getString("table_name").replaceAll(regex, replacement).toUpperCase().replaceAll("_", " ").replaceAll(" LIST", ""));
                switch (m.getTableName()) {
                    case "HC":
                        m.setTableName("HOLDING CENTER");
                        break;
                    case "FT":
                        m.setTableName("FOREIGNERS TRIBUNAL");
                        break;
                    case "DOC":
                        m.setTableName("DOCUMENT TYPE");
                        break;
                    default:
                        break;
                }
                m.setVersion(rs.getString("offline_version"));
                m.setIsActive("Y");
                m.setOfflineVersion(rs.getString("offline_version"));
                m.setVersion(rs.getString("online_version"));
                m.setVersionId(String.valueOf(counter));
                masterVersionList.add(m);
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
        return masterVersionList;
    }

    public static boolean updateAllOnlineVersion() {
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
            Gson gson = new GsonBuilder().create();
            ps = conn.prepareStatement("UPDATE master_table_status SET offline_version = online_version WHERE table_name <> \"villageList\"");
            System.out.println(ps);
            ps.executeUpdate();
            return true;
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
