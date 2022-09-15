/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;


/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
//        processRequest(request, response);
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String save = request.getParameter("savelogin");
            AccountDAO dao = new AccountDAO();
            Account acc = null;
            try {
                if(email == null || email.equals("") || password == null || password.equals("")){
                    Cookie[] c = request.getCookies();
                    String token = "";
                    if(c != null){
                        for(Cookie aCookie : c){
                            if(aCookie.getName().equals("selector")){
                                token = aCookie.getValue();
                            }
                        }
                    }
                    if(!token.equals("")){
                        response.sendRedirect("personalPage.jsp");
                    }
                    else{
                        response.sendRedirect("errorpage.html");
                    }
                }
                else{
                    acc = dao.getAll(email, password);
                    if(acc != null){
                        //admin
                        if(acc.getRole() == 1){
                            //chuyen qua admin homepage
                            HttpSession session = request.getSession(true);
                            session.setAttribute("name", acc.getFullname());
                            session.setAttribute("email", email);
                            //create a cookie and attach it to reponse object
                            if(save != null){
                                String token = "ABC123";
                                    dao.updateToken(token, email);
                                    Cookie cookie = new Cookie("selector", token);
                                    cookie.setMaxAge(60 * 2);//this is a sample
                                    response.addCookie(cookie);
                            }
                            response.sendRedirect("AdminIndex.jsp");
                        }//user
                        else{
                            //chuyen qua welcomepage
                            //response.sendRedirect("welcome.html");
                            HttpSession session = request.getSession(true);
                            if(session != null){
                                session.setAttribute("name", acc.getFullname());
                                session.setAttribute("email", email);
                               
                                //create a cookie and attack it to reponse object
                                if(save != null){
                                    String token = "ABC123";
                                    dao.updateToken(token, email);
                                    Cookie cookie = new Cookie("selector", token);
                                    cookie.setMaxAge(60 * 2);//this is a sample
                                    response.addCookie(cookie);
                                }
                                response.sendRedirect("personalPage.jsp");
                            }
                        }
                    }
                    else{
                        response.sendRedirect("Invalid.jsp");
                    }
                }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
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
