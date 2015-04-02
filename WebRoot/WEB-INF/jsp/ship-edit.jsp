<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="zh-TW">

<head>
<meta charset="UTF-8">
<jsp:include page="header-2.jsp"/>
<s:action name="kabupaten-all" executeResult="false" />

</head>
<body>
	<div id="content" align="center">
	
		<table class="list">
			<s:form action="ship-update" validate="true" id="doupdate" cssClass="list2">
				<s:hidden name="shipId" value="%{#request.ship.shipId}" />
			
				<tr>
					<th>Field</th>
					<th>Value</th>
				</tr>
				
				<s:textfield name="shipAddress" label="Ship Address 1" value="%{#request.ship.shipAddress}" size="50" />
				<s:textfield name="shipAddress2" label="Ship Address 2" value="%{#request.ship.shipAddress2}" size="50" />
				<s:select list="%{#request.kabupatenList}" name="kabupatenId" listKey="kabupatenId" listValue="name" label="Kabupaten" value="%{#request.ship.shipKabupaten.kabupatenId}" />
				<s:textfield name="shipPhone" label="Ship Phone" value="%{#request.ship.shipPhone}" size="50" />
				<s:textfield name="subtotal" label="Subtotal" value="%{#request.ship.subtotal}" size="50" />
				<s:textfield name="fee" label="Fee" value="%{#request.ship.fee}" size="50" />
				<s:textfield name="total" label="Total" value="%{#request.ship.total}" size="50" />
				<s:select name="status" label="Status" list="#{'0':'UNPAID', '1':'PAID'}" value="%{#request.ship.status}" />
				<s:select name="paymentMethodId" label="Payment Method" list="#{'1':'BCA', '2':'Credit Card', '3':'COD'}" value="%{#request.ship.paymentMethod.paymentMethodId}" />
				<s:textarea name="comment" label="Pesan buyer" value="%{#request.ship.comment}" cssStyle="resize:none;width:550px;height:100px;" />
				
	 			<tr>
	  		    	<td colspan="2" align="right"><div class="button-wrapper"><button class="submit">Submit</button></div></td>
	  		    </tr>
			</s:form>
		</table>
		
		<br>
		<br>
		
	</div>  
    <div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
</body>