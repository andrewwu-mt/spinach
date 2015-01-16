<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  
<link rel="icon" type="image/ico" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png">
<body>
<jsp:include page="header.jsp" />

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

<div class="breadcrumbs  no-margin">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <li><a href="cart-list">Shop</a></li>
            
            <li><a href="checkout">Checkout</a></li>
            
            <li class="active">Order Receipt</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="woocommerce  push-down-30">
  <div class="container">
    <h3><span class="light">Order</span> Receipt</h3>
    <hr>
    <p>Thank you. Your order has been received.</p>
    <ul class="order_details">
      <li class="order">
        Order: <strong>#<s:property value="#request.ship.shipId" /></strong>
      </li>
      <s:if test="%{#request.ship.paymentMethod.paymentMethodId == 2}">
	      <li class="order">
	        Paypal: <strong>#<s:property value="#request.ship.txnId" /></strong>
	      </li>
      </s:if>
      <li class="date">
        Date: <strong><s:date name="%{#request.ship.insertDate}" format="MMM dd, yyyy" /></strong>
      </li>
      <li class="total">
        Total: <strong><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.ship.total}</fmt:formatNumber></span></strong>
      </li>
      <li class="method">
        Payment method: <strong>${request.ship.paymentMethod.name}</strong>
      </li>
      <li class="method">
        Status: <strong><s:if test="%{#request.ship.status == 0}"><font style="color:red;">UNPAID</font></s:if><s:else><font style="color:green;">PAID</font></s:else></strong>
      </li>
    </ul>
    <br>
    <p>Please check your email for detailed information about payment and shipping arrival time.</p>
    <h2><span class="light">Order</span> Details</h2>
    <table class="shop_table  push-down-30">
      <thead>
        <tr>
          <th class="product-name">Product</th>
          <th class="product-total">Total</th>
        </tr>
      </thead>
      <tfoot>
        <tr class="cart-subtotal">
          <th>Cart Subtotal</th>
          <td><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.ship.subtotal}</fmt:formatNumber></span></td>
        </tr>
        <tr class="shipping">
          <th>Shipping</th>
          <td><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.ship.fee}</fmt:formatNumber></span></td>
        </tr>
        <s:if test="%{#request.ship.paymentMethod.paymentMethodId == 3}">
        	<tr class="shipping">
        		<th>Admin Fee</th>
            	<td><span class="amount">IDR 10,000</span></td>
        	</tr>
        </s:if>
        <tr class="total">
          <th><strong>Order Total</strong></th>
          <td>
            <strong><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.ship.total}</fmt:formatNumber></span></strong>
          </td>
        </tr>
        
        <s:if test="%{#request.ship.paymentMethod.paymentMethodId == 2}">
        	<s:hidden id="rate" value="%{#request.exchange.value}" />
        	<s:hidden id="total" value="%{#request.ship.total}" />
        	<tr>
        		<th><strong>USD Exchange Rate</strong></th>
        		<td><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.exchange.value}</fmt:formatNumber></span></td>
        	</tr>
        	<tr>
        		<th><strong>Paypal Fee</strong></th>
        		<td><span class="amount">3.9% + $0.30 USD per transaction</span></td>
        	</tr>
        	<tr>
        		<th><strong>Total Amount Paid</strong></th>
        		<td><strong><span class="amount" id="paypal_total"></span></strong></td>
        	</tr>
        </s:if>
        
      </tfoot>
      <tbody>
        <s:iterator value="#request.ship.orders" id="inner">
	         <tr class="checkout_table_item">
	           <td class="product-name">${inner.product.shortName} <strong class="product-quantity">${inner.amount} <s:if test="%{#inner.type == 1}">Bottle</s:if><s:else>Carton</s:else></strong><br>
	           <td class="product-total"><span class="amount">IDR <fmt:formatNumber groupingUsed="true">${inner.price}</fmt:formatNumber></span></td>
	         </tr>
        </s:iterator>
      </tbody>
    </table>
    <header class="title">
      <h3><span class="light">Customer</span> details</h3>
    </header>
    <dl class="customer_details">
      <dt>First Name:</dt>
      <dd>${request.ship.customer.name}</dd>
      <dt>Last Name:</dt>
      <dd>${request.ship.customer.last}</dd>
      <dt>Email:</dt>
      <dd><a class="__cf_email__" href="http://www.gmail.com" target="_blank">${request.ship.customer.email}</a></dd>
      <dt>Phone:</dt>
      <dd>${request.ship.customer.phone}</dd>
    </dl>
    <div class="row">
      <div class="col-xs-12  col-sm-6">
        <header class="title">
          <h3><span class="light">Billing</span> Address</h3>
        </header>
        <address>
          <p>
            ${ship.customer.address}<br>
           	${ship.customer.address2}<br>
            ${ship.customer.post}<br>
            ${ship.customer.kabupaten.name}<br>
            Indonesia
          </p>
        </address>
      </div>
      <div class="col-xs-12  col-sm-6">
        <header class="title">
          <h3><span class="light">Shipping</span> Address</h3>
        </header>
        <address>
          <p>
            ${ship.shipAddress}<br>
           	${ship.shipAddress2}<br>
            ${ship.shipPost}<br>
            ${ship.shipKabupaten.name}<br>
            Indonesia
          </p>
        </address>
      </div>
    </div>
    <hr class="divider">
  </div>
</div>
  
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/order-received.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:31 GMT -->
</html>