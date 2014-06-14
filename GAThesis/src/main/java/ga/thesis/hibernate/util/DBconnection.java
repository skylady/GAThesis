package ga.thesis.hibernate.util;

/**
 * Created by sky_lady on 6/14/14.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBconnection {

    public static Connection getConn() {

        Connection conn = null;

        String url = "jdbc:mysql://localhost:33066/";
        String db = "users";
        String driver = "com.mysql.jdbc.Driver";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "UTF-8");

        url = url + db;

        try {

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, properties);

        } catch (Exception e) {

            // error
            System.err.println("Mysql Connection Error: ");

            // for debugging error
            e.printStackTrace();
        }

        if (conn == null) {
            System.out.println("~~~~~~~~~~ can't get a Mysql connection");
        } else
            System.out.println("Connection established!");
        return conn;
    }
}
