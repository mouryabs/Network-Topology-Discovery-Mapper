<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html"%>
<%@ page language="java" import="Vector.*" %>
<%@ page language="java" import="Iterator.*" %>
<%@ page language="java" import="util.*" %>
<%@ page language="java" import="Map.*" %>      
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    
<script type="text/javascript" src="jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<style type="text/css">  
</style>  
</head>
<body>
  <nav class="light-blue lighten-1 " role="navigation" id="nav">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">ISRO</a>
      
      <ul class="right hide-on-med-and-down">
        <li><a href="contact.jsp">Contact</a></li>
      </ul>
        
      <ul class="right hide-on-med-and-down">
        <li><a href="services.jsp">Services</a></li>
      </ul>
        
      <ul class="right hide-on-med-and-down">
        <li><a href="about.jsp">About Us</a></li>
      </ul>
        
      <ul class="right hide-on-med-and-down">
        <li><a href="index.jsp">Home</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
    
  <ul id="slide-out" class="side-nav fixed grey lighten-2" style="padding-top:75px">
      <li><a href ="userSwitchInfo.jsp"><font size=3px>Switch Information</font></a></li>
			
           <li><a href ="userSwitchTopology.jsp"><font size=3px>Switch Topology</span></a></li>
            
           <li> <a href="userPortDetails.jsp"><font size=3px>Switch Port Details</span></a></li>
           
			<li><a href="userEachPortDetails.jsp"><font size=3px>Each Port Details</span></a></li>
			
           <li> <a href="userConnectivityOfNode.jsp"><font size=3px>Network Node Connectivity</span></a></li>
			
			
			<s:url action="vlanInformation" id="vlanInfo"></s:url>
			<li><s:a href="%{vlanInfo}" ><font size=3px>VLAN Information</span></s:a></li>
			
			<s:url action="snmpDisabledSwitchInformation" id="snmpDisabledSwitchInfo"></s:url>
			<li><s:a href="%{snmpDisabledSwitchInfo}" ><font size=3px>SNMP Disabled Switch List</span></s:a></li>
			
			<s:url action="printerInformation" id="printerInfo"></s:url>
			<li><s:a href="%{printerInfo}" ><font size=3px>Printer list</span></s:a></li>
  </ul>  
  <div class="row container" style="padding-left:200px" id="main">
    	<br>		
    	<form action="eachPortInformation.action" method="get">
			<div class="TablePreviewBox">
					
			<div class="CSSTableGenerator">
			<table class="striped centered">		
			<thead>
			<tr>
					<td>Switch IP Address</td>
					<td>Port Number</td>
					<td>Port Status</td>
					<td>Number Of In Packets</td>
					<td>Number Of Out Packets</td>
					
					</tr>
					</thead>
					<tbody>
					<tr>
					<s:iterator value="list">
					<s:url action="userSwitchInformation" id="switchInfo">
					<s:param name="switchIPAddress" value="switchIPAddress"/></s:url>
					<td><s:a href="%{switchInfo}" ><font color= "#0f3252"><s:property value="switchIPAddress"/></s:a><br></td>
					<td><s:property value="portNum"/><br></td>
					<td><s:property value="portStatus"/><br></td>
					<td><s:property value="numOfInPackets"/><br></td>
					<td><s:property value="numOfOutPackets"/><br></td>
					</tr>
					</s:iterator>
					</tbody>
					
			</table>
			</div>
			</div>
			 </form>  
  </div>
 <footer class="page-footer orange" id="footer">
<div class="footer-copyright">
      <div class="container">
      Made by Nishant
      </div>
</div>    
</footer>
</body>
<script type="text/javascript">
var navBar = document.getElementById("nav");
var sideBar = document.getElementById("slide-out");
    sideBar.style.marginTop = navBar.offsetHeight+"px";
    var footer = document.getElementById("footer");
    var mainArea = document.getElementById("main");
        main.style.height= window.innerHeight-navBar.offsetHeight-footer.offsetHeight-21+"px";
        sideBar.style.height = window.innerHeight-navBar.offsetHeight-footer.offsetHeight+"px";
</script>
</html>