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
<script src="js/product-calculate.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	var url = location.href;
	var name = $(".products__category").text();
	
	$("#fb").attr("href", "https://www.facebook.com/sharer/sharer.php?u="+url);
	$("#twe").attr("href", "https://twitter.com/intent/tweet?original_referer="+url+"&text="+name+"&url="+url);
	$("#pin").attr("href", "http://www.pinterest.com/pin/create/button/?url="+url);
	
});
</script>
<s:action name="product-get" executeResult="false">
	<s:param name="productId" value="#parameters.id" /> 
</s:action>
<s:action name="type-all" executeResult="false" />

<div class="breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <s:if test="%{#request.product.type.typeId == 1}">
            	<li><a href="spirits-list">Spirits</a></li>
            </s:if>
            <s:else>
            	<li><a href="wine-list">Wine</a></li>
            </s:else>
            
            <li class="active">${request.product.name}</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>

<div class="container">
  <div class="push-down-30">
    <div class="row">
      <div class="col-xs-12 col-sm-4">
        <div class="product-preview">
          <div class="push-down-20">
            <img class="js--product-preview" alt="Single product image" src="${request.product.src}" width="360" height="458">
          </div>
          <div class="product-preview__thumbs  clearfix">
            <div class="product-preview__thumb  active  js--preview-thumbs">
              <a href=".html" data-src="images/dummy/w360/13.jpg">
                <img src="${request.product.src}" alt="Single product thumbnail image" width="66" height="82"/>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xs-12 col-sm-8">
        <div class="products__content">
        <s:form action="cart-add" method="get" theme="simple" id="form">
			<s:iterator value="#request.product.stocks">
				<s:if test="%{number != 0}">
					<s:hidden name="remainder" value="%{number}" id="remainder"/>
				</s:if>
				<s:else>
					<s:hidden name="remainder" value="0" id="remainder"/>
				</s:else>
			</s:iterator>
			
			
          <div class="push-down-30"></div>
          
          <span class="products__category">${request.product.category.name}</span>
          <h1 class="single-product__title">${request.product.name}</h1>
          
          <span class="single-product__price">IDR&nbsp;<font id="priceBottle"><fmt:formatNumber groupingUsed="true">${request.product.priceBottle}</fmt:formatNumber></font></span>
          
          <div class="in-stock--single-product">
          	<s:iterator value="#request.product.stocks">
				<s:if test="%{number != 0}">
					<span class="in-stock">&bull;</span> <span class="in-stock--text">In Stock <strong>${number}</strong> Ready</span>
				</s:if>
				<s:else>
					<span class="out-of-stock">&bull;</span> <span class="in-stock--text">Out of Stock</span>
				</s:else>
			</s:iterator>
          </div>
          <hr class="bold__divider">
          <p class="single-product__text">
          	Amount / carton is <strong>&nbsp;<font color="darkred" id="desc">${request.product.description}</font>.</strong><br>
          	Price / carton is <strong>&nbsp;<font color="darkred">IDR&nbsp;<font id="priceBox"><fmt:formatNumber groupingUsed="true">${request.product.priceBox}</fmt:formatNumber></font></font>.</strong>
          </p>
          <hr class="bold__divider">
          <!-- Single button -->
          <s:select cssClass="btn  btn-shop" name="type" id="type" list="#{'1':'Bottle', '2':'Carton'}" />
          <!-- Quantity buttons -->
          <div class="quantity  js--quantity">
            <input type="button" value="-" id="dec" class="quantity__button  js--minus-one  js--clickable">
            <input type="text" name="amount" value="1" id="amount" class="quantity__input">
            <input type="button" value="+" id="inc" class="quantity__button  js--plus-one  js--clickable">
          </div>
          <!-- Add to cart button -->
          <a class="btn btn-primary--transition" href="#" id="btn">
			<s:hidden id="productId" value="%{#request.product.productId}"/>
            <s:hidden id="total" name="total" value=""/>
            <span class="glyphicon glyphicon-plus"></span><span class="glyphicon glyphicon-shopping-cart"></span>
            <span class="single-product__btn-text">Add to shopping cart</span>
          </a>
          <!-- Social banners -->
          <div class="row">
            <div class="col-xs-12  col-sm-6  col-md-4">
              <div class="banners--small  banners--small--social">
                <a href="" id="fb" class="social"  onclick="window.open(this.href, 'mywin', 'left=20,top=20,width=800,height=300,toolbar=1,resizable=0'); return false;"><span class="zocial-facebook"></span>
                Share on<br>
                <span class="banners--small--text">Facebook</span>
                </a>
              </div>
            </div>
            <div class="col-xs-12 col-sm-6  col-md-4">
              <div class="banners--small  banners--small--social">
                <a href="" id="twe" class="social" onclick="window.open(this.href, 'mywin', 'left=20,top=20,width=800,height=500,toolbar=1,resizable=0'); return false;"><span class="zocial-twitter"></span>
                Tweet it<br>
                <span class="banners--small--text">Twitter</span>
                </a>
              </div>
            </div>
            <div class="col-xs-12 col-sm-6  col-md-4">
              <div class="banners--small  banners--small--social">
                <a href="" id="pin" class="social" onclick="window.open(this.href, 'mywin', 'left=20,top=20,width=500,height=500,toolbar=1,resizable=0'); return false;"><span class="zocial-pinterest"></span>
                Pin on<br>
                <span class="banners--small--text">Pinterest</span>
                </a>
              </div>
            </div>
          </div>
        </s:form>
        </div>
      </div>
    </div>
  </div>

  <!-- Tabs -->
  <div class="push-down-30">
    <div class="row">
      <div class="col-xs-12">
        <!-- Nav tabs -->
<ul class="nav  nav-tabs">
  <li class="active"><a href="#tabDesc" data-toggle="tab">Description</a></li>
</ul>
<div class="tab-content">
  <div class="tab-pane  fade  in  active" id="tabDesc">
    <h5></h5>
    <p class="tab-text">${request.product.aboutProduct}</p>
  </div>
</div>


      </div>
    </div>
  </div>
</div>
  <jsp:include page="footer.jsp"></jsp:include>
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/single-product.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:30 GMT -->
</html>
