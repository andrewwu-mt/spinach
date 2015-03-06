<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  
<link rel="icon" type="image/ico" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png">
<head>
	<title>Spinach Store Liquor Indonesia | Checkout</title>
</head>
<jsp:include page="header.jsp" />


<body>
<script src="js/form-check.js" type="text/javascript"></script>

<s:action name="ship-type-all" executeResult="false" />
<s:action name="provinsi-all" executeResult="false" />
<s:action name="kabupaten-get" executeResult="false" >
	<s:param name="provinsiId" value="#parameters.provinsiId"/>
</s:action>

<div class="breadcrumbs  no-margin">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <li><a href="cart-list">Shop</a></li>
            
            <li class="active">Checkout</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="woocommerce  push-down-30">
  <div class="container">
    <div class="row">
     <form action="order-add" method="post" id="form" validate>
      <s:hidden id="exchangeValue" value="%{#request.exchange.value}"/>
      <s:hidden name="customerId" value="%{#request.customer.customerId}" />
      <div class="col-xs-12">
        <h3>Checkout</h3>
        <hr>
      </div>
      <div class="col-xs-12  col-sm-6">
        <h3><span class="light">Billing</span> Address</h3>
        <div class="row" id="billAddr">
        <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Country
                <abbr class="required">
                  *
                </abbr>
              </label>
              <select class="input-text">
                <option value="ID">Indonesia</option>
              </select>
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                First Name
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" value="${request.customer.name}" required name="name">
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Last Name
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" value="${request.customer.last}" name="last">
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Address
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text  push-down-10" placeholder="Street address 1" required value="${request.customer.address}" name="address">
              <input class="input-text" placeholder="Street address 2" value="${request.customer.address2}" name="address2">
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Postcode / Zip
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text  push-down-10" placeholder="Postcode / Zip" value="${request.customer.post}" name="post" required>
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Province
                <abbr class="required">
                  *
                </abbr>
              </label>
              <s:select id="provinsiList" name="provinsiId" list="#request.provinsiList" listKey="provinsiId" listValue="name" cssClass="input-text"  value="%{#request.customer.kabupaten.provinsi.provinsiId}"/>
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                City / District
                <abbr class="required">
                  *
                </abbr>
              </label>
              <s:hidden id="kabId" value="%{#request.customer.kabupaten.kabupatenId}" />
              <s:select id="kabupatenList" name="kabupatenId" list="#request.kabupatenList" listKey="kabupatenId" listValue="name" cssClass="input-text"  value="%{#request.customer.kabupaten.kabupatenId}" />
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Email Address
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" required value="${request.customer.email}" name="email">
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Phone
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" required value="${request.customer.phone}" name="phone">
            </p>
          </div>
        </div>
      </div>
      
      <div class="col-xs-12 col-sm-6">
        <p class="form-row">
          <input class="input-checkbox" type="checkbox" id="chkbox" name="checkbox" value="1">
          Ship to billing address?
        </p>
        <h3><span class="light">Shipping</span> Address</h3>
        <div class="row" id="shipAddr">
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                First Name
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" required name="shipName">
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Last Name
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" name="shipLast">
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Address
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text  push-down-10" placeholder="Street address 1" required name="shipAddr">
              <input class="input-text" placeholder="Street address 2" name="shipAddr2">
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Postcode / Zip
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text  push-down-10" placeholder="Postcode / Zip" required name="shipPost" required>
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Province
                <abbr class="required">
                  *
                </abbr>
              </label>
              <s:select id="provinsiList2" list="#request.provinsiList" listKey="provinsiId" listValue="name" cssClass="input-text" />
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                City / District
                <abbr class="required">
                  *
                </abbr>
              </label>
              <s:select id="kabupatenList2" name="shipKabupatenId" list="#request.kabupatenList" listKey="kabupatenId" listValue="name" cssClass="input-text"  />
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Phone
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" required name="shipPhone">
            </p>
          </div>
	    </div>
      </div>
      
      
      <div class="col-xs-12 col-sm-12">
        <h3><span class="light">Shipping</span> Methods</h3>
        <div class="row">
        	<div class="col-xs-12  col-sm-12  push-down-10">
	          <p>
	            <s:select name="shipTypeId" id="shipTypeList" cssClass="input-text" list="#{'4':'JNE Express (Luar Jawa)'}" />
	          </p>
	        </div>
      	</div>
   	 </div>	
      
      <div class="col-xs-12">
        <!-- Your order - table -->
        <h3><span class="light">Your</span> order</h3>
        <table class="shop_table  push-down-30">
          <thead>
            <tr>
              <th class="product-name">Product</th>
              <th class="product-total">Total</th>
            </tr>
          </thead>
          <tfoot>
			<tr class="cart-subtotal">
              <th>Total bottle</th>
              <td><span class="amount" id="totalBottle">${request.totalBottle}</span> bottle(s)</td>
            </tr>
            <tr class="cart-subtotal">
              <s:hidden name="subtotal" value="%{#request.cartTotal}" />
              <th>Cart Subtotal</th>
              <td>IDR <span class="amount" id="sub"><fmt:formatNumber groupingUsed="true">${request.cartTotal}</fmt:formatNumber></span></td>
            </tr>
            <tr class="shipping">
              <s:hidden name="shippingFee" id="shipping_form" value="" />
              <th>Shipping</th>
              <td>IDR <span class="amount" id="ship"></span></td>
            </tr>
            <tr class="total" id="admin">
              <th><strong>Admin Fee</strong></th>
              <td>IDR <span class="amount" >10,000</span></td>
            </tr>
            <tr class="total">
              <s:hidden name="total" id="total_form" value="" />
              <th><strong>Order Total</strong></th>
              <td>
                <strong>IDR <span class="amount" id="total" ></span></strong>
              </td>
            </tr>
            <tr class="paypal">
        		<th><strong>USD Exchange Rate</strong></th>
        		<td><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.exchange.value}</fmt:formatNumber></span></td>
        	</tr>
        	<tr class="paypal">
        		<th><strong>Paypal Fee</strong></th>
        		<td><span class="amount">3.9% + $0.30 USD per transaction</span></td>
        	</tr>
        	<tr class="paypal">
        		<th><strong>Total Amount Paid</strong></th>
        		<td><strong><span class="amount" id="paypal"></span></strong></td>
        	</tr>
          </tfoot>
          <tbody>
            <s:iterator value="#request.cartList">
	            <tr class="checkout_table_item">
	              <td class="product-name">${value[0]} <strong class="product-quantity">${value[1]} <s:if test="%{value[2] == 1}">Bottle</s:if><s:else>Carton</s:else></strong><br>
	              <td class="product-total"><span class="amount">IDR <fmt:formatNumber groupingUsed="true">${value[3]}</fmt:formatNumber></span></td>
	            </tr>
            </s:iterator>
          </tbody>
        </table>
        <!-- Payment methods -->
        <h3><span id="test" class="light">Payment</span> Methods</h3>
        <div class="payment">
          <ul class="payment_methods">
            <li>
              <input type="radio" id="bca" class="input-radio" name="paymentMethodId" value="1" checked="checked">
              <label class="test">Transfer BCA</label>
            </li>
            <li title="Additional 0.03% charge fee & 0.3 USD / transaction">
              <input type="radio" id="cc" class="input-radio" name="paymentMethodId" value="2" >
              <label>
              	Credit Card
              </label>
            </li>
            <li id="codLi">
              <input type="radio" id="cod" class="input-radio" name="paymentMethodId" value="3" >
              <label>Cash on Delivery</label>
            </li>
          </ul>
          
			    <input type="hidden" name="cmd" value="_xclick">
			    <input type="hidden" name="business" value="spinachstore@gmail.com">
			    <input type="hidden" name="currency_code" value="USD">
			    <input type="hidden" name="item_name" value="Spinachstore Payment">
			    <input type="hidden" id="paypal_total" name="amount" value="">
			
            <button type="submit" id="btn" class="btn btn-warning pull-right">Place Order</button>
        </div>
      </div>
     </form>
    </div>
    <hr class="divider">
  </div>
</div>
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:31 GMT -->
</html>