<h1>Uechi.APM.Web</h1>

<strong>About:</strong>

Uechi APM Web is an APM (Application Performance Management) Open Server Performance Monitor Source written and developed in Java and C # for all Linux and Windows platforms. The Uechi.APM.Web offers a complete resource for unlimited monitoring servers in real time. Have full control of the CPU consumption, memory, disk and network traffic. Communication is done via TCP Protocol Socket connection.

See a simulated demonstration by clicking <a href="http://vm.uechi.com.br/Uechi.APM.Web/" target="_blank">here</a> or visit <a href="http://vm.uechi.com.br/Uechi.APM.Web/" target="_blank">http://vm.uechi.com.br/Uechi.APM.Web/</a> address.

<img class="alignnone wp-image-2612 size-full" src="http://uechi.com.br/wp-content/uploads/img001ue-e1475682783274.jpg" alt="img001ue" width="800" height="408" />

Through a Front developed in Web, allows easy configuration for monitoring an unlimited number of servers in real time, still relying on visual alerts monitoring.

<img class="alignnone wp-image-2613 size-full" src="http://uechi.com.br/wp-content/uploads/img002ue-e1475682848351.jpg" alt="img002ue" width="800" height="408" />

The communication is done via the TCP socket. Below is an example Monitor Dashboard with two warnings, a medium and a serious warning highlighted by yellow and red colors.

<img class="alignnone wp-image-2614 size-full" src="http://uechi.com.br/wp-content/uploads/img003ue-e1475682905871.jpg" alt="img003ue" width="800" height="408" />

The Monitor Dashboard updates every "x" seconds based on your parameter setting.

<img class="alignnone wp-image-2615 size-full" src="http://uechi.com.br/wp-content/uploads/img004ue-e1475684864382.jpg" alt="img004ue" width="800" height="408" />

The service is compatible for both Linux and Windows 32bit and 64Bit platforms.

<strong>Demonstration:</strong>

All features are available in the demo simulated operating in <a href="http://vm.uechi.com.br/Uechi.APM.Web/" target="_blank">http://vm.uechi.com.br/Uechi.APM.Web/</a> address.

<strong>Overview:</strong>

Uechi.APM.Web

Communicates with the server through socket with TCP making an authenticated request by a Hash Key Encrypted MD5 and requested option, Uechi.APM.Service.Socket.Server makes validation and consultation request requested from the server returning the information to the Uechi.APM.Web.

The configuration of Uechi.APM.Web and made by custom parameters such as time, amount of display servers screen, better resolution setting. The design is responsive, thus be viewed in different types of resolution to other devices such as tablets and phones. The security key settings must be made through a Hash Key Encryption with MD5 128 bits of your choice, then following the communication port and the servers will be done communication, separated by ',' comma. You also has a medium-warning alerts configuration severe being distinguished by yellow and red colors, which can be configured according to your CPU consumption suggestion, Memory, Disk and Network traffic.

Uechi.APM.Services.Socket.Server

Linux version is a Client Open Source server performance monitor for Linux, which responds to requests made by Uechi.APM.Web.

Uechi.APM.Services.Socket.Server

Windows version is a Client Open Source server performance monitor for Windows, which responds to requests made by Uechi.APM.Web.

<strong>Architecture:</strong>

Below is a flow chart of the general operation of the structure:

<img class="alignnone wp-image-2667 size-full" src="http://uechi.com.br/wp-content/uploads/uapm020-e1475696247500.jpg" alt="uapm020" width="801" height="349" />

<strong>Structure:</strong>

Uechi.APM.Web
Monitoring Web project developed in JSP on the Java platform 1.8 and 1.7 compatible, running on Glassfish Web 4.0 and Tomcat 8.0 server.

Linux version
Uechi.APM.Services.Socket.Server
Customer Service Project Socket in Java 1.8 compatible with Linux platforms.

