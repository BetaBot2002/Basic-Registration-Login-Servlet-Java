import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	public static boolean insert(User user) {
		Connection connect=DBconnection.getConnnection();
		try {
			PreparedStatement query=connect.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?)");
			query.setString(1, user.getName());
			query.setString(2, user.getPhone());
			query.setString(3, user.getDOB());
			query.setString(4, user.getEmail());
			query.setString(5, user.getPassword());
			int result=query.executeUpdate();
			if(result>0) {
				connect.close();
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean authenticate(String Email, String Password) {
		Connection connect=DBconnection.getConnnection();
		try {
			PreparedStatement query=connect.prepareStatement("SELECT Password FROM USERS WHERE Email=?");
			query.setString(1, Email);
			ResultSet result=query.executeQuery();
			if(result.next()) {
				String authPass=result.getString(1);
				if(authPass.equals(Password)) {
					connect.close();
					return true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getUser(String Email) {
		Connection connect=DBconnection.getConnnection();
		try {
			PreparedStatement query=connect.prepareStatement("SELECT * FROM USERS WHERE Email=?");
			query.setString(1, Email);
			ResultSet result=query.executeQuery();
			if(result.next()) {
				String Name=result.getString("Name");
				connect.close();
				return Name;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
