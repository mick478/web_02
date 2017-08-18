package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import Bean.MySQLBean;
import Bean.WeldingNumber;
import Bean.ThreadBean;
/**
 * Servlet implementation class WeldingSetting
 */
@WebServlet("/WeldingSetting")
public class WeldingSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeldingSetting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String high = request.getParameter("width");
		String angle = request.getParameter("angle");
		
		
		WeldingNumber setting = new WeldingNumber();
		setting.setWN(high, angle);
		//---------------計算後總數
		HttpSession session = request.getSession();
		session.setAttribute("setting", setting);
		
		//---------------SQL讀值顯示
		//MySQLBean setting1 = new MySQLBean();
		//setting1.SelectTable("employee");
		//HttpSession session1 = request.getSession();
		//session1.setAttribute("setting1", setting1);
		//System.out.println("Close Exception 11:" +setting1.gets_name1());
		//---------------thread測試
		
		
		//System.out.println("Close Exception 12:" +thread.getid1());
		
		//---------------SQL械入
		/*int feet=setting.getWN();
		try{
		MySQLBean test = new MySQLBean(); 
		test.dropTable(); 
	    test.createTable(); 
		for (int i=1;i<feet;i++)
		{
			String s = Integer.toString(i);
			test.insertTable(s);
		}
		} catch(Exception e) {out.print(e);}*/
		
		 
		
		//ArrayList<Integer> sdb = new ArrayList<Integer>();
		
		//response.getWriter().append("Served at: "+feet).append(request.getContextPath());
		//request.setAttribute("sdb", sdb);
		response.sendRedirect("WeldingSetting1.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