Windows version
Uechi.APM.Services.Socket.Server
Customer Service Project Socket developed in VS.NET Framework 4.0 supports Windows platforms.

<strong>Supported modules:</strong>

. Glassfish 4+
. Tomcat 8+
. JDK 1.7 +
. Framework 4.0

<strong>Tested and Approved in:</strong>

Linux
CentOS x86_64 versions 6:07.
Ubuntu x86_64 versions 24:14.

Windows
Windows 2003 Advanced Server
Windows Server 2008 R2
Windows Server 2012 R2

<strong>Installation:</strong>

Requirements:

Uechi.APM.Web

. JDK 8 installed
. Glassfish or Tomcat 4+ 8+
. Windows or Linux

Uechi.APM.Services.Socket.Server Linux

Linux-based operating system compatible.

Uechi.APM.Services.Socket.Server Windows

Operating Windows versions Server system.

<strong>Uechi.APM.Web</strong>

a) Download the Deploy and publish the Glassfish or Tomcat following the instructions below:

Version 1.0.0 compatible with Glassfish and Tomcat:

Download Deploy War:

<a href="https://github.com/paulouechi/Uechi.APM.Web/blob/master/dist/Uechi.APM.Web.war" target="_blank">https://github.com/paulouechi/Uechi.APM.Web/blob/master/dist/Uechi.APM.Web.war</a>

Download Compressed:

<a href="https://github.com/paulouechi/Uechi.APM.Web/blob/master/dist/Uechi.APM.Web.war.zip" target="_blank">https://github.com/paulouechi/Uechi.APM.Web/blob/master/dist/Uechi.APM.Web.war.zip</a>

Note: I'll use the example of Glassfish, if not installed click here.

b) Access Admin your Glassfish, Applications menu, then click the Deploy button.

<img class="alignnone wp-image-38 size-full" src="http://uechi.com.br/wp-content/uploads/2014/07/GlassFish_4_Screenshot-e1475684926401.png" alt="GlassFish_4_Screenshot" width="800" height="702" />

c) Click to locate the .war file after selected click OK.

<img class="alignnone wp-image-39 size-full" src="http://uechi.com.br/wp-content/uploads/2014/07/GlassFish_4_Deploy-e1475684944646.png" alt="GlassFish_4_Deploy" width="772" height="728" />

d) Download the file properties:

<a href="https://github.com/paulouechi/Uechi.APM.Web/blob/master/src/java/br/com/uechi/config/parametro.properties" target="_blank">https://github.com/paulouechi/Uechi.APM.Web/blob/master/src/java/br/com/uechi/config/parametro.properties</a>

e) By default the properties file must be in /opt/uechi/Uechi.APM.Web/ directory with the appropriate write permissions to do this do the following procedure:
<pre class="EnlighterJSRAW" data-enlighter-language="shell"># sudo mkdir / opt / uechi &amp;&amp; mkdir /opt/uechi/Uechi.APM.Web
# sudo cp parametro.properties /opt/uechi/Uechi.APM.Web/
# sudo chmod 777 /opt/uechi/Uechi.APM.Web/parametro.properties
## NOTE: Replace the "User" by default user where your GlassFish / Tomcat runs.
# sudo chown user:user /opt/uechi/Uechi.APM.Web/parametro.properties</pre>
<strong>Uechi.APM.Service.Socket.Server</strong>

Linux version
- Download the package with the Deploy more dependencies and follow the instructions below:

a) Download the complete package compressed into:

<a href="https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Linux/blob/master/dist/Uechi.APM.Services.Socket.Server.zip" target="_blank">https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Linux/blob/master/dist/Uechi.APM.Services.Socket.Server.zip</a>

b) Follow the steps below to install:
<pre class="EnlighterJSRAW" data-enlighter-language="shell"># mkdir / opt / uechi
# mkdir /opt/uechi/Uechi.APM.Service.Socket.Server
# cd /opt/uechi/Uechi.APM.Service.Socket.Server
# mkdir log
# wget https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Linux/blob/master/dist/Uechi.APM.Services.Socket.Server.zip
# unzip Uechi.APM.Service.Socket.Server.zip -d /opt/uechi/Uechi.APM.Service.Socket.Server/</pre>
Decompressing the folder you will have the following files:

