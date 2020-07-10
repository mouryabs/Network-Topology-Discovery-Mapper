<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Design of End to End Routing Network Using Switch CAM</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="tooplate_style.css" rel="stylesheet" type="text/css" />

<script>
function ValidateForm(inputText,inputPassword)  
 {  
 var formatText = /^([a-zA-Z0-9]*)$/;
 
 
 if(inputText.value.match(formatText)&&inputPassword.value.match(formatText))  
 {  
 //document.portInformation.action.switchIPAddress.focus();  
 return true;  
 }  
 else  
 {  
 alert("You have entered an invalid user name and password!");  
// document.form1.text1.focus();<br>return false;  
 }  
 }
</script>

</head>
<body class="home" onload='document.form1.username.focus()'>

<div id="tooplate_wrapper">

	<div id="tooplate_sidebar">
		<div id="site_title"><a href="#">    </a></div> 
        <div class="sidebar_box">
        	<h4>LOGIN HERE!!</h4>	
			
			<div id="newsletter_box">
			 <form action="doLogin.action" method="get">		
			Please enter your user name and password to login<br />
			<br></br>
			<h6>USER NAME</h6>
			<form name="form1" action="#">
			<input type="text" id="username" name="username" class="username" />	
			<h6>PASSWORD</h6>			
			<input type="password" id="password" name="password" class="password" />		
            <input type="submit" name="submit" id="submit" value="Submit" onclick="ValidateForm(username,password)"/></form>
		
            </form>
			<br></br>
			<br></br>
			<br></br>
			<br></br>
			</div>		
			
            <div class="cleaner"></div>
        </div>		
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
	        
			<p>Please provide valid login credentials</p>
			
        </div>

    <div class="cleaner"></div>    



	</div>
	
    <div class="cleaner"></div>    
</div> <!-- end of wrapper -->

<div id="tooplate_footer_wrapper">
	<div id="tooplate_footer">

        <!--<a href="index.html">Home</a> | <a href="about.html">About Us</a> | <a href="services.html">Services</a> | <a href="gallery.html">Gallery</a> | <a href="contact.html">Contact</a> <br /><br />-->
        
        <a>Copyright © 2015 - Designer: Ashwini Sreedhar </a>
		
    </div>
</div>

</body>
</html>