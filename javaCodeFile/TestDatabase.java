package mc.sn.day12;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class TestDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDatabase td =new TestDatabase();
		try {
			try {
				td.connectDB();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void connectDB() throws SQLException, ClassNotFoundException{
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id ="hr";
		String pw = "1234";
		Class.forName(driver);
		Connection con  = DriverManager.getConnection(jdbcURL,id,pw);
		if(con!=null) {
			System.out.println("connected");
			con.close();
		}
		else {
			System.out.println("fail");
		}
	}
}
