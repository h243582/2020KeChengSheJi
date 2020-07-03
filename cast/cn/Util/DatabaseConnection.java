package cn.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC数据库连接工具类
 * @author 何昱飞
 *
 */
public class DatabaseConnection {
	//oracle.jdbc.driver.OracleDriver
	//jdbc:oracle:thin:@localhost:1521:MLDN
	private Connection conn = null;
	private Statement stat = null;
	private ResultSet rs = null;
	/**
	 * 构造方法返回Connection对象
	 */
	public DatabaseConnection() {
		try {
			Class.forName(Constant.DBDRIVER);
			this.conn = DriverManager.getConnection(Constant.DBURL,Constant.DBUSER,Constant.PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 取得数据库连接对象
	 * 
	 * @return 实例化的Connection对象，若返回null，则表示没连接成功
	 */
	public Connection getConnection(){
		return this.conn;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void close() {
		if(stat!= null) {
			try {
				stat.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		if(rs!= null) {
			try {
				rs.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		if(conn!= null) {
			try {
				conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	}
}