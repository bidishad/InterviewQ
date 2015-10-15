<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<ul class="form-style-1">
		<li>
			<label>Ticket Area: <span class="required">*</span></label>
			<select name="field9" class="field-select" id="area">
              <option value="Delivery Status">Delivery Status </option>
       		  <option value="Product Information">Product Information</option>
         	  <option value="Return Related Query">Return Related Query</option>
             <option value="Defective Product">Defective Product</option>        
        	</select>
		</li>
		<li><label>Customer Information:<span class="required">*</span></label>
    		<input type="text" name="field1" id="firstname" class="field-divided" />&nbsp;
    		<input type="text" name="field2" id="lastname" class="field-divided" />
    	</li>
    	<li>
        	<label>Problem Description<span class="required">*</span></label>
        	<textarea id="description" name="field5" id="field5" class="field-long field-textarea"></textarea>
    	</li>
    	<li>
        	<input type="button" onclick="logTicket()" value="Log Ticket"/>
    	</li>
	</ul>
</form>
function logTicket()
{
	var data = {}
	data.description = $('#description').val();
	data.customer={};
	data.customer.firstName = $('#firstname').val();
	data.customer.lastName = $('#lastname').val();
}
</body>
</html>