package mc.sn.day14;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ReviewDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReviewDB db = new ReviewDB();
		db.testQuery2();
	}
	
	public Connection testConnectDB() throws SQLException, ClassNotFoundException {
		String URL = "Oracle.jdbc.OracleDriver";
		String driver = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "1234";
		
		Class.forName(URL);
		Connection con = DriverManager.getConnection(driver);
		if(con != null) {
			System.out.println("Connection!");
			
		}
		else {
			System.out.println("not Connection");
		}
		return con;
	}
	
	public void testQuery() throws SQLException, ClassNotFoundException {
		Connection con = this.testConnectDB();
		String sql ="INSERT INTO studentTBL VLASES()";
		String sql2 ="UPDATE studentTBL SET WHERE";
		String sql3 = "DELDETE FORM studentTBL WHERE ";
		Statement stmt = con.createStatement(); // ?new를 사용하지 않는 이유:
		int affectedCount =  stmt.executeUpdate(sql); //요청을 보낼떄 값을 전송
		if(affectedCount>0) {
		
		}
		else {
		
		}
	
	}

	public void testQuery2(){
		Connection con =null;
		PreparedStatement stmt = null;
		String sql ="INSERT INTO studentTBL VLASES(?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 ="UPDATE studentTBL SET WHERE";
		String sql3 = "DELDETE FORM studentTBL WHERE ";
		try {
			con = this.testConnectDB();
			stmt = con.prepareStatement(sql); // ?new를 사용하지 않는 이유:
			stmt.setInt(1,0);
			int affectedCount =  stmt.executeUpdate(sql); //요청을 보낼떄 값을 전송
			if(affectedCount>0) {
		
			}
			else {
			
			}
			
		}
		catch(ClassNotFoundException ce){
			
		}
		catch(SQLException se) {
			
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
