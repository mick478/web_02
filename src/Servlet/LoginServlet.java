package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String TEST_USER = "123456";
	private String TEST_PWD = "123456";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error="";
		String Account = request.getParameter("Account");
		String Password = request.getParameter("Password");
		
        
		if(TEST_USER.equals(Account) && TEST_PWD.equals(Password))
		{
			response.sendRedirect("WeldingSetting.jsp");
		}
		else
		{
			error="Account or Password error";
			//out.print(error);
	        //out.flush();
	        //out.close();
			request.setAttribute("message", error);
			request.getRequestDispatcher("").forward(request, response);
	        //response.sendRedirect("");
		}
		
	}

}
