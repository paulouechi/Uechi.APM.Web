/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.monitor;

import br.com.uechi.util.propriedades;
import br.com.uechi.util.constantes;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.uechi
 */
@WebServlet(name = "main", loadOnStartup = 1, urlPatterns = {"/main"})
public class main extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet Custom methods. Click on the + sign on the left to edit the code.">
    
    protected void doLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            constantes.strPROPERTIES_FILE = "data.properties";
            if (request.getParameter("btnAction").equals("regSalvar")) {
                goManager(1, request, response);
            }
        } catch (Exception e) {
        } finally {
            goManager(0, request, response);
        }
    }

    protected void goManager(int intAct, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        propriedades objPrp = new propriedades();
        File objFilProp;
        String strCaminho;
        try {
            //objFilProp = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            //strCaminho =  objFilProp.getPath().replace("monitor/main.class", "");
            strCaminho = objPrp.configuracao(1, "Parametros");
            String strCombos = "";
            String striptChave = "";
            String striptPorta = "";
            String striptServidores = "";
            String strselMaximoPagina = "";
            String strselAtualizar = "";
            String strselAltCPU = "";
            String strselAltMEM = "";
            String strselAltDSK = "";
            String strselErrCPU = "";
            String strselErrMEM = "";
            String strselErrDSK = "";
            if (intAct == 0){
                // Carrega
                striptChave = objPrp.Leitura(strCaminho, "Chave");
                striptPorta = objPrp.Leitura(strCaminho, "Porta");
                striptServidores = objPrp.Leitura(strCaminho, "Servidores");
                strselMaximoPagina = objPrp.Leitura(strCaminho, "MaximoPagina");
                strselAtualizar = objPrp.Leitura(strCaminho, "Atualizar");
                strselAltCPU = objPrp.Leitura(strCaminho, "altCPU");
                strselAltMEM = objPrp.Leitura(strCaminho, "altMEM");
                strselAltDSK = objPrp.Leitura(strCaminho, "altDSK");
                strselErrCPU = objPrp.Leitura(strCaminho, "errCPU");
                strselErrMEM = objPrp.Leitura(strCaminho, "errMEM");
                strselErrDSK = objPrp.Leitura(strCaminho, "errDSK");
                // Seta
                strCombos += "comboSelect('selMaxPagina'," + strselMaximoPagina + ");";
                strCombos += "comboSelect('selAtualizar'," + strselAtualizar + ");";
                strCombos += "comboSelect('selAltCPU'," + strselAltCPU + ");";
                strCombos += "comboSelect('selAltMEM'," + strselAltMEM + ");";
                strCombos += "comboSelect('selAltDSK'," + strselAltDSK + ");";
                strCombos += "comboSelect('selErrCPU'," + strselErrCPU + ");";
                strCombos += "comboSelect('selErrMEM'," + strselErrMEM + ");";
                strCombos += "comboSelect('selErrDSK'," + strselErrDSK + ");";
                request.setAttribute("iptChave", striptChave);
                request.setAttribute("iptPorta", striptPorta);
                request.setAttribute("iptServidores", striptServidores);
                request.setAttribute("customDOM", "<script type='text/javascript'>" + strCombos + "</script>");
            }
            if (intAct == 1){
                // Carrega
                striptChave = request.getParameter("iptChave");
                striptPorta = request.getParameter("iptPorta");
                striptServidores = request.getParameter("iptServidores");
                strselMaximoPagina = request.getParameter("selMaxPagina");
                strselAtualizar = request.getParameter("selAtualizar");
                strselAltCPU = request.getParameter("selAltCPU");
                strselAltMEM = request.getParameter("selAltMEM");
                strselAltDSK = request.getParameter("selAltDSK");
                strselErrCPU = request.getParameter("selErrCPU");
                strselErrMEM = request.getParameter("selErrMEM");
                strselErrDSK = request.getParameter("selErrDSK");
                // Atualizar
                if (objPrp.Gravar(strCaminho, "Chave", striptChave) &&
                    objPrp.Gravar(strCaminho, "Porta", striptPorta) &&
                    objPrp.Gravar(strCaminho, "Servidores", striptServidores) &&
                    objPrp.Gravar(strCaminho, "MaximoPagina", strselMaximoPagina) &&
                    objPrp.Gravar(strCaminho, "Atualizar", strselAtualizar) &&
                    objPrp.Gravar(strCaminho, "altCPU", strselAltCPU) &&
                    objPrp.Gravar(strCaminho, "altMEM", strselAltMEM) &&
                    objPrp.Gravar(strCaminho, "altDSK", strselAltDSK) &&
                    objPrp.Gravar(strCaminho, "errCPU", strselErrCPU) &&
                    objPrp.Gravar(strCaminho, "errMEM", strselErrMEM) &&
                    objPrp.Gravar(strCaminho, "errDSK", strselErrDSK)){
                    //request.setAttribute("customDOMMSG", "Configurações salvas com sucesso.");
                }
            }
        } catch (Exception e) {
            //request.setAttribute("customDOMMSG", "Falha ao atualizar, tente novamente.");
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
