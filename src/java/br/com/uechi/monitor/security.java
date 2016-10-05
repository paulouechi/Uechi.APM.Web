/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.monitor;

import br.com.uechi.util.propriedades;
import br.com.uechi.util.constantes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo.uechi
 */
public class security extends HttpServlet {

    private static String strArquivoParametro;
    
    protected static void goPostBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String strGetURL = request.getServletPath();
            String strPutURL = "";
            if (strGetURL.equals("/login") || strGetURL.equals("/login.do")) {
                strPutURL = request.getServletPath().replace(".do", "") + ".jsp";
            } else if (strGetURL.equals("/index") || strGetURL.equals("/index.do")) {
                strPutURL = request.getServletPath().replace(".do", "") + ".jsp";
            } else if (strGetURL.equals("/request") || strGetURL.equals("/request.do")) {
                strPutURL = request.getServletPath().replace(".do", "") + ".jsp";
            } else if (strGetURL.equals("/register") || strGetURL.equals("/register.do")) {
                strPutURL = request.getServletPath().replace(".do", "") + ".jsp";
            } else {
                strPutURL = "/WEB-INF/pages" + request.getServletPath().replace(".do", "") + ".jsp";
            }
            request.getRequestDispatcher(strPutURL).forward(request, response);
        } catch (Exception e) {
        }
    }

    protected static void goServlet(HttpServletRequest request, HttpServletResponse response, String strPutURL) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.sendRedirect(request.getContextPath() + strPutURL);
        } catch (Exception e) {
        }
    }

    public static String goInvoke(HttpServletRequest request, HttpServletResponse response, String strPage) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String strURL = "";
        String strTime = "";
        String strTotal = "";
        String strPagina = "";
        constantes.strPROPERTIES_FILE = "data.properties";
        propriedades objPrp = new propriedades();
        strArquivoParametro = objPrp.configuracao(1, "Parametros");
        try {
            strPagina = objPrp.Leitura(strArquivoParametro, "MaximoPagina");
        } catch (Exception e) {
            strPagina = "0";
        }
        try {
            strTime = objPrp.Leitura(strArquivoParametro, "Atualizar");
        } catch (Exception e) {
            strTime = "60";
        }
        try {
            strTotal = String.valueOf(objPrp.Leitura(strArquivoParametro, "Servidores").split(",").length);
        } catch (Exception e) {
            strTotal = "0";
        }
        try {
            if (strPage.equals("monitor")){
                strURL = "/" + strPage + "?t=" + strTime + "&c=0&p=" + strPagina + "&s=" + strTotal;
            }
            strURL = request.getContextPath() + strURL;
        } catch (Exception e) {
        }
        return strURL;
    }

}
