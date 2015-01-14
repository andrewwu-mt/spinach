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

<s:action name="user-get" executeResult="false">
	<s:param name="customerId" value="#parameters.id" />
</s:action>
<s:action name="kabupaten-all" executeResult="false" />

</head>
<body>
	<div id="content" align="center">
		<h2>User edit</h2>
		
		<table>
    		<s:form action="user-update" validate="true" id="doupdate" cssClass="list2">
				<tr>
					<th>Field</th>
					<th>Value</th>	
				</tr>
	 			<s:hidden name="customerId"  value="%{#request.customer.customerId}" />
	 		    <s:textfield name="name" label="Name" value="%{#request.customer.name}" size="50" />
	 		    <s:textfield name="last" label="Last" value="%{#request.customer.last}" size="50" />
	 		    <s:textfield name="password" label="Password" value="%{#request.customer.password}" size="50" />
	 		    <s:textfield name="email" label="Email" value="%{#request.customer.email}" size="50" />
	 		    <s:textfield name="phone" label="Phone" value="%{#request.customer.phone}" size="50" />
	 		    <s:select list="%{#request.kabupatenList}" name="kabupatenId" listKey="kabupatenId" listValue="name" label="Kabupaten" value="%{#request.customer.kabupaten.kabupatenId}" />
	 		    <s:textfield name="address" label="Address 1" value="%{#request.customer.address}" size="50" />
	 		    <s:textfield name="address2" label="Address 2" value="%{#request.customer.address2}" size="50" />
	 		    <s:textfield name="post" label="Postal Code" value="%{#request.customer.post}" size="50" />
	 		    
	 			<tr>
	  		    	<td colspan="2" align="right"><div class="button-wrapper"><button class="submit">Submit</button></div></td>
	  		    </tr>
  			</s:form>
    	</table>
	</div>  

    <div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
	
</body>
