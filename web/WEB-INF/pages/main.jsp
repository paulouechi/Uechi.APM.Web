<%-- 
    Document   : main
    Created on : 02/09/2016, 20:35:15
    Author     : paulo.uechi
--%>
<%@page import="br.com.uechi.monitor.security"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uechi.APM.Web</title>
        <meta name="author" content="Paulo Uechi">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="css/uechi.css" rel="stylesheet" type="text/css" media="screen">   
        <link href="css/loading-count.css" rel="stylesheet" type="text/css">
        <script src="js/jquery-1.9.1.js"></script>    
        <script src="js/bootstrap.js"></script>
        <script src="js/moment.js" type="text/javascript"></script>
        <!--[if lt IE 9]><script src="js/respond.min.js"></script><script src="js/excanvas.min.js"></script><![endif]-->
        <script src="js/control.js" type="text/javascript"></script>
        <script src="js/control.main.js" type="text/javascript"></script>
    </head>
    <body class="black">
        <!-- INI - Menu -->
        <div class="cf-nav cf-nav-state-min">
            <a href="#" class="cf-nav-toggle"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
            <ul>
                <li class="current cf-nav-shortcut">
                    <a href="index.html" class="current active">
                        <span class="cf-nav-min"><i class="fa fa-home"></i></span>
                        <span class="cf-nav-max">Home</span>
                    </a>
                    <a href="main" class="current active">
                        <span class="cf-nav-min"><i class="fa fa-cog"></i></span>
                        <span class="cf-nav-max">Principal</span>
                    </a>
                    <a href="<%=security.goInvoke(request, response, "monitor")%>" class="current active">
                        <span class="cf-nav-min"><i class="fa fa-desktop"></i></span>
                        <span class="cf-nav-max">Monitor</span>
                    </a>
                </li>
            </ul>
        </div>
        <!-- FIM - Menu -->
        <form class="frmMain" action="${pageContext.request.contextPath}/main" method="post">
            <div class="cf-container cf-nav-active">
                <div class="row">
                    <div class="col-sm-11">
                        <header style="border-bottom: solid 1px; margin-top: 5px; margin-bottom: 15px;">
                            <p><span style="font-size: 10pt;">Configurações</span></p>
                        </header>
                        <div class="content cf-rss">
                            <div id="cf-rss-1" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <blockquote class="twitter-tweet" lang="en"><p>Seja bem vindo a Uechi.APM.Web, Informações <a href="http://uechi.com.br/">http://uechi.com.br/</a></p>Contato por e-mail <a href="mailto:paulouechi@gmail.com">paulouechi@gmail.com</a></blockquote>
                                    </div>
                                    <div class="item">
                                        <blockquote class="twitter-tweet" lang="en"><p>Por favor, siga os procedimentos abaixo para configurar conforme a sua necessidade.</p>Versão <b>1.0.0</b></blockquote>
                                    </div>
                                </div>
                                <ol class="carousel-indicators">
                                    <li data-target="#cf-rss-1" data-slide-to="0" class="active"></li>
                                    <li data-target="#cf-rss-1" data-slide-to="1"></li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-11">
                        <header style="border-bottom: solid 1px; margin-top: 5px; margin-bottom: 15px;">
                            <p><span style="font-size: 10pt;">Parametros</span></p>
                        </header>
                        <div class="content">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="iptChave">Chave</label>
                                        <input type="text" class="form-control" id="iptChave" name="iptChave" value="${iptChave}" placeholder="95192c98732387165bf8e396c0f2dad2">
                                    </div>
                                    <div class="col-md-1">
                                        <label for="iptPorta">Porta</label>
                                        <input type="text" class="form-control" id="iptPorta" name="iptPorta" value="${iptPorta}" placeholder="2500">
                                    </div>
                                </div>
                            </div>
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label for="iptServidores">Servidores (Separar por ',' virgula)</label>
                                        <input type="text" class="form-control" id="iptServidores" name="iptServidores" value="${iptServidores}" placeholder="192.168.0.1,192.168.0.2">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-2">
                                        <label for="selMaxPagina">Maximo por tela</label>
                                        <select id="selMaxPagina" name='selMaxPagina' class="form-control">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                            <option>8</option>
                                            <option>9</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                            <option>13</option>
                                            <option>14</option>
                                            <option>15</option>
                                        </select>
                                    </div>
                                    <div class="col-md-2">
                                        <label for="selAtualizar">Atualizar (s)</label>
                                        <select id="selAtualizar" name='selAtualizar' class="form-control">
                                            <option>15</option>
                                            <option>30</option>
                                            <option>60</option>
                                            <option>120</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-11">
                        <header style="border-bottom: solid 1px; margin-top: 5px; margin-bottom: 15px;">
                            <p><span style="font-size: 10pt;">Avisos</span></p>
                        </header>
                        <div class="content">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="lblAvisosAlerta"><i class='fa fa-exclamation-circle fa-2x' style="color: #FFFF00;"></i> Avisos de alerta em tela</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-1">
                                        <label for="selAltCPU">CPU%</label>
                                        <select id="selAltCPU" name="selAltCPU" class="form-control">
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                        </select>
                                    </div>
                                    <div class="col-md-1">
                                        <label for="selAltMEM">MEM%</label>
                                        <select id="selAltMEM" name="selAltMEM" class="form-control">
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                        </select>
                                    </div>
                                    <div class="col-md-1">
                                        <label for="selAltDSK">DISCO(-GB)</label>
                                        <select id="selAltDSK" name="selAltDSK" class="form-control">
                                            <option>10</option>
                                            <option>20</option>
                                            <option>30</option>
                                            <option>40</option>
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                            <option>100</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="lblAvisosErros"><i class='fa fa-exclamation-triangle fa-2x' style="color: #ff0000;"></i> Avisos de erro em tela</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-1">
                                        <label for="selErrCPU">CPU%</label>
                                        <select id="selErrCPU" name="selErrCPU" class="form-control">
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                        </select>
                                    </div>
                                    <div class="col-md-1">
                                        <label for="selErrMEM">MEM%</label>
                                        <select id="selErrMEM" name="selErrMEM" class="form-control">
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                        </select>
                                    </div>
                                    <div class="col-md-1">
                                        <label for="selAltDSK">DISCO(-GB)</label>
                                        <select id="selErrDSK" name="selErrDSK" class="form-control">
                                            <option>10</option>
                                            <option>20</option>
                                            <option>30</option>
                                            <option>40</option>
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                            <option>100</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-11">
                        <header style="border-bottom: solid 1px; margin-top: 5px; margin-bottom: 15px;">
                        </header>
                        <div class="content">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <a href="index.html" class="btn btn-lg btn-default">Voltar</a>&nbsp;
                                        <button type="submit" class="btn btn-lg btn-primary" id="btnAction" name="btnAction" value="regSalvar">Salvar Configurações</button>&nbsp;
                                        <a href="<%=security.goInvoke(request, response, "monitor")%>" class="btn btn-lg btn-success">Executar Monitor</a>
                                    </div>
                                    <div class="col-md-5">
                                        <label for="divMsg" style="padding-top: 10px; font-size: 12pt;">${customDOMMSG}</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        ${customDOM}
    </body>
</html>
