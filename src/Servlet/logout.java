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
 
@WebServlet(urlPatterns = {"/logout.do"})

public class logout extends HttpServlet {
 
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 
            throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        MySQLBean test = new MySQLBean(); 
        test.connectMySQL();
        test.updateTable("test_jspdb","loginstate","date","0","id","1");
       
        
        
	
        
        
        

        //JSONObject responseJSONObject = new JSONObject(userInfoMap);

        //PrintWriter out = response.getWriter();
 
        //out.println(responseJSONObject);
 
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