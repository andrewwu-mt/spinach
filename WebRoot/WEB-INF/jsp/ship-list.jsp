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
<s:action name="ship-all" executeResult="false" >
	<s:param name="month" value="#parameters.month" />
	<s:param name="year" value="#parameters.year" />
</s:action>

<script>
$(document).ready(function(){
	var url = location.href;
	url = url.replace("&", ",");
	
	$(".payment").each(function(){
		var href = $(this).attr('href');
		$(this).attr('href', href+"&path="+url);
	});

	$(".delete").each(function(){
		var href = $(this).attr('href');
		$(this).attr('href', href+"&path="+url);
	});
});
</script>

</head>
<body>
	<div id="content" align="center">
		<h2>Shipment list</h2>
		<br>
		
		<s:form action="ship-list" method="get" theme="simple">
			<s:select name="year" list="#{2014 : 2014, 2015:2015, 2016:2016}" value="%{#request.year}" />
			<s:select name="month" list="#{'0':'All', '1':'January', '2':'Febuary', '3':'March', '4':'April', '5':'May', '6':'June', '7':'July', '8':'August', '9':'September', '10':'October', '11':'November', '12':'December'}" value="%{#request.month}" /><br/>
			<br>
			<button class="submit">Search</button>
			<br>
			<br>
			<display:table name="request.shipList" requestURI="ship-list" id="resulttable" pagesize="20" defaultsort="11" defaultorder="ascending" class="list2">
			    <display:column title="Property" sortable="true">
<!-- 				<a class="delete" href="ship-detail?shipId=${resulttable.shipId}" ><img title="Order detail" src="images/info.png" height="15px" width="15px"/></a> -->
				<a href="order-received?id=${resulttable.shipId}" ><img title="Receipt" src="images/order.png" height="15px" width="15px"/></a>
			    	<a class="delete" href="ship-del?shipId=${resulttable.shipId}" onclick="return confirm_delete()"><img title="Delete" src="images/del.png" height="15px" width="15px"/></a>
			    </display:column>
			    <display:column property="customer.name" title="Bill Name" sortable="true" />
			    <display:column property="shipName" title="Ship Name" sortable="true"  />
			    <display:column title="Ship Address" sortable="true" >
			    	${resulttable.shipAddress} ${resulttable.shipAddress2}, <strong>${resulttable.shipKabupaten.name}</strong>
			    </display:column>
			    <display:column property="shipPhone"  title="Ship Phone" sortable="true"  />
			    <display:column title="Payment" sortable="true"  >
                                ${resulttable.paymentMethod.name}
                            </display:column>
			    <display:column title="Subtotal" sortable="true"  >
			    	<fmt:formatNumber groupingUsed="true">${resulttable.subtotal}</fmt:formatNumber>
			    </display:column>
			    <display:column title="Shipping" sortable="true"  >
			    	<fmt:formatNumber groupingUsed="true">${resulttable.fee}</fmt:formatNumber>
			    </display:column>
			    <display:column title="Admin Fee" sortable="true" >
			    	<c:choose>
			    		<c:when test="${resulttable.paymentMethod.paymentMethodId eq 3}">
						10,000
					</c:when>
					<c:otherwise>
						0
					</c:otherwise>
				</c:choose>
			    </display:column>
			    <display:column title="Total" sortable="true"  >
			    	<fmt:formatNumber groupingUsed="true">${resulttable.total}</fmt:formatNumber>
			    </display:column>
			    <display:column title="Status" sortable="true" >
			    	<a class="payment" href="ship-update-status?shipId=${resulttable.shipId}&status=${resulttable.status}">
			    		<c:choose>
				    		<c:when test="${resulttable.status eq 0}">
				    			<font color="red"><strong>UNPAID</strong></font>
							</c:when>
							<c:otherwise>
								<font color="green"><strong>PAID</strong></font>
							</c:otherwise>
						</c:choose>
	               	</a>
			    </display:column>
			    <display:column property="insertDate"  title="Date" sortable="true" format="{0,date,dd MMM yyyy}" />
			    <display:column property="insertDate"  title="Time" sortable="true" format="{0,date,HH:mm}" />
			</display:table>
		</s:form>
		
		Subtotal: <fmt:formatNumber groupingUsed="true">${request.subtotal}</fmt:formatNumber><br>
		Fee: <fmt:formatNumber groupingUsed="true">${request.fee}</fmt:formatNumber><br>
		Total: <fmt:formatNumber groupingUsed="true">${request.total}</fmt:formatNumber><br>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		
	</div>  

    <div id="footer">Copyright©2014 Spinach All Rights Reserved</div>
	
</body>
