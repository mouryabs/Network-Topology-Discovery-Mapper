<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Design of End to End Routing Network Using Switch CAM</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<title>Design of End to End Routing Network Using Switch CAM</title>

<!--
Template 2036 Blue Office
http://www.tooplate.com/view/2036-blue-office
-->
<link href="tooplate_style.css" rel="stylesheet" type="text/css" />

</head>
<body class="subpage">

<div id="tooplate_wrapper1">

	<div id="tooplate_sidebar">
        <div id="site_title"><a href="#"><span></span></a></div>
		
			<div id="newsletter_box">
			<h6><a href ="userSwitchInfo.jsp"><CENTER>SWITCH INFORMATION</CENTER></a></h6>
			<br></br>
            <h6><a href ="userSwitchTopology.jsp"><CENTER>SWITCH TOPOLOGY</CENTER></a></h6>
            <br></br>
            <h6><a href="userPortDetails.jsp"><CENTER>SWITCH PORT DETAILS</CENTER></a></h6>
            <br></br>
            <h6><a href="userConnectivityOfNode.jsp"><CENTER>NETWORK NODE CONNECTIVITY</CENTER></a></h6>
             
          </div> 
	</div> <!-- end of sidebar -->
   
    <div id="tooplate_main">
    	
        <div id="tooplate_menu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="services.jsp">Services</a></li>
                <li><a href="contact.jsp">Contact</a></li>
        </div> <!-- end of tooplate_menu -->
        
        <div id="content_title_box">
	        <h2>Hello User</h2>
			<p>Add a switch to database.</p>
        </div>

    <div class="cleaner"></div>    



	<div id="tooplate_content">
		<div class="service_box">
			<form action="switchInformation.action" method="get">
			<p>Please enter the switch IP Address</p>
           	<h6>SWITCH IP ADDRESS</h6>
			<input type="text" id="switchIPAddress" name="switchIPAddress" class="switchIPAddress" />	
			 <input type="submit" name="submit" id="submit" value="Submit" />
			 </form>
		</div>
	</div>
	
</div> <!-- end of wrapper -->
<div id="tooplate_footer_wrapper">
	<div id="tooplate_footer">
		<a>Copyright © 2015 - Designer: Ashwini Sreedhar </a> 
    </div>
</div>

</body>
</html>