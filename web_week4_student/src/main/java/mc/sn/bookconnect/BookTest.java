package mc.sn.bookconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookTest {
	
   //��� �Ϲ� �ڹ� �����̶� ����X ��Ʈ�ѷ�X => ���̴� �̸��̾�
   public ArrayList<BookDTO> getBookList() throws SQLException, ClassNotFoundException{
      Connection con = this.getConnection();
      String sql = "select * from bookTBL";
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      ArrayList<BookDTO> list = new ArrayList<BookDTO>();
      BookDTO book = null;
      while(rs.next()) {
         book = new BookDTO(rs.getInt("isbn"),rs.getString("title"),rs.getString("author"),rs.getString("publisher"),rs.getInt("price"),rs.getString("description"));
         list.add(book);
      }
      rs.close();
      pstmt.close();
      con.close();
      
      return list;
   }
   
   public void printAllBooks() throws ClassNotFoundException, SQLException {
      
      Connection con = this.getConnection();
      String sql = "select * from bookTBL";
      PreparedStatement pstmt = con.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      ArrayList<BookDTO> list = new ArrayList<BookDTO>();
      BookDTO book = null;
      while(rs.next()) {
         book = new BookDTO(rs.getInt("isbn"),rs.getString("title"),rs.getString("author"),rs.getString("publisher"),rs.getInt("price"),rs.getString("description"));
         list.add(book);
      }
      rs.close();
      pstmt.close();
      con.close();
      System.out.println("-----------------------���� ���-------------------");
      for(BookDTO temp: list) {
         System.out.println(temp);
         //out.print();
      }
   }
   
   public Connection getConnection() throws ClassNotFoundException, SQLException {
      Connection con = null;
      String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
      String driver = "oracle.jdbc.OracleDriver";
      String id = "hr";
      String pwd = "1234";
      
      Class.forName(driver);
      con = DriverManager.getConnection(jdbcURL,id,pwd);
      
      return con;
   }

}