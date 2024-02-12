package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

//Using hikaricp Configuration for connection pooling
public class JdbcUtil {
	
	private JdbcUtil() {
		
	}
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static Connection getConnection() throws SQLException, IOException {
//		HikariConfig config  = new HikariConfig("src\\in\\ineuron\\properties\\db.properties");
//		HikariDataSource dataSource = new HikariDataSource(config);
//	    Connection con = dataSource.getConnection();
		
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		
		dataSource.setUrl("jdbc:mysql://localhost:3306/projects");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
    	//logical connection bought from connection pool
		Connection con = dataSource.getConnection();
		System.out.println("con imple class is ::"+con.getClass().getName());
		return con;
		
		
	}
	
	@SuppressWarnings("unused")
	public static Connection physicalConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream("src\\in\\ineuron\\properties\\db.properties");
		Properties props = new Properties();
		props.load(fis);
		String url = props.getProperty("url");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
		
	}
}
