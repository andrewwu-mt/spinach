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

<s:action name="user-all" executeResult="false" />

</head>
<body>
	<div id="content" align="center">
		<h2>User list</h2>
		
		<display:table name="request.customerList" requestURI="user-list" id="resulttable" pagesize="15" class="list2">
	    	<display:column property="email"  title="Email" href="user-edit" paramId="id" paramProperty="customerId"  sortable="true"/>
		    <display:column property="name" title="First Name" sortable="true" />
		    <display:column property="last" title="Last Name" sortable="true"  />
		    <display:column property="insertDate" title="Date" sortable="true" format="{0,date,MM/dd/yyyy HH:mm:ss}" />
		    <display:column title="Manage" sortable="false">
		    	<a class="delete" href="user-delete?customerId=${resulttable.customerId}" onclick="return confirm_delete()"><img title="Delete" src="images/del.png" height="15px" width="15px"/></a>
		    </display:column>
		</display:table>
	</div>  
	
	<br>
	<br>
	<br>
	<br>
	
    <div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
	
</body>
