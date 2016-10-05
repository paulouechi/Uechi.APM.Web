<%-- 
    Document   : monitor
    Created on : 01/09/2016, 20:57:58
    Author     : paulo.uechi
--%>

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
        <link href="css/monitor.css" rel="stylesheet" type="text/css">
        <link href="css/loading-count.css" rel="stylesheet" type="text/css">
        <script src="js/jquery-1.9.1.js"></script>    
        <script src="js/control.pie.js"></script>
        <script src="js/control.gauge.js"></script>	
        <script src="js/control.chart.js"></script>
        <script src="js/jquery.sparklines.js"></script>			
        <script src="js/bootstrap.js"></script>
        <script src="js/moment.js" type="text/javascript"></script>
        <!--[if lt IE 9]><script src="js/respond.min.js"></script><script src="js/excanvas.min.js"></script><![endif]-->
        <script src="js/control.js" type="text/javascript"></script>
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
                    <a href="monitor" class="current active">
                        <span class="cf-nav-min"><i class="fa fa-desktop"></i></span>
                        <span class="cf-nav-max">Monitor</span>
                    </a>
                </li>
            </ul>
        </div>
        <!-- FIM - Menu -->
        <div class="cf-container cf-nav-active">
            <div id="divLoader">
                <div class="cssload-container"><div class="cssload-speeding-wheel"></div></div>
                <div id="divCount" name="divCount"></div>
            </div>
            ${customDOMMonitor}
            ${customDOMRefresh}
        </div>
    </body>
    <script src="js/control.gauges.js"></script>
    <script src="js/control.includes.js"></script>
</html>
