<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/Struts2Beginner/w3.css">
<link rel="stylesheet" href="/Struts2Beginner/font1.css">
<link rel="stylesheet" href="/Struts2Beginner/font2.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-navbar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>

<body class="w3-animate-top">
<div class="w3-container w3-blue w3-center w3-padding-128">
  <h1 class="w3-margin w3-jumbo w3-animate-opacity">ISRO</h1>
  <p class="w3-xlarge w3-animate-zoom">Network Topology Mapping</p>
  <s:form action="calculateSumAction" method="post">
  <button class="w3-btn w3-padding-xlarge w3-large w3-margin-top" value="Calculate">Get Started</button>
  </s:form>
</div>
	<!--  <center>
		<h2>Calculate sum of two numbers</h2>
		<s:form action="calculateSumAction" method="post">
			<s:textfield name="x" size="10" label="Enter X" />
			<s:textfield name="y" size="10" label="Enter Y" />
			<s:submit value="Calculate" />
		</s:form>
	</center> -->
<div class="w3-container w3-blue w3-center w3-padding-64">
    <h1 class="w3-margin w3-xlarge"></h1>
</div>
	
</body>
</html>