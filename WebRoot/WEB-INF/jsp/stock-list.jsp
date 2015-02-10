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
<script>
$(document).ready(function(){
	$("#btn").click(function(){
		$("#doupdate").submit();	
	});
	
});
</script>
</head>
<body>
	<div id="content" align="center">
		<table class="list2">
		<s:form action="stock-update" theme="simple" method="post" id="doupdate">
				<caption>
					<h2>Stock list</h2>
					<br>
					<input id="btn" type="button" value="Update" class="submit-rounded"/>
					<br>
					<a href="product-add">Add product</a>
					<br>
					<hr>
					<br>
				</caption>
				<tr>
					<th>Item name</th>
					<th>Stock</th>
					<th>Modify Stock</th>
					<th>Status</th>
				</tr>
				
				<s:iterator value="stockList">
						<tr>
			                <td><a href="product-edit?id=${product.productId}"><s:property value="%{product.name}" /></a></td>
			                <td><s:property value="%{number}" /></td>
			                <td><s:textfield name="numbers" /></td>
			                <td>
			                	<s:if test="%{product.active == 1}">
			                		<font color="green"><strong>Active</strong></font>
			                	</s:if>
			                	<s:else>
			                		<font color="red"><strong>Inactive</strong></font>
			                	</s:else>
			                </td>
		                </tr>
				</s:iterator>
		</s:form>
			</table>
		<br>
		<br>
		<br>
		
				
	</div>  
<div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
</body>