package offlineio.util;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {

    
    private static GenericObjectPool connectionPool = null;
    private static DataSource dataSource = null;

    public MySQLConnection() {
        if (dataSource == null) {
            try {
                dataSource = setUp();
            } catch (Exception ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static DataSource setUp() throws Exception {
        //
        // Load JDBC Driver class.
        //
        Class.forName(AppSettings.DRIVER).newInstance();

        //
        // Creates an instance of GenericObjectPool that holds our
        // pool of connections object.
        //
        connectionPool = new GenericObjectPool();
        connectionPool.setMaxActive(AppSettings.MAX_CONNECTION);

        //
        // Creates a connection factory object which will be use by
        // the pool to create the connection object. We passes the
        // JDBC url info, username and password.
        //
        ConnectionFactory cf = new DriverManagerConnectionFactory(
                AppSettings.URL,
                AppSettings.USERNAME,
                AppSettings.PASSWORD);

        //
        // Creates a PoolableConnectionFactory that will wraps the
        // connection object created by the ConnectionFactory to add
        // object pooling functionality.
        //
        PoolableConnectionFactory pcf
                = new PoolableConnectionFactory(cf, connectionPool,
                        null, null, false, true);
        return new PoolingDataSource(connectionPool);
    }

    public GenericObjectPool getConnectionPool() {
        return connectionPool;
    }

    public Connection getMySQLConnection() throws Exception {
        printStatus();
        Connection conn = null;
        conn = dataSource.getConnection();
        printStatus();
        return conn;
    }

    /**
     * Prints connection pool status.
     */
    private void printStatus() {
        System.out.println("Max   : " + getConnectionPool().getMaxActive() + "; "
                + "Active: " + getConnectionPool().getNumActive() + "; "
                + "Idle  : " + getConnectionPool().getNumIdle());
    }
}
