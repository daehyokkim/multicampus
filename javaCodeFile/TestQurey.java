package mc.sn.day14;

import java.sql.Statement;
import java.util.ArrayList;

import mc.sn.day13.StudentDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestQurey {
	
	private ArrayList<StudentDTO> list;
	public TestQurey() {
		list = new ArrayList<StudentDTO>();
	}
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestQurey tq = new TestQurey();
		try {
			//tq.query1();
			//tq.query2();
			//tq.query3();
			tq.query4();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//statement query���� �����Ǿ� ���(����������)
	// ������ �ݺ����� �ʰ� �������� �������� �ʿ��� �� ��� 
	//statement ��ü�� db�����ϴ� ���1
	public void query1() throws ClassNotFoundException, SQLException {
		Connection con = this.getConnection();
		String sql = "INSERT INTO testTBL2(id,userName,age)"
				+ "values (4,'kim',20)";
		sql= "UPDATE testTBL2 SET userName = 'han' WHERE userName ='kim'";
	
		sql="DELETE FROM testTBL2 WHERE userName = 'jan'";
	
		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql); //insert,update,delete�� ���
		if(affectedCount>0) {
			System.out.print("success");
		}
		else {
			System.out.print("false");
					
		}
		stmt.close();
		con.close();
	}

	//csv���� �����͸� �о�� statement ��ü�� db�����ϴ� ���2
	public void query2() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		this.makeGisaData();
		System.out.println(list.size());
		Connection con = this.getConnection();
		String sql = null;
		StudentDTO dto = list.get(0);

			sql = "INSERT INTO gisaTBL VALUES(";
			StringBuffer sb = new StringBuffer(sql);
			sb.append(dto.getStdNo()+",'");
			sb.append(dto.getEmail()+"',");
			sb.append(dto.getKor()+",");
			sb.append(dto.getEng()+",");
			sb.append(dto.getMath()+",");
			sb.append(dto.getSci()+",");
			sb.append(dto.getHist()+",");
			sb.append(dto.getTotal()+",'");
			sb.append(dto.getMgrCode()+"','");
			sb.append(dto.getAccPoint()+"','");
			sb.append(dto.getLocalCode()+"')");
			sql = sb.toString();
			System.out.println(sql);
			Statement stmt = con.createStatement();
			int affectedCount = stmt.executeUpdate(sql);
			if(affectedCount>0) {
				System.out.print("success");
			}
			else {
				System.out.print("false");
				
						
			}
		stmt.close();
		con.close();
		
	}
	
	//
	//cvs ���� �����͸� �о�ͼ�  PreparedStatement ��ü�� db����
	public void query3() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		this.makeGisaData();
		Connection con = this.getConnection();
		String sql = "INSERT INTO gisaTBL VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql); //���� ó�� ��θ� ����� sql���� ó��
		int affectedCount = 0;
		ArrayList<StudentDTO> falseList = new ArrayList<StudentDTO>();
		for(StudentDTO dto : list) {
			pstmt.setInt(1, dto.getStdNo());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMath());
			pstmt.setInt(6, dto.getSci());
			pstmt.setInt(7, dto.getHist());
			pstmt.setInt(8, dto.getTotal());
			pstmt.setString(9, dto.getMgrCode());
			pstmt.setString(10, dto.getAccPoint());
			pstmt.setString(11, dto.getLocalCode());
			affectedCount = pstmt.executeUpdate(); //���̺� ������ �ִ� ��ɾ��(insert,update,delete) ���
													// pstmt.executeQuery() --> select�� ���� Ȱ��
			if(affectedCount<=0) {
				falseList.add(dto);
		
			}
		
				
		}
			for(StudentDTO dto : falseList) {
				System.out.println(dto.getStdNo()+"�� �߰� ���� �ʾҽ��ϴ�.");
			}
			
		pstmt.close();
		con.close();

	}
	
	public void query4() throws ClassNotFoundException, SQLException {
		String sql = "select max(kor+eng) from gisaTBL where localCode = ?";
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "B");
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {	
			System.out.println("�ִ��� "+rs.getInt(1)+" �Դϴ�.");
		}
		rs.close();
		pstmt.close();
		con.close();
	}
	
	//Oracle�� �����ϴ� �����ͺ��̽��� �����ϴ� �޼���
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.OracleDriver";
		String id="hr";
		String pwd="1234";
		Class.forName(driver);
	
		Connection con = DriverManager.getConnection(jdbcURL,id,pwd); 
		if(con!=null) {
			System.out.println("DB connect success");
		}
		else {
			System.out.println("DB connect fail");
		}
		return con;

	}

	
	   public void printAnswer(int number,int answer) throws IOException{
		   String fileName = "Ans"+number+".txt";
		   File file = new File(fileName);
		   FileWriter fw = new FileWriter(file);
		   PrintWriter pw = new PrintWriter(fw);
		   pw.println(answer);
		   pw.close();
		   fw.close();
	   }
	   
	   //��� ������ ������ �о� LIST�� �����ϴ� �޼���
	   public void makeGisaData() throws NumberFormatException, IOException {
	      //���Ͽ� �����ؼ� �ش� ���� �о�ͼ� �Ʒ��� ���� �и��ؼ� ����Ʈ ����
	      //���ʸ�
	      File file = new File("data\\Abc1115.csv");
	      
	      if(file.exists()) {
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr); //�ۼ��� IOException �߻�����
	         String line = null;
	         while((line = br.readLine()) != null) {
	            String temp = line;//"990001,addx, 17,29,16,49,43,154,C,A,C";
	            String[] data = temp.split(",");
	            StudentDTO dto = new StudentDTO();
	            int i = Integer.parseInt(data[0]);
	            dto.setStdNo(i);
	            dto.setEmail(data[1]);
	            i = Integer.parseInt(data[2].trim());//���⸦ �ڵ����� ó��.
	            dto.setKor(i);
	            dto.setEng(Integer.parseInt(data[3].trim()));
	            dto.setMath(Integer.parseInt(data[4].trim()));
	            dto.setSci(Integer.parseInt(data[5].trim()));
	            dto.setHist(Integer.parseInt(data[6].trim()));
	            dto.setTotal(Integer.parseInt(data[7].trim()));
	            dto.setMgrCode(data[8]);
	            dto.setAccPoint(data[9]);
	            dto.setLocalCode(data[10]);
	            list.add(dto);
	            System.out.println(line);
	         }
	         br.close();
	         fr.close();
	      }
	   }

	
}
