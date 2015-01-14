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
<script type="text/javascript">
$(document).ready(function(){
	$("#apply").click(function(){
		$("#doupdate").submit();
	});
	
	if(navigator.platform == 'iPhone' || navigator.platform == 'Android' || navigator.platform == 'Blackberry'  ){
		$('.product-thumbnail').each(function(){
			$(this).hide();
		});
		
		$('.product-price').each(function(){
			$(this).text($(this).text().replace('IDR', ''));
		});
		
		$('.product-subtotal').each(function(){
			$(this).text($(this).text().replace('IDR', ''));
		});
	};
});
</script>
<s:action name="type-all" executeResult="false" />

<div class="breadcrumbs  no-margin">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <li class="active">Cart</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="woocommerce  push-down-30">
  <div class="container">
    <div class="row">
      <div class="col-xs-12  push-down-30">
        <h3>Cart</h3>
        <hr>
        <table class="shop-table  shop-cart">
         <s:form action="cart-update" theme="simple" id="doupdate">
          <thead>
            <tr class="cart_table_title">
              <th class="product-remove"></th>
              <th class="product-thumbnail"></th>
              <th class="product-name">Product</th>
              <th class="product-price">Price</th>
              <th class="product-type">Qty.</th>
              <th class="product-subtotal" style="padding-left:1em;">Total</th>
            </tr>
          </thead>
          <tbody>
          
          	<s:iterator value="#request.cartList">
	            <tr class="cart_table_item">
	              <td class="product-remove"><span class="deleteItemCartList glyphicon  glyphicon-remove"><s:hidden cssClass="prodId" value="%{key}"/></span></td>
	              <td class="product-thumbnail"><img src="${value[5]}" width="50" height="50"></td>
	              <td class="product-name"><a href="product-detail?id=${key}">${value[0]}</a></td>
	              <td class="product-price">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${value[4]}</fmt:formatNumber></td>
	              <td class="product-type">
					${value[1]}&nbsp;<s:if test="%{value[2] == 1}" >btl</s:if><s:else>crt</s:else>
	              </td>
	              <td class="product-subtotal">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${value[3]}</fmt:formatNumber></td>
	            </tr>
            </s:iterator>

            <tr class="cart_table_action">
              <td colspan="6" class="actions">
                <div class="col-xs-6">
                  <div class="coupon">
                  	<s:form action="checkout" id="doupdate" >
                    	<input name="coupon_code" class="input-text">
                    	<a href="#" class="btn  btn-warning" id="apply">Use coupon</a>
                    </s:form>
                  </div>
                </div>
                <div class="col-xs-6">
                  <s:if test="%{#request.customer != null}">
                 	<a href="checkout" class="btn  btn-primary  pull-right">Checkout</a>
                  </s:if>
                  <s:else>
                  	<a href="#loginModal" role="button" data-toggle="modal" class="btn  btn-primary  pull-right">Checkout</a>
                  </s:else>
               	  <a href="spirits-list" class="btn  btn-warning  pull-right">Shop</a>
                </div>
              </td>
            </tr>
          </tbody>
         </s:form>
        </table>
      </div>
      <div class="col-xs-12 col-sm-6">
      </div>
      <div class="col-xs-12 col-sm-6">
        <!-- Your order - table -->
        <h3 class="pull-right"><span class="light">Cart</span> Totals</h3>
        <table class="shop_table  push-down-30">
          <tfoot>
            <tr class="cart-subtotal">
              <th>Cart Subtotal</th>
              <td><span class="amount">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${request.cartTotal}</fmt:formatNumber></span></td>
            </tr>
            <tr class="shipping">
              <th>Shipment Fee</th>
              <td>Based on shipping destination</td>
            </tr>
          </tfoot>
        </table>
      </div>
    </div>
    <hr class="divider">
  </div>
</div>
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:31 GMT -->
</html>