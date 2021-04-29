package mc.sn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mc.sn.bookconnect.HrDAO;

public class First_Servlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		resp.setContentType("text/htnl");
		//스트림을 얻어오는 것
		PrintWriter out = resp.getWriter();
//        out.print("<html>");
//        out.print("<h1>Welcome! Servlet! test_servlet</h1>");
//        out.print("</html>");
//		
//        BookTest bt = new BookTest();
//       Connection con;
		//HR 유저가 가지공 있는 jobs에 대한 정보를 호출해보기
		try {
			//서블릿에서 직접 구하는게 아닌 DAO를 생성해서 출력!!
			HrDAO dao = new HrDAO();
			String line = dao.selectJobs();
			out.print(line);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}

}
