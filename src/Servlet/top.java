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
 
@WebServlet(urlPatterns = {"/top.do"})

public class top extends HttpServlet {
 
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        MySQLBean test = new MySQLBean(); 
        test.connectMySQL();
        test.SelectTable("test_jspdb","loginstate");
        //test.dropTable(); 
        //test.createTable(); 
        //String table="employee";
        //test.insertTable(table, "2", "0"); 
        System.out.println("print1: "+request.getSession().getId());
        
        //test.update();
        String rs=test.gets_name1();
       
        HashMap userInfoMap = new HashMap();
        userInfoMap.put("rs", rs);	
	
        //System.out.println(rs);
        
        

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