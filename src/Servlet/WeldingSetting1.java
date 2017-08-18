package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class WeldingSetting1
 */
@WebServlet("/WeldingSetting1")
public class WeldingSetting1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeldingSetting1() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    
            throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
 
        //癸Postいゅ把计秈︽秆絏
 
        request.setCharacterEncoding("UTF-8");
 
        //眔Ajax肚把计
 
        String userName = "123";
 
        ArrayList<String> ar = new ArrayList<String>();
        String s1 ="Test1";
        String s2 ="Test2";
        String s3 ="Test3";
        ar.add(s1);
        ar.add(s2);
        ar.add(s3);

        
        System.out.println(ar);
 
        //篶璶肚JSONン
        
        HashMap userInfoMap = new HashMap();
 
        userInfoMap.put("userName", userName);
 
        
 
        ArrayList userInterestList = new ArrayList();
 
        userInterestList.addAll(Arrays.asList(ar));
        System.out.println(userInterestList);
 
        userInfoMap.put("userInterest", userInterestList);
        System.out.println(userInfoMap);
        
 
        JSONObject responseJSONObject = new JSONObject(userInfoMap);
 
        
 
        PrintWriter out = response.getWriter();
 
        out.println(responseJSONObject);
 
    }
 
 
 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
 
    /**
 
     * Handles the HTTP <code>GET</code> method.
 
     *
 
     * @param request servlet request
 
     * @param response servlet response
 
     * @throws ServletException if a servlet-specific error occurs
 
     * @throws IOException if an I/O error occurs
 
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
