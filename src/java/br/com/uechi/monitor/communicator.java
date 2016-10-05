/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.monitor;

import br.com.uechi.util.tratar;
import br.com.uechi.util.propriedades;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author paulo.uechi
 */
public class communicator {

    private static Socket socket;
    private String strArquivoParametro;
    private propriedades objPrp = new propriedades();
    private String strServidores;
    private String strChave;
    private int intPorta;
    private int intTotal;
    private int intPagina;

    private String strDadosServidor;
    private String strDadosCPU;
    private String strDadosMemoria;
    private String strDadosDisco;
    private String strDadosRede;

    private String strCPU;
    private String strMEM;
    private String strDSKT;
    private String strDSKU;
    private String strDSKIT;
    private String strDSKIU;
    private String strNETR;
    private String strNETT;
    private String strSRV;

    public String[] strInfoServidor;
    public String[] strInfoCPU;
    public String[] strInfoMemoria;
    public String[] strInfoDisco;
    public String[] strInfoRede;

    public String MountScreen(int intConta) {
        String strHTML = "";
        String strCor = "";
        try {
            int intHTMLCnt = 0;
            int intSRVCnt = 0;
            double dobCalc = 0;
            String strJavaScript = "";
            String strServidor = "";
            String strGauge = "";
            String strMemoria = "";
            String strDisco = "";
            String strVarDisco = "";
            String strDiscoLivre = "";
            String strDiscoUsado = "";
            String strRedeRX = "";
            String strRedeTX = "";
            String strRedeTRX = "";
            String strRedeTTX = "";
            String strPlataforma = "";
            int intAltCPU = 0;
            int intAltMEM = 0;
            int intAltDSK = 0;
            int intErrCPU = 0;
            int intErrMEM = 0;
            int intErrDSK = 0;
            int intCPU = 0;
            int intMEM = 0;
            double dobLivDSK = 0;
            double dobUsuDSK = 0;
            double dobAltDSK = 0;
            double dobErrDSK = 0;
            strArquivoParametro = objPrp.configuracao(1, "Parametros");
            intPorta = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "Porta"));
            strServidores = tratar.ToStringDBNull(objPrp.Leitura(strArquivoParametro, "Servidores"));
            strChave = objPrp.Leitura(strArquivoParametro, "Chave");
            intPagina = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "MaximoPagina"));
            intTotal = strServidores.split(",").length;
            String[] strConnectServidores = strServidores.split(",");
            try {
                intAltCPU = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "altCPU"));
                intAltMEM = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "altMEM"));
                intAltDSK = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "altDSK"));
                intErrCPU = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "errCPU"));
                intErrMEM = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "errMEM"));
                intErrDSK = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "errDSK"));
            } catch (Exception e) {
                intAltCPU = 99;
                intAltMEM = 99;
                intAltDSK = 99;
                intErrCPU = 99;
                intErrMEM = 99;
                intErrDSK = 99;
            }
            if (strConnectServidores.length > 0) {
                if (intTotal < intPagina) {
                    intConta = 0;
                }
                for (int intCnt = intConta; intCnt < strConnectServidores.length; intCnt++) {
                    if (intTotal > 0) {
                        intSRVCnt++;
                        try {
                            strServidor = strConnectServidores[intCnt];
                            strDadosServidor = Connect(strServidor, "9").replace("(B", "").replace("[m", "").replace("[3;J", "").replace("[H", "").replace("[2J", "");
                            strDadosCPU = Connect(strServidor, "1");
                            strDadosMemoria = Connect(strServidor, "2");
                            strDadosDisco = Connect(strServidor, "3");
                            strDadosRede = Connect(strServidor, "4");
                        } catch (Exception e) {
                            strDadosServidor = null;
                            strDadosCPU = null;
                            strDadosMemoria = null;
                            strDadosDisco = null;
                            strDadosRede = null;
                        }
                        if (strDadosServidor != null && strDadosCPU != null && strDadosMemoria != null & strDadosDisco != null && strDadosRede != null) {
                            intHTMLCnt++;
                            strInfoServidor = strDadosServidor.split(";");
                            strInfoCPU = strDadosCPU.split(";");
                            strInfoMemoria = strDadosMemoria.split(";");
                            strInfoDisco = strDadosDisco.split(";");
                            strInfoRede = strDadosRede.split(";");

                            strNETR = strInfoRede[0];
                            if (strNETR.substring(0, 2).toLowerCase().equals("rx")) {
                                strNETR = strInfoRede[0].replace("RXbytes Total: ", "").replace("bytes", "b");
                            } else {
                                strNETR = (strInfoRede[0].substring(1)).replace("RXbytes Total: ", "").replace("bytes", "b");
                            }

                            strNETT = strInfoRede[2];
                            if (strNETT.substring(0, 2).toLowerCase().equals("tx")) {
                                strNETT = strInfoRede[2].replace("TXbytes Total: ", "").replace("bytes", "b");
                            } else {
                                strNETT = (strInfoRede[2].substring(1)).replace("TXbytes Total: ", "").replace("bytes", "b");
                            }

                            strRedeRX = strInfoRede[1].replace("RXbytes: ", "");
                            strRedeTX = strInfoRede[3].replace("TXbytes: ", "");
                            strRedeTRX = strNETR;
                            strRedeTTX = strNETT;

                            strCPU = strInfoCPU[0];
                            if (strCPU.substring(0, 3).toLowerCase().equals("cpu")) {
                                strCPU = strInfoCPU[0].replace("CPU Total Usage:", "").replace("%", "");
                            } else {
                                strCPU = (strInfoCPU[0].substring(1)).replace("CPU Total Usage:", "").replace("%", "");
                            }

                            strMEM = strInfoMemoria[2].replace("%", "");

                            strDSKT = strInfoDisco[1];
                            if (strDSKT.substring(0, 3).toLowerCase().equals("dis")) {
                                strDSKT = strInfoDisco[1].replace("Disk Total:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIT = strInfoDisco[1].replace("Disk Total:", "");
                            } else {
                                strDSKT = (strInfoDisco[1].substring(1)).replace("Disk Total:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIT = (strInfoDisco[1].substring(1)).replace("Disk Total:", "");
                            }

                            strDSKU = strInfoDisco[0];
                            if (strDSKU.substring(0, 3).toLowerCase().equals("dis")) {
                                strDSKU = strInfoDisco[0].replace("Disk Usage:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIU = strInfoDisco[0].replace("Disk Usage:", "");
                            } else {
                                strDSKU = (strInfoDisco[0].substring(1)).replace("Disk Usage:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIU = (strInfoDisco[0].substring(1)).replace("Disk Usage:", "");
                            }

                            intCPU = tratar.ToIntDBNull(strCPU);
                            intMEM = (int) Math.ceil(tratar.ToDoubleDBNull(strMEM));
                            dobCalc = tratar.ToDoubleDBNull(strDSKT) - tratar.ToDoubleDBNull(strDSKU);
                            dobLivDSK = dobCalc;
                            dobUsuDSK = tratar.ToDoubleDBNull(strDSKU);
                            dobErrDSK = tratar.ToDoubleDBNull(String.valueOf(intErrDSK) + ".00");
                            dobAltDSK = tratar.ToDoubleDBNull(String.valueOf(intAltDSK) + ".00");

                            strMemoria = strInfoMemoria[2].replace("%", "").replace(".", ",");
                            strDiscoLivre = strDSKT;
                            strDiscoUsado = strDSKU;
                            strDisco += "        var varPie" + intHTMLCnt + " = [{ value : " + dobLivDSK + " , color : pieSegColors[3], label: 'Livre'},{ value: " + dobUsuDSK + ", color: pieSegColors[1], label: 'Usado'}];\n";

                            if (intCPU > 100) {
                                intCPU = 100;
                            }
                            if (intCnt < strConnectServidores.length) {
                                strGauge += "'" + intCPU + "',";
                                strVarDisco += "varPie" + intHTMLCnt + ",";
                            } else {
                                strGauge += "'" + intCPU + "'";
                                strVarDisco += "varPie" + intHTMLCnt + "";
                            }

                            strSRV = strInfoServidor[0];
                            if (strSRV.substring(0, 3).toLowerCase().equals("int")) {
                                strSRV = strInfoServidor[0].replace("Internet:", "");
                            } else {
                                strSRV = (strInfoServidor[0].substring(1)).replace("Internet:", "");
                            }

                            strDiscoLivre = strDSKIT;
                            strDiscoUsado = strDSKIU;
                            if (strInfoServidor[2].toLowerCase().indexOf("linux") != -1) {
                                strPlataforma = "linux";
                            } else {
                                strPlataforma = "windows";
                            }
                            if (intCPU > intErrCPU || intMEM > intErrMEM || dobErrDSK >= dobLivDSK) {
                                strCor = "blink_link_red";
                            } else if (intCPU > intAltCPU || intMEM > intAltMEM || dobAltDSK >= dobLivDSK) {
                                strCor = "blink_link_yellow";
                            } else {
                                strCor = "blink_link_gray";
                            }

                            strHTML += "            <div class='row'>";
                            strHTML += "                <div class='col-sm-6 '>";
                            strHTML += "                    <div class='row'>";
                            // <editor-fold defaultstate="collapsed" desc="Plataforma">
                            strHTML += "                        <!-- INI - PLATAFORMA -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>PLATAFORMA</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content' style='padding-left: 25px;'>";
                            strHTML += "                                <i class='fa fa-" + strPlataforma + " " + strCor + "' style='font-size: 102pt;'></i>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - PLATAFORMA -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="Servidor">
                            strHTML += "                        <!-- FIM - SERVIDOR -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>SERVIDOR</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div style='padding-left: 5px; padding-top: 5px; font-size: 12pt;'>";
                            strHTML += "                                OS: <b style='color: #fff;'>" + strInfoServidor[1].replace("Operating System Type : ", "") + "</b><br>";
                            strHTML += "                                Arquitetura: <b style='color: #fff;'>" + strInfoServidor[3].replace("Architecture : ", "") + "</b><br>";
                            strHTML += "                                Servidor: <b style='color: #fff;'>" + strInfoServidor[5].replace("Hostname : ", "") + "</b><br>";
                            strHTML += "                                IP Interno: <b style='color: #fff;'>" + strInfoServidor[6].replace("Internal IP : ", "") + "</b><br>";
                            strHTML += "                                IP Externo: <b style='color: #fff;'>" + strInfoServidor[7].replace("External IP : ", "") + "</b><br>";
                            strHTML += "                                WAN: <b style='color: #fff;'>" + strSRV + "</b><br>";
                            strHTML += "                                &nbsp;";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - SERVIDOR -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="CPU">
                            strHTML += "                        <!-- INI - CPU -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>CPU %</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content cf-gauge' id='cf-gauge-" + intHTMLCnt + "'>";
                            strHTML += "                                <div class='val-current'>";
                            strHTML += "                                    <div class='metric' id='cf-gauge-" + intHTMLCnt + "-m'>0</div>";
                            strHTML += "                                </div>";
                            strHTML += "                                <div class='canvas'>";
                            strHTML += "                                    <canvas id='cf-gauge-" + intHTMLCnt + "-g'></canvas>";
                            strHTML += "                                </div>";
                            strHTML += "                                <div class='val-min'>";
                            strHTML += "                                    <div class='metric-small'>0</div>";
                            strHTML += "                                </div>";
                            strHTML += "                                <div class='val-max'>";
                            strHTML += "                                    <div class='metric-small'>100</div>";
                            strHTML += "                                </div>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - CPU -->";
                            // </editor-fold>
                            strHTML += "                    </div>";
                            strHTML += "                </div>";
                            strHTML += "                <div class='col-sm-6 '>";
                            strHTML += "                    <div class='row'>";
                            // <editor-fold defaultstate="collapsed" desc="Memoria">
                            strHTML += "                        <!-- INI - MEMORIA -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>MEMORIA %</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content cf-svp clearfix' id='svp-" + intHTMLCnt + "'>";
                            strHTML += "                                <div class='chart' data-percent='" + strMemoria + "' data-layout='l-6-4'></div>";
                            strHTML += "                                <div class='metrics'>";
                            strHTML += "                                    <span class='metric'>" + strMemoria + "</span>";
                            strHTML += "                                    <span class='metric-small'>%</span>";
                            strHTML += "                                </div>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - MEMORIA -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="Disco">
                            strHTML += "                        <!-- FIM - DISCO -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>DISCO</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content cf-pie' id='cf-pie-" + intHTMLCnt + "'>";
                            strHTML += "                                <div class='metric-small'><i class='fa fa-database' style='color: #5B5B5B'></i> " + strDiscoLivre + " Total&nbsp;&nbsp;<i class='fa fa-database' style='color: #C0C0C0'></i> " + strDiscoUsado + " Usado</div>";
                            strHTML += "                                <canvas id='cf-pie-" + intHTMLCnt + "-c'></canvas>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - DISCO -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="Rede">
                            strHTML += "                        <!-- INI - REDE -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>REDE</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content'>";
                            strHTML += "                                <div class='cf-svmc'>";
                            strHTML += "                                    <div class='metric'>" + strRedeTTX + "</div>";
                            strHTML += "                                    <div class='change m-red metric-small'>";
                            strHTML += "                                        <div class='arrow-up'></div>";
                            strHTML += "                                        <span class='large'>" + strRedeTX + "<span class='small'> TX</span></span>";
                            strHTML += "                                    </div>";
                            strHTML += "                                </div><br>";
                            strHTML += "                                <div class='cf-svmc'>";
                            strHTML += "                                    <div class='metric'>" + strRedeTRX + "</div>";
                            strHTML += "                                    <div class='change m-blue metric-small'>";
                            strHTML += "                                        <div class='arrow-down'></div>";
                            strHTML += "                                        <span class='large'>" + strRedeRX + "<span class='small'> RX</span></span>";
                            strHTML += "                                    </div>";
                            strHTML += "                                </div>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - REDE -->";
                            // </editor-fold>
                            strHTML += "                    </div>";
                            strHTML += "                </div>";
                            strHTML += "            </div>";
                        }
                        if (intSRVCnt >= intPagina) {
                            break;
                        }
                    }
                }
                strJavaScript += "<script type='text/javascript'>";
                strJavaScript += strDisco;
                strJavaScript += "        var varDataGauge = [null, " + strGauge + "];";
                strJavaScript += "        var varDataPie = [null, " + strVarDisco + "];";
                strJavaScript += "</script>";
                strHTML += strJavaScript;
            }
        } catch (Exception e) {
            strHTML = null;
        }
        return strHTML;
    }

    public String SimulatorMountScreen(int intConta) {
        String strHTML = "";
        String strCor = "";
        try {
            String[] strTMP1;
            String strTMP2;
            int intTMP1 = 0;
            int intTMP2 = 0;
            int intHTMLCnt = 0;
            int intSRVCnt = 0;
            double dobCalc = 0;
            String strJavaScript = "";
            String strServidor = "";
            String strGauge = "";
            String strMemoria = "";
            String strDisco = "";
            String strVarDisco = "";
            String strDiscoLivre = "";
            String strDiscoUsado = "";
            String strRedeRX = "";
            String strRedeTX = "";
            String strRedeTRX = "";
            String strRedeTTX = "";
            String strPlataforma = "";
            int intAltCPU = 0;
            int intAltMEM = 0;
            int intAltDSK = 0;
            int intErrCPU = 0;
            int intErrMEM = 0;
            int intErrDSK = 0;
            int intCPU = 0;
            int intMEM = 0;
            double dobLivDSK = 0;
            double dobUsuDSK = 0;
            double dobAltDSK = 0;
            double dobErrDSK = 0;
            strArquivoParametro = objPrp.configuracao(1, "Parametros");
            intPorta = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "Porta"));
            strServidores = tratar.ToStringDBNull(objPrp.Leitura(strArquivoParametro, "Servidores"));
            strChave = objPrp.Leitura(strArquivoParametro, "Chave");
            intPagina = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "MaximoPagina"));
            intTotal = strServidores.split(",").length;
            String[] strConnectServidores = strServidores.split(",");
            try {
                intAltCPU = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "altCPU"));
                intAltMEM = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "altMEM"));
                intAltDSK = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "altDSK"));
                intErrCPU = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "errCPU"));
                intErrMEM = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "errMEM"));
                intErrDSK = tratar.ToIntDBNull(objPrp.Leitura(strArquivoParametro, "errDSK"));
            } catch (Exception e) {
                intAltCPU = 99;
                intAltMEM = 99;
                intAltDSK = 99;
                intErrCPU = 99;
                intErrMEM = 99;
                intErrDSK = 99;
            }
            if (strConnectServidores.length > 0) {
                if (intTotal < intPagina) {
                    intConta = 0;
                }
                for (int intCnt = intConta; intCnt < strConnectServidores.length; intCnt++) {
                    if (intTotal > 0) {
                        intSRVCnt++;
                        try {
                            strTMP1 = Plataforma(1).split(";");
                            strServidor = strConnectServidores[intCnt];
                            strDadosServidor = "Internet: Connected;Operating System Type : " + strTMP1[0] + " ;OS Version : " + strTMP1[1] + ";Architecture : x86_64;Kernel Release : ;Hostname : " + Plataforma(2) + ";Internal IP : " + Plataforma(3) + ";External IP : " + Plataforma(4) + ";Name Servers : localhost localhost 127.0.0.1;";
                            intTMP1 = Randomico(1, 100);
                            strDadosCPU = "CPU Total Usage:" + String.valueOf(intTMP1) + "%;CPU Total Idle:" + Subtrair("100", String.valueOf(intTMP1)) + "%;";
                            intTMP1 = Randomico(2000, 4000);
                            intTMP2 = Randomico(4000, 8000);
                            strDadosMemoria = "Memory Usage:" + String.valueOf(intTMP1) + "MB;Memory Total:" + String.valueOf(intTMP2) + "MB;" + Percentual(String.valueOf(intTMP1), String.valueOf(intTMP2)) + "%;100%;";
                            intTMP1 = Randomico(10, 50);
                            intTMP2 = Randomico(50, 100);
                            strDadosDisco = "Disk Usage:" + String.valueOf(intTMP1) + "GB;Disk Total:" + String.valueOf(intTMP2) + "GB;" + Percentual(String.valueOf(intTMP1), String.valueOf(intTMP2)) + "%;100%;";
                            intTMP1 = Randomico(10, 50);
                            intTMP2 = Randomico(1, 10);
                            strDadosRede = "RXbytes Total: " + String.valueOf(intTMP1) + "Gb; RXbytes: 200 b ; TXbytes Total: " + String.valueOf(intTMP2) + " Gb; TXbytes: 100 b;";
                        } catch (Exception e) {
                            strDadosServidor = null;
                            strDadosCPU = null;
                            strDadosMemoria = null;
                            strDadosDisco = null;
                            strDadosRede = null;
                        }
                        if (strDadosServidor != null && strDadosCPU != null && strDadosMemoria != null & strDadosDisco != null && strDadosRede != null) {
                            intHTMLCnt++;
                            strInfoServidor = strDadosServidor.split(";");
                            strInfoCPU = strDadosCPU.split(";");
                            strInfoMemoria = strDadosMemoria.split(";");
                            strInfoDisco = strDadosDisco.split(";");
                            strInfoRede = strDadosRede.split(";");

                            strNETR = strInfoRede[0];
                            if (strNETR.substring(0, 2).toLowerCase().equals("rx")) {
                                strNETR = strInfoRede[0].replace("RXbytes Total: ", "").replace("bytes", "b");
                            } else {
                                strNETR = (strInfoRede[0].substring(1)).replace("RXbytes Total: ", "").replace("bytes", "b");
                            }

                            strNETT = strInfoRede[2];
                            if (strNETT.substring(0, 2).toLowerCase().equals("tx")) {
                                strNETT = strInfoRede[2].replace("TXbytes Total: ", "").replace("bytes", "b");
                            } else {
                                strNETT = (strInfoRede[2].substring(1)).replace("TXbytes Total: ", "").replace("bytes", "b");
                            }

                            strRedeRX = strInfoRede[1].replace("RXbytes: ", "");
                            strRedeTX = strInfoRede[3].replace("TXbytes: ", "");
                            strRedeTRX = strNETR;
                            strRedeTTX = strNETT;

                            strCPU = strInfoCPU[0];
                            if (strCPU.substring(0, 3).toLowerCase().equals("cpu")) {
                                strCPU = strInfoCPU[0].replace("CPU Total Usage:", "").replace("%", "");
                            } else {
                                strCPU = (strInfoCPU[0].substring(1)).replace("CPU Total Usage:", "").replace("%", "");
                            }

                            strMEM = strInfoMemoria[2].replace("%", "");

                            strDSKT = strInfoDisco[1];
                            if (strDSKT.substring(0, 3).toLowerCase().equals("dis")) {
                                strDSKT = strInfoDisco[1].replace("Disk Total:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIT = strInfoDisco[1].replace("Disk Total:", "");
                            } else {
                                strDSKT = (strInfoDisco[1].substring(1)).replace("Disk Total:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIT = (strInfoDisco[1].substring(1)).replace("Disk Total:", "");
                            }

                            strDSKU = strInfoDisco[0];
                            if (strDSKU.substring(0, 3).toLowerCase().equals("dis")) {
                                strDSKU = strInfoDisco[0].replace("Disk Usage:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIU = strInfoDisco[0].replace("Disk Usage:", "");
                            } else {
                                strDSKU = (strInfoDisco[0].substring(1)).replace("Disk Usage:", "").replace("TB", "").replace("GB", "").replace("MB", "").replace("Kb", "").replace("b", "").replace("bytes", "");
                                strDSKIU = (strInfoDisco[0].substring(1)).replace("Disk Usage:", "");
                            }

                            intCPU = tratar.ToIntDBNull(strCPU);
                            intMEM = (int) Math.ceil(tratar.ToDoubleDBNull(strMEM));
                            dobCalc = tratar.ToDoubleDBNull(strDSKT) - tratar.ToDoubleDBNull(strDSKU);
                            dobLivDSK = dobCalc;
                            dobUsuDSK = tratar.ToDoubleDBNull(strDSKU);
                            dobErrDSK = tratar.ToDoubleDBNull(String.valueOf(intErrDSK) + ".00");
                            dobAltDSK = tratar.ToDoubleDBNull(String.valueOf(intAltDSK) + ".00");

                            strMemoria = strInfoMemoria[2].replace("%", "").replace(".", ",");
                            strDiscoLivre = strDSKT;
                            strDiscoUsado = strDSKU;
                            strDisco += "        var varPie" + intHTMLCnt + " = [{ value : " + dobLivDSK + " , color : pieSegColors[3], label: 'Livre'},{ value: " + dobUsuDSK + ", color: pieSegColors[1], label: 'Usado'}];\n";

                            if (intCPU > 100) {
                                intCPU = 100;
                            }
                            if (intCnt < strConnectServidores.length) {
                                strGauge += "'" + intCPU + "',";
                                strVarDisco += "varPie" + intHTMLCnt + ",";
                            } else {
                                strGauge += "'" + intCPU + "'";
                                strVarDisco += "varPie" + intHTMLCnt + "";
                            }

                            strSRV = strInfoServidor[0];
                            if (strSRV.substring(0, 3).toLowerCase().equals("int")) {
                                strSRV = strInfoServidor[0].replace("Internet:", "");
                            } else {
                                strSRV = (strInfoServidor[0].substring(1)).replace("Internet:", "");
                            }

                            strDiscoLivre = strDSKIT;
                            strDiscoUsado = strDSKIU;
                            if (strInfoServidor[2].toLowerCase().indexOf("linux") != -1) {
                                strPlataforma = "linux";
                            } else {
                                strPlataforma = "windows";
                            }
                            if (intCPU > intErrCPU || intMEM > intErrMEM || dobErrDSK >= dobLivDSK) {
                                strCor = "blink_link_red";
                            } else if (intCPU > intAltCPU || intMEM > intAltMEM || dobAltDSK >= dobLivDSK) {
                                strCor = "blink_link_yellow";
                            } else {
                                strCor = "blink_link_gray";
                            }

                            strHTML += "            <div class='row'>";
                            strHTML += "                <div class='col-sm-6 '>";
                            strHTML += "                    <div class='row'>";
                            // <editor-fold defaultstate="collapsed" desc="Plataforma">
                            strHTML += "                        <!-- INI - PLATAFORMA -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>PLATAFORMA</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content' style='padding-left: 25px;'>";
                            strHTML += "                                <i class='fa fa-" + strPlataforma + " " + strCor + "' style='font-size: 102pt;'></i>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - PLATAFORMA -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="Servidor">
                            strHTML += "                        <!-- FIM - SERVIDOR -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>SERVIDOR</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div style='padding-left: 5px; padding-top: 5px; font-size: 12pt;'>";
                            strHTML += "                                OS: <b style='color: #fff;'>" + strInfoServidor[1].replace("Operating System Type : ", "") + "</b><br>";
                            strHTML += "                                Arquitetura: <b style='color: #fff;'>" + strInfoServidor[3].replace("Architecture : ", "") + "</b><br>";
                            strHTML += "                                Servidor: <b style='color: #fff;'>" + strInfoServidor[5].replace("Hostname : ", "") + "</b><br>";
                            strHTML += "                                IP Interno: <b style='color: #fff;'>" + strInfoServidor[6].replace("Internal IP : ", "") + "</b><br>";
                            strHTML += "                                IP Externo: <b style='color: #fff;'>" + strInfoServidor[7].replace("External IP : ", "") + "</b><br>";
                            strHTML += "                                WAN: <b style='color: #fff;'>" + strSRV + "</b><br>";
                            strHTML += "                                &nbsp;";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - SERVIDOR -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="CPU">
                            strHTML += "                        <!-- INI - CPU -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>CPU %</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content cf-gauge' id='cf-gauge-" + intHTMLCnt + "'>";
                            strHTML += "                                <div class='val-current'>";
                            strHTML += "                                    <div class='metric' id='cf-gauge-" + intHTMLCnt + "-m'>0</div>";
                            strHTML += "                                </div>";
                            strHTML += "                                <div class='canvas'>";
                            strHTML += "                                    <canvas id='cf-gauge-" + intHTMLCnt + "-g'></canvas>";
                            strHTML += "                                </div>";
                            strHTML += "                                <div class='val-min'>";
                            strHTML += "                                    <div class='metric-small'>0</div>";
                            strHTML += "                                </div>";
                            strHTML += "                                <div class='val-max'>";
                            strHTML += "                                    <div class='metric-small'>100</div>";
                            strHTML += "                                </div>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - CPU -->";
                            // </editor-fold>
                            strHTML += "                    </div>";
                            strHTML += "                </div>";
                            strHTML += "                <div class='col-sm-6 '>";
                            strHTML += "                    <div class='row'>";
                            // <editor-fold defaultstate="collapsed" desc="Memoria">
                            strHTML += "                        <!-- INI - MEMORIA -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>MEMORIA %</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content cf-svp clearfix' id='svp-" + intHTMLCnt + "'>";
                            strHTML += "                                <div class='chart' data-percent='" + strMemoria + "' data-layout='l-6-4'></div>";
                            strHTML += "                                <div class='metrics'>";
                            strHTML += "                                    <span class='metric'>" + strMemoria + "</span>";
                            strHTML += "                                    <span class='metric-small'>%</span>";
                            strHTML += "                                </div>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - MEMORIA -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="Disco">
                            strHTML += "                        <!-- FIM - DISCO -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>DISCO</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content cf-pie' id='cf-pie-" + intHTMLCnt + "'>";
                            strHTML += "                                <div class='metric-small'><i class='fa fa-database' style='color: #5B5B5B'></i> " + strDiscoLivre + " Total&nbsp;&nbsp;<i class='fa fa-database' style='color: #C0C0C0'></i> " + strDiscoUsado + " Usado</div>";
                            strHTML += "                                <canvas id='cf-pie-" + intHTMLCnt + "-c'></canvas>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - DISCO -->";
                            // </editor-fold>
                            // <editor-fold defaultstate="collapsed" desc="Rede">
                            strHTML += "                        <!-- INI - REDE -->";
                            strHTML += "                        <div class='col-sm-4 cf-item'>";
                            strHTML += "                            <header>";
                            strHTML += "                                <p><span></span>REDE</p>";
                            strHTML += "                            </header>";
                            strHTML += "                            <div class='content'>";
                            strHTML += "                                <div class='cf-svmc'>";
                            strHTML += "                                    <div class='metric'>" + strRedeTTX + "</div>";
                            strHTML += "                                    <div class='change m-red metric-small'>";
                            strHTML += "                                        <div class='arrow-up'></div>";
                            strHTML += "                                        <span class='large'>" + strRedeTX + "<span class='small'> TX</span></span>";
                            strHTML += "                                    </div>";
                            strHTML += "                                </div><br>";
                            strHTML += "                                <div class='cf-svmc'>";
                            strHTML += "                                    <div class='metric'>" + strRedeTRX + "</div>";
                            strHTML += "                                    <div class='change m-blue metric-small'>";
                            strHTML += "                                        <div class='arrow-down'></div>";
                            strHTML += "                                        <span class='large'>" + strRedeRX + "<span class='small'> RX</span></span>";
                            strHTML += "                                    </div>";
                            strHTML += "                                </div>";
                            strHTML += "                            </div>";
                            strHTML += "                        </div>";
                            strHTML += "                        <!-- FIM - REDE -->";
                            // </editor-fold>
                            strHTML += "                    </div>";
                            strHTML += "                </div>";
                            strHTML += "            </div>";
                        }
                        if (intSRVCnt >= intPagina) {
                            break;
                        }
                    }
                }
                strJavaScript += "<script type='text/javascript'>";
                strJavaScript += strDisco;
                strJavaScript += "        var varDataGauge = [null, " + strGauge + "];";
                strJavaScript += "        var varDataPie = [null, " + strVarDisco + "];";
                strJavaScript += "</script>";
                strHTML += strJavaScript;
            }
        } catch (Exception e) {
            strHTML = null;
        }
        return strHTML;
    }

    public String Connect(String strServidor, String strOpc) throws UnknownHostException, IOException {
        String strReturn = null;
        try {
            if (strServidor.length() > 0) {
                if (strOpc.length() > 0) {
                    if (strChave.length() > 0) {
                        InetAddress address = InetAddress.getByName(strServidor);
                        socket = new Socket(address, intPorta);

                        //Send the message to the server
                        OutputStream objOts = socket.getOutputStream();
                        OutputStreamWriter objOtw = new OutputStreamWriter(objOts);
                        BufferedWriter objBfw = new BufferedWriter(objOtw);

                        // Send parameter
                        objBfw.write(strChave + strOpc + "\n");
                        objBfw.flush();

                        //Get the return message from the server
                        InputStream objIps = socket.getInputStream();
                        InputStreamReader objIpr = new InputStreamReader(objIps);
                        BufferedReader objBfr = new BufferedReader(objIpr);
                        strReturn = objBfr.readLine();
                    } else {
                        strReturn = null;
                    }
                } else {
                    strReturn = null;
                }
            } else {
                strReturn = null;
            }
        } catch (Exception e) {
            strReturn = null;
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
        return strReturn;
    }

    private int Randomico(int intMin, int intMax) {
        Random r = new Random();
        return r.nextInt(intMax - intMin) + intMin;
    }

    private String Plataforma(int intOpt) {
        String strReturn = "";
        Random r = new Random();
        int intRet;
        try {
            if (intOpt == 1){
                intRet = r.nextInt(40 - 1) + 1;
                strReturn = "GNU/Linux; Linux CentOS 6.7(Final 2.6.32-573.el6.x86_64 x86_64)";
                if (intRet > 20) {
                    strReturn = "Windows; Windows 64x";
                }
            } else if (intOpt == 2){
                intRet = r.nextInt(200 - 1) + 1;
                strReturn = "server." + String.valueOf(intRet);
            } else if (intOpt == 3){
                intRet = r.nextInt(225 - 1) + 1;
                strReturn = "192.168.0." + String.valueOf(intRet);
            } else if (intOpt == 4){
                intRet = r.nextInt(225 - 1) + 1;
                strReturn = "200.100.10." + String.valueOf(intRet);
            }
        } catch (Exception e) {
            strReturn = "";
        }
        return strReturn;
    }

    private String Percentual(String strValMin, String strValMax) {
        String strReturn = "0%";
        try {
            double dobMin = tratar.ToDoubleDBNull(strValMin);
            double dobMax = tratar.ToDoubleDBNull(strValMax);
            double dobCal = (dobMin / dobMax) * 100;
            strReturn = String.valueOf(dobCal).substring(0, 1);
        } catch (Exception e) {
            strReturn = "0%";
        }
        return strReturn;
    }

    private String Subtrair(String strValOne, String strValTwo) {
        String strReturn = "0";
        try {
            int intValOne = tratar.ToIntDBNull(strValOne);
            int intValTwo = tratar.ToIntDBNull(strValTwo);
            int intCalc = intValOne - intValTwo;
            strReturn = String.valueOf(intCalc);
        } catch (Exception e) {
            strReturn = "0";
        }
        return strReturn;
    }

}
