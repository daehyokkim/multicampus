package mc.sn.bookconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HrDAO {
	public String selectJobs() throws SQLException, ClassNotFoundException {
		String line = null;
		String sql = "select * from jobs";
		BookTest bt = new BookTest();
		Connection con = bt.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			line = rs.getString(1)+","+rs.getString(2);
			break;
		}
		rs.close();
		st.close();
		con.close();
		return line;
	}

}
