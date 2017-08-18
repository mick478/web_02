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

import Bean.MySQLBean; 
 
@WebServlet(urlPatterns = {"/doAjaxServlet.do"})

public class doAjaxServlet extends HttpServlet {
 
	public String logininfo; 
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
 
        //癸Postいゅ把计秈︽秆絏
 
        request.setCharacterEncoding("UTF-8");
 
        //眔Ajax肚把计
 
        /*String userName = "123";
 
        ArrayList<String> ar = new ArrayList<String>();
        String s1 ="Test1";
        String s2 ="Test2";
        String s3 ="Test3";
        ar.add(s1);
        ar.add(s2);
        ar.add(s3);

        
        System.out.println(ar);
 
        //篶璶肚JSONン*/
        
        
        String btout = request.getParameter("btout");
        String Account = request.getParameter("Account");
        System.out.println(Account);
        String Password = request.getParameter("Password");
        System.out.println(Password);
        String error1;
        if(Account.equals("123456") & Password.equals("123456")){
        	error1="";
        	logininfo="1";
        	try{
        		MySQLBean test = new MySQLBean(); 
        		test.connectMySQL();
        		test.updateTable("test_jspdb","loginstate","date","1","id","1");
        	}
         catch(Exception e) {out.print(e);}
        }
        else{
        	error1="Account or Password error";
        	logininfo="0";
        }
        HashMap userInfoMap = new HashMap();
        userInfoMap.put("error1", error1);	
        userInfoMap.put("logininfo", logininfo);	
        System.out.println(userInfoMap);
        
        /*ArrayList userInterestList = new ArrayList();
 
        userInterestList.addAll(Arrays.asList(ar));
        System.out.println(userInterestList);
 
        userInfoMap.put("userInterest", userInterestList);*/

        JSONObject responseJSONObject = new JSONObject(userInfoMap);

        
 
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
 
    @Override
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
 
            throws ServletException, IOException {
 
        processRequest(request, response);
 
    }
 
 
 
    /**
 
     * Handles the HTTP <code>POST</code> method.
 
     *
 
     * @param request servlet request
 
     * @param response servlet response
 
     * @throws ServletException if a servlet-specific error occurs
 
     * @throws IOException if an I/O error occurs
 
     */
 
    @Override
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
 
            throws ServletException, IOException {
 
        processRequest(request, response);
 
    }
 
 
 
    /**
 
     * Returns a short description of the servlet.
 
     *
 
     * @return a String containing servlet description
 
     */
 
    @Override
 
    public String getServletInfo() {
 
        return "Short description";
 
    }// </editor-fold>
 
 
 
}