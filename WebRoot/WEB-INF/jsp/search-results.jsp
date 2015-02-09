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

<s:action name="payment-cancel" executeResult="false">
	<s:param name="shipId" value="#parameters.id" />
</s:action>

<div class="breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <li class="active">Search Results</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="container  push-down-30">
  <div class="row">
    <div class="col-xs-12 ">
      <h3><span class="light">Search</span> Results <span class="light">- "${request.searchKeyword}"</span></h3>
      <hr>
      <div class="shop-list">
	    <div class="row  js--isotope-container">
        <s:iterator value="#request.productList">    
             <div class="js--isotope-target  js--cat-${category.categoryId}" data-price="${priceBottle}" data-rating="5">
			  <div class="col-xs-6 col-sm-3">
			    <div class="products__single">
			      <div class="products__image  push-down-15">
			        <a href="product-detail?id=${productId}">
			          <img alt="#" class="product__image" width="263" height="334" src="${src}">
			        </a>
			        <div class="product-overlay">
			          <a class="product-overlay__more" href="product-detail?id=${productId}">
			            <span class="glyphicon glyphicon-search"></span>
			          </a>
			          <a class="product-overlay__cart addToCart" href="javascript:void(0)">
				          <s:hidden cssClass="productId" value="%{productId}"/>
				          <s:hidden cssClass="priceBottle" value="%{priceBottle}"/>
				          <s:iterator value="stocks">
							<s:if test="%{number != 0}">
				            	<s:hidden cssClass="stat" value="1"/>
							</s:if>
							<s:else>
				            	<s:hidden cssClass="stat" value="0"/>
							</s:else>
						  </s:iterator>
				          +<span class="glyphicon glyphicon-shopping-cart"></span>
				        </a>
			          <div class="product-overlay__stock">
			            <s:iterator value="stocks">
							<s:if test="%{number != 0}">
								<span class="in-stock">&bull;</span> <span class="in-stock--text">In Stock</span>
							</s:if>
							<s:else>
								<span class="out-of-stock">&bull;</span> <span class="in-stock--text">Out of Stock</span>
							</s:else>
						</s:iterator>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-9">
			    <br>
			    <div class="products__title">
			      <a class="products__link  js--isotope-title" href="product-detail?id=${productId}"><strong>${name}</strong></a>
			    </div>
			    <div class="products__category">
			    	btl&nbsp;<span class="products__price">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${priceBottle}</fmt:formatNumber></span><br>
			    	crt&nbsp;<span class="products__price">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${priceBox}</fmt:formatNumber></span><br><br>
			    </div>
			    <p>
			    ${aboutProduct}
			    </p>
			  </div>
		  </div>
        </s:iterator>
            
        </div>
      </div>
      <hr class="blog-last-divider">

    </div>
  </div>
</div>
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/search-results.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:44 GMT -->
</html>