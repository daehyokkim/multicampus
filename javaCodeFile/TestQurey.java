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
	
	//statement query문이 고정되어 사용(고정쿼리문)
	// 쿼리가 반복되지 않고 고정적인 쿼리문이 필요할 떄 사용 
	//statement 객체로 db접근하는 방법1
	public void query1() throws ClassNotFoundException, SQLException {
		Connection con = this.getConnection();
		String sql = "INSERT INTO testTBL2(id,userName,age)"
				+ "values (4,'kim',20)";
		sql= "UPDATE testTBL2 SET userName = 'han' WHERE userName ='kim'";
	
		sql="DELETE FROM testTBL2 WHERE userName = 'jan'";
	
		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql); //insert,update,delete시 사용
		if(affectedCount>0) {
			System.out.print("success");
		}
		else {
			System.out.print("false");
					
		}
		stmt.close();
		con.close();
	}

	//csv파일 데이터를 읽어와 statement 객체로 db접근하는 방법2
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
	//cvs 파일 데이터를 읽어와서  PreparedStatement 객체로 db연동
	public void query3() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		this.makeGisaData();
		Connection con = this.getConnection();
		String sql = "INSERT INTO gisaTBL VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql); //전용 처리 통로를 만들어 sql문을 처리
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
			affectedCount = pstmt.executeUpdate(); //테이블에 영향을 주는 명령어들(insert,update,delete) 사용
													// pstmt.executeQuery() --> select문 사용시 활용
			if(affectedCount<=0) {
				falseList.add(dto);
		
			}
		
				
		}
			for(StudentDTO dto : falseList) {
				System.out.println(dto.getStdNo()+"가 추가 되지 않았습니다.");
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
			System.out.println("최댓값은 "+rs.getInt(1)+" 입니다.");
		}
		rs.close();
		pstmt.close();
		con.close();
	}
	
	//Oracle에 존재하는 데이터베이스를 접근하는 메서드
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
	   
	   //기사 데이터 파일을 읽어 LIST에 저장하는 메서드
	   public void makeGisaData() throws NumberFormatException, IOException {
	      //파일에 접속해서 해당 라인 읽어와서 아래와 같이 분리해서 리스트 저장
	      //제너릭
	      File file = new File("data\\Abc1115.csv");
	      
	      if(file.exists()) {
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr); //작성시 IOException 발생가능
	         String line = null;
	         while((line = br.readLine()) != null) {
	            String temp = line;//"990001,addx, 17,29,16,49,43,154,C,A,C";
	            String[] data = temp.split(",");
	            StudentDTO dto = new StudentDTO();
	            int i = Integer.parseInt(data[0]);
	            dto.setStdNo(i);
	            dto.setEmail(data[1]);
	            i = Integer.parseInt(data[2].trim());//띄어쓰기를 자동으로 처리.
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
