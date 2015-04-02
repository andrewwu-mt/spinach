<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
	<link rel="icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
	<link rel="shortcut icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
	
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>Spinach Store Liquor Indonesia | Order Line</title>
	<meta name="description" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer." />    
    <meta name="keywords" content="jual, miras, liquor, indonesia, jakarta, wine, spirits, beer,spinach, spinachstore, store, online, shop, murah, harga, berkualitas" />  
    <meta name="robots" content="INDEX,FOLLOW" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
	<link rel="shortcut icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
</head>
<jsp:include page="header.jsp" />

<body>

<script>
	$(document).ready(function(){
		var total = $("#total").val();
		var rate = $("#rate").val();
		var usd = ((total/rate)*1.04)+0.3;
		
		$("#paypal_total").text("$"+Math.ceil(usd));
		
	});
</script>

<s:action name="ship-get" executeResult="false">
	<s:param name="shipId" value="#parameters.id" />
</s:action>
<s:action name="exchange-get" executeResult="false">
	<s:param name="exchangeId" value="1" />
</s:action>

<div class="woocommerce  push-down-30">
  <div class="container" align="left">
  	Order <s:date name="%{#request.ship.insertDate}" format="MMM dd, yyyy" /> - <s:if test="%{#request.ship.status == 0}">Belum Lunas</s:if><s:else>Lunas</s:else>
  	<br>
  	<br>
  	${request.ship.paymentMethod.name}
  	<br>
  	<br>
  	Order:
  	<br>
  	<s:iterator value="#request.ship.orders" id="inner">
	    ${inner.product.shortName} ${inner.amount} <s:if test="%{#inner.type == 1}">Bottle</s:if><s:else>Carton</s:else> IDR <fmt:formatNumber groupingUsed="true">${inner.price}</fmt:formatNumber><br>
    </s:iterator>
    Cart Subtotal - IDR <fmt:formatNumber groupingUsed="true">${request.ship.subtotal}</fmt:formatNumber><br>
    Shipping - IDR <fmt:formatNumber groupingUsed="true">${request.ship.fee}</fmt:formatNumber><br>
    <s:if test="%{#request.ship.paymentMethod.paymentMethodId == 3}">Admin Fee - IDR 10,000<br></s:if>
    Order Total - IDR <fmt:formatNumber groupingUsed="true">${request.ship.total}</fmt:formatNumber>
    <br>
    <br>
    <s:if test="%{#request.ship.customer.name != #request.ship.shipName}">
	  	Reseller:
	    <br>
	  	${request.ship.customer.name} ${request.ship.customer.last}
	    <br>
	    <br>
    </s:if>
  	Nama:
    <br>
  	${request.ship.shipName} ${request.ship.shipLast}
    <br>
    <br>
  	Alamat:
    <br>
    ${ship.shipAddress}<br>
    ${ship.shipAddress2}<br>
    <br>
    <br>
    Hp. ${ship.shipPhone}
    <br>
    <br>
    Pesan dari buyer:
    <br>
    ${ship.comment}
  
  </div>
</div>
  
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/order-received.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:31 GMT -->
</html>