<img class="alignnone wp-image-2618 size-full" src="http://uechi.com.br/wp-content/uploads/image005ue-e1475684987725.jpg" alt="image005ue" width="800" height="424" />

c) To start the service:
<pre class="EnlighterJSRAW" data-enlighter-language="shell"># nohup java -jar -Xms128M -Xmx3G Uechi.APM.Service.Socket.Server.jar&gt; / dev / null &amp;</pre>
<img class="alignnone wp-image-2619 size-full" src="http://uechi.com.br/wp-content/uploads/image006ue-e1475685004871.jpg" alt="image006ue" width="800" height="424" />

If you want to boot with log:
<pre class="EnlighterJSRAW" data-enlighter-language="shell"># nohup java -jar -Xms128M -Xmx3G Uechi.APM.Service.Socket.Server.jar&gt; log / out.log &amp;
# tail -f log / out.log</pre>
d) To complete the process do the following:
<pre class="EnlighterJSRAW" data-enlighter-language="shell"># ps -aux | grep Uechi.APM
## Check what is the process of PID, you can return something like this:
## Root 1989 0.1 5.9 578 225? Ps 14:11 Sep28 java -jar -Xms512m -Xmx3G Uechi.APM.Services.Socket.Server.jar
## In the above case the PID is the second column of the return [1989]
## To kill the process run the command:
# sudo kill -9 1989</pre>
e) Key Settings and port can be edited through the uechi.properties file as shown below:
<pre class="EnlighterJSRAW" data-enlighter-language="shell"># Nano /opt/uechi/Uechi.APM.Services.Socket.Server/uechi.properties</pre>
f) Edit the file parameters "key = 698dc19d489c4e4db73e28a713eab07b" and "Port = 8888" to your desired setting.

Notes: To generate a new Key MD5 please visit <a href="http://passwordsgenerator.net/md5-hash-generator/" target="_blank">http://passwordsgenerator.net/md5-hash-generator/</a> enter your desired combination to generate a new key.

<strong>Uechi.APM.Service.Socket.Server</strong>

Windows version

a) Download the Setup MSI package and follow the instructions below:

To download click package from <a href="https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Windows/blob/master/Uechi.APM.Services.Socket.Server.Setup/Debug/Uechi.APM.Services.Socket.Server.Setup.zip" target="_blank">https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Windows/blob/master/Uechi.APM.Services.Socket.Server.Setup/Debug/Uechi.APM.Services.Socket.Server.Setup.zip</a>

b) Extract the ZIP aquivo for Setup.exe and the MSI.

<img class="alignnone wp-image-2620 size-full" src="http://uechi.com.br/wp-content/uploads/image007ue-e1475685037953.jpg" alt="image007ue" width="800" height="424" />

c) Follow the Setup Wizard steps until the end as shown below:

<img class="alignnone wp-image-2637 size-full" src="http://uechi.com.br/wp-content/uploads/img010ue-e1475681947752.jpg" alt="img010ue" width="499" height="409" />

<img class="alignnone wp-image-2638 size-full" src="http://uechi.com.br/wp-content/uploads/img011ue-e1475681972509.jpg" alt="img011ue" width="499" height="409" />

<img class="alignnone wp-image-2640 size-full" src="http://uechi.com.br/wp-content/uploads/img013ue-e1475682006371.jpg" alt="img013ue" width="499" height="409" />

<img class="alignnone wp-image-2639 size-full" src="http://uechi.com.br/wp-content/uploads/img012ue-e1475681989706.jpg" alt="img012ue" width="499" height="409" />

d) After the installation is complete, go in the Administrative Tools of Windows and click the Services icon, locate the Uechi.APM.Services.Socket.Server click the right button and click start.

