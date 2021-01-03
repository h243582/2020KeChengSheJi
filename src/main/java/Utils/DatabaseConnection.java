package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC数据库连接工具类
 *
 * @author 何昱飞
 */
public class DatabaseConnection {
    //oracle.jdbc.driver.OracleDriver
    //jdbc:oracle:thin:@localhost:1521:MLDN
    private Connection conn = null;
    private Statement stat = null;
    private ResultSet rs = null;
    public DatabaseConnection(){
    }

    /**
     * 取得数据库连接对象
     *
     * @return 实例化的Connection对象，若返回null，则表示没连接成功
     */
    public Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        /* 配置文件 */
        Properties pro = new Properties();
       // InputStream inputStream = new FileInputStream("JDBC.properties");
        InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("JDBC.properties");
        pro.load(inputStream);
        inputStream.close();

        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName(driver);
        this.conn = DriverManager.getConnection(url, username, password);
        return this.conn;
    }

    /**
     * 关闭数据库连接
     */
    public void close() {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

}
