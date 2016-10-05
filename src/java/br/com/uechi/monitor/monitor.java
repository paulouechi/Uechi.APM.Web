/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.monitor;

import br.com.uechi.util.tratar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo.uechi
 */
@WebServlet(name = "monitor", urlPatterns = {"/monitor"})
public class monitor extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet Custom methods. Click on the + sign on the left to edit the code.">
    
    protected void doLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String strConta;
        int intConta;
        try {
            strConta = request.getParameter("c");
            if (strConta == null){
                intConta = 0;
            } else {
                intConta = tratar.ToIntDBNull(strConta);
            }
        } catch (Exception e) {
            intConta = 0;
        }
        try {
            communicator objCOM = new communicator();
            //Teste Simulado
            //request.setAttribute("customDOMMonitor", objCOM.SimulatorMountScreen(intConta));
            //Conecta Servidores
            request.setAttribute("customDOMMonitor", objCOM.MountScreen(intConta));
        } catch (Exception e) {
            session.invalidate();
        } finally {
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doLoad(request, response);
        security.goPostBack(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }

    // </editor-fold>

}
