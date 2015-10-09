<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="other.UserInfoSinlgeton" import="java.lang.Math" isErrorPage="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome </title>

</head>
<form action="MyLogTicket" name = "MyLogTicket">
<%!
	double generateTicketNumber(){
	    return Math.random();
	}
%>
Ticket Number : <% generateTicketNumber(); %><br/><br/>
Comments : <input type="text" name="comments"/><br/><br/>
Status: 
<html:select property="status" >
<html:option value="0">Select Status</html:option> 
<html:optionsCollection name="InputForm" property="countryList"label="statusName" value="statusId" /> 
</html:select>

</form>
<body>
</body>
</html>