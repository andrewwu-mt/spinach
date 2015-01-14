<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="zh-TW">

<head>
<meta charset="UTF-8">
<jsp:include page="header-2.jsp" />	

</head>
<body>
		<div id="content">
			<s:form action="login" namespace="/" validate="true" id="login-form" theme="simple">
				<label>Account:</label>
				<s:textfield name="username" cssClass="rounded-corners" />&nbsp;&nbsp;&nbsp;
				<label>Password:</label>
				<s:password name="password" cssClass="rounded-corners" />&nbsp;
				<a href="#" onclick="$('#login-form').submit();" class="rounded-corners">Login</a>		
			</s:form>
		</div>  


<div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
</body>