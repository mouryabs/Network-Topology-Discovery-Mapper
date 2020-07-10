<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Entries</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/Struts2Beginner/w3.css">
<link rel="stylesheet" href="/Struts2Beginner/third.css">
<link rel="stylesheet" href="/Struts2Beginner/font-awesome.min.css">
</head>
<body class="w3-animate-left w3-light-grey">
<header class="w3-container w3-blue w3-padding">
  <div class="w3-center">
  <h1>Cam Entries</h1>
  </div>
</header>
<!--  	Sum of <s:property value="x"/> 
	and <s:property value="y"/> 
	is: -->
	<div class="w3-container">
	<div class="w3-row">
	<div class="w3-third w3-col"> <h1 style=" visibility:hidden">Hi</h1></div>
	<div class="w3-third w3-col">
	<table class="w3-table w3-border w3-centered">
	 <tr class="w3-dark-grey">
      <th>IPAddress</th>
      <th>MACaddress</th>
    </tr>
    <tr>
    </tr>
    <s:iterator value="addresses" var="add">
    <tr>
    <td><s:property value="IPAddress"/></td>
	<td><s:property value="MacAddress"/></td>
	</tr>
	</s:iterator>

	</table>
	</div>
	<div class="w3-third w3-col"> <h1 style=" visibility:hidden">Nice..</h1></div>
	</div>
	</div>
</body>
</html>