<img class="alignnone wp-image-2643 size-full" src="http://uechi.com.br/wp-content/uploads/img016ue-e1475685117414.jpg" alt="img016ue" width="800" height="448" />

<img class="alignnone wp-image-2644 size-full" src="http://uechi.com.br/wp-content/uploads/img017ue-e1475685143500.jpg" alt="img017ue" width="800" height="448" />

Note: The Service will start automatically if the server is rebooted.

e) Key Settings and port can be edited through the Uechi.APM.Services.Socket.Server.exe.config file by default in the folder "C: \ Program Files (x86) \ Uechi.com.br \ Uechi.APM.Services.Socket.Server \ "as shown below:

<img class="alignnone wp-image-2642 size-full" src="http://uechi.com.br/wp-content/uploads/img015ue-e1475685170377.jpg" alt="img015ue" width="800" height="515" />

f) Open this file in notepad and edit the parameters of the &lt;add key = "key" value = "698dc19d489c4e4db73e28a713eab07b" /&gt; and &lt;add key = "Port" value = "8888" /&gt; to your desired setting as below:

<img class="alignnone wp-image-2645 size-full" src="http://uechi.com.br/wp-content/uploads/img018ue-e1475690649507.jpg" alt="img018ue" width="800" height="463" />

Save the file and restart the service as step d.

Notes: To generate a new Key MD5 please visit <a href="http://passwordsgenerator.net/md5-hash-generator/" target="_blank">http://passwordsgenerator.net/md5-hash-generator/</a> enter your desired combination to generate a new key.

<strong>Sources Code:</strong>

Uechi.APM.Web

- Sources are available on GitHub:

Version 1.0.0 - <a href="https://github.com/paulouechi/Uechi.APM.Web" target="_blank">https://github.com/paulouechi/Uechi.APM.Web</a>

Uechi.Service.Socket.Server.Monitor - Linux Version

- Sources are available on GitHub:

Version 1.0.0 - <a href="https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Linux" target="_blank">https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Linux</a>

Uechi.Service.Socket.Server.Monitor - Windows Version

- Sources are available on GitHub:

Version 1.0.0 - <a href="https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Windows" target="_blank">https://github.com/paulouechi/Uechi.APM.Services.Socket.Server.Windows</a>

<strong>information:</strong>

This project was started by the need for a quick simple basic monitoring and target servers. The future idea is to store the information obtained and present a performance history of the monitored servers and in the future maybe even applications.

<strong>Collaboration:</strong>

Camila Nachbar - Camila blog go <a href="https://camilanachbarblog.wordpress.com/" target="_blank">here</a> or contact by email <a href="mailto:camila.nachbar@gmail.com">camila.nachbar@gmail.com</a>.

<strong>Contributions:</strong>

I thank everyone who is interested to contribute and improve the project.

If you are interested in participating, please download the project and make the necessary implementations. After contact by email, in the case of new versions, we can combine releases of projects.

<strong>License:</strong>

Uechi.APM.Web and Uechi.APM.Services.Socket.Server Windows and Linux versions are licensed under the Apache License, Version 2.0. See <a href="https://github.com/naver/pinpoint/blob/master/LICENSE" target="_blank">LICENSE</a> for complete license information.

<strong>Next steps:</strong>

1 - Uechi.APM.Web in ASP.NET version
2 - Enhance details of the data on screen.
3 - Encrypt all communication.

<strong>information:</strong>

Questions or suggestions, please make requests or to comments on my blog at <a href="http://uechi.com.br/uechi-apm-web-eng/">http://uechi.com.br/uechi-apm-web-eng/</a> address or contact by email <a href="mailto:paulouechi@gmail.com">paulouechi@gmail.com</a>.

Informações em Português acesse <a href="http://uechi.com.br/uechi-apm-web/">http://uechi.com.br/uechi-apm-web/</a>.
