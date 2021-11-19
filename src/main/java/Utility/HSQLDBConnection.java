package Utility;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDBConnection {

    private static Logger Log = Logger.getLogger(HSQLDBConnection.class.getName());
    public static Connection con = null;
    public static Statement stmt = null;

    public void connectHSQLDB() throws ClassNotFoundException, SQLException {

        Class.forName("org.hsqldb.jdbcDriver");
        con = DriverManager.getConnection("jdbc:hsqldb:file:src/main/java/HSQLDB/sampledb", "SA", "");
        Log.info("Successfully connected to database.");

    }

    public void createTableIFNotExist() throws SQLException {

        stmt = con.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS eventtable (id VARCHAR(50) NOT NULL,duration bigint,type VARCHAR(20),host VARCHAR(20),alert BOOLEAN);");
        Log.info("Database table created/already existed.");

    }

    public void closeDBConnection() throws SQLException {

        con.close();
        Log.info("Database connection closed.");
    }
}
