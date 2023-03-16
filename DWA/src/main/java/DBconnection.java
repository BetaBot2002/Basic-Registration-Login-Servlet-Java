import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static final String drivername="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/servlet";
	private static final String username="root";
	private static final String password="";
	
	public static Connection getConnnection() {
		Connection connect=null;
		try {
			Class.forName(drivername);
			connect=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}
}
