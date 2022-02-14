/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Test;

/**
 *
 * @author ADMIN
 */
public class TestServlet extends HttpServlet {

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
            
            String apikey = request.getParameter("apikey");
            String player = request.getParameter("player");
            
            Test test = new Test();
            if (apikey.isBlank() || player.isBlank()) {
                response.sendRedirect("home.jsp");
            } else
                test.setAPIKey(apikey);
            
            if ("Summer".equalsIgnoreCase(player)) {
                test.setPUUID("qS91PLDTzQBzFc_GnzMXN3Qdk6bcgGyTIkGO9nqdPZwR_gIaa0n83-u1e391-Dfr2mXch45_nViLlw");
            }
            if ("Sunny".equalsIgnoreCase(player)) {
                test.setPUUID("DCG6b1eecpeUTI5jhhx0gnMCyGiHxx4zZAbA4OFj7esK7pM9xksw32d2yMRT4ZZS5xCBIYJpQ6tUTg");
            }
            if ("Jett".equalsIgnoreCase(player)) {
                test.setPUUID("XOZTG_qtZvMG0dw2c0mvkrlJFjqpCBqQGyBlE-qbIfZMq2Q8nuuMTsuhNX7oK7Fx2lyse3f8eE88Eg");
            }
            if ("NoAtz".equalsIgnoreCase(player)) {
                test.setPUUID("1mCah76icxHULcMZwpJQKyElIG6zS6YNuvX0ghsmu3w8B5L1brZyCqehPngwj1gW8PiCG6rZggRdwA");
            }
            if ("Killer".equalsIgnoreCase(player)) {
                test.setPUUID("ADVPrbcte3DOa296LeBSxpHQDiL5P95RiLyfb8f6FWoJMtLOpoIrbf39BZ-yrTOXDB0pfE0G_8FhMQ");
            }
            if ("Bunzz".equalsIgnoreCase(player)) {
                test.setPUUID("PPAF7nLGTu-73BpfNZt_Ce7rfqP_JahtNL85Zmde5-rjk3JThq0quwR_qwwnWiXKo75K06Da0NPocQ");
            }
            
            request.setAttribute("summonerName", test.getSummonerName());
            request.setAttribute("rank", test.getRank());
            request.setAttribute("wins", test.getWins());
            request.setAttribute("losses", test.getLosses());
            request.setAttribute("points", test.getPoints());
            request.getRequestDispatcher("Info.jsp").forward(request, response);
        } catch(Exception e){
            response.sendRedirect("home.jsp");
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
