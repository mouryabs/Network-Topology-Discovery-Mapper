<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Design of End to End Routing Network Using Switch CAM</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!--
Template 2036 Blue Office
http://www.tooplate.com/view/2036-blue-office
-->
<link href="tooplate_style.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" href="styles.css">

</head>
<body class="subpage">

<div id="tooplate_wrapper1">

	<div id="tooplate_sidebar">
        <div id="site_title"><a href="#"><span></span></a></div>
		
		
			<div id="cssmenu">

           <ul>
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
             
          </div> 
		 
		  <br></br>
		  <br></br>
	</div> <!-- end of sidebar -->
   
    <div id="tooplate_main">
    	
        <div id="tooplate_menu">
            <ul>
               <li><a href="index.jsp">Home</a></li>
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="services.jsp">Services</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>    	
        </div> <!-- end of tooplate_menu -->
        
        <div id="content_title_box">
	        <h2>Hello User</h2>
			<p>This section provides you the list of services you are allowed to use.</p>
        </div>

    <div class="cleaner"></div>    



	<div id="tooplate_content">
		<div class="service_box">
			<h1><CENTER>Please select a service</CENTER><h1>
			 <br></br>
			 <br></br>
			 <br></br>

		</div>
	</div>
	
</div> <!-- end of wrapper -->
 <div class="cleaner"></div> 
 </div>
<div id="tooplate_footer_wrapper">
	<div id="tooplate_footer">
		<a>Copyright © 2015 - Designer: Ashwini Sreedhar </a> 
    </div>
</div>

</body>
</html>