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

</head>
<body>
	<div id="content" align="center">
	
		<table class="list">
			<caption>
				<h2>Order detail</h2>
				<br>
				<hr>
				<br>
			</caption>
			<tr>
				<th>Item name</th>
				<th>Amount</th>
				<th>Amount type</th>
				<th>Total price</th>
			</tr>
			
			<s:iterator value="orderList">
				<tr>
	                <td><s:property value="product.name"/></td>
	                <td><s:property value="amount"/></td>
	                <td>
		                <s:if test="%{type == 1}">Bottle</s:if>
		                <s:else>Carton</s:else>
	                </td>
	                <td>IDR <fmt:formatNumber groupingUsed="true"><s:property value="price"/></fmt:formatNumber></td>
               </tr>
              </s:iterator>
		</table>
		
		<br>
		<br>
		
	</div>  
    <div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
</body>