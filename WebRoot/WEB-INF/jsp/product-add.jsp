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
<s:action name="type-all" executeResult="false" />
<s:action name="category-all" executeResult="false" />

</head>
<body>
	<div id="content" align="center">
	
		<table class="list">
			<s:form action="product-save" validate="true" id="doupdate" cssClass="list2" namespace="/" method="POST" enctype="multipart/form-data" >
				<tr>
					<th>Field</th>
					<th>Value</th>
				</tr>
				
				<tr>
					<td>Image</td>
					<td>
						<s:file name="fileUpload" style="width: 200px" />
					</td>
				</tr>
				
				<s:select list="%{#request.typeList}" name="typeId" listKey="typeId" listValue="name" label="Type" />
				<s:select list="%{#request.categoryList}" name="categoryId" listKey="categoryId" listValue="name" label="Category" />
				<s:textfield name="name" label="Name" size="50" />
				<s:textfield name="description" label="Description" size="50" />
				<s:textfield name="priceBox" label="Price Box" size="50" />
				<s:textfield name="priceBottle" label="Price Bottle" size="50" />
				<s:textfield name="shortName" label="Short Name" size="50" />
				<s:select name="active" label="Active" list="#{'1':'True', '0':'False'}" />
				<s:textarea name="aboutProduct" label="About" cssStyle="resize:none;height:100px;width:500px" />
				
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