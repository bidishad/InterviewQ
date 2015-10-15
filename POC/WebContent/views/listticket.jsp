<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/"/>
<link href="${baseurl}css/css.css" rel="stylesheet">

<script src="${baseurl}js/main.js"></script>

</head>
<body ng-app = "myApp">
	<div id="wrapper" ng-controller = "TicketController" ng-init="getTickets()">
		<table cellspacing="0">
			<thead>
				<tr>
					<h1>Ticker List</h1>
				</tr>
				<tr>
					<th> Ticket Number</th>
					<th> Ticket Comments </th>
					<th> Ticket Status </th>
				</tr>
			</thead>
			<tbody>
				<tr class= "even" ng-repeat='ticket in tickets'>
					<td>{{ticket.ticketnumber}}</td>
					<td>{{tikcet.comments}}</td>
					<td>{{ticket.status}}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>