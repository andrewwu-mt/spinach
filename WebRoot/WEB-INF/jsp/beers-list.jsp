<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  
<link rel="icon" type="image/ico" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png">

<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>Spinach Store Liquor Indonesia | Beers List</title>
	<meta name="description" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer. Kami juga menyediakan jasa pengiriman untuk seluruh Indonesia." />    
    <meta name="keywords" content="jual, miras, liquor, indonesia, jakarta, wine, spirits, beer,spinach, spinachstore, store, online, shop, murah, harga, berkualitas" />  
    <meta name="robots" content="INDEX,FOLLOW" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<jsp:include page="header.jsp" />


<body>

<s:action name="category-all" executeResult="false" />
<s:action name="product-all" executeResult="false"/>

<div class="breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <li class="active">Beers</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>

<div class="container">
  <!-- Big banner -->
  <div class="row">
    <div class="col-xs-12  col-sm-3">
      <aside class="sidebar  sidebar--shop">
        <h3 class="sidebar__title"><span class="light">Spinach</span> Store</h3>
        <hr class="shop__divider">
        <div class="shop-filter">

          <h5 class="sidebar__subtitle">Price Range (Bottle)</h5>
          <div class="shop__filter__slider">
            <div class="js--jqueryui-price-filter"></div>
          </div>
          <hr class="divider">
          
          <h5 class="sidebar__subtitle">Brands</h5>
          <ul class="nav  nav--filter">
          	<s:iterator value="#request.categoryList">
          		<s:if test="%{type.typeId == 3}">
	            	<li><a data-target=".js--cat-${categoryId}" class="js--filter-selectable" href="#">${name}</a></li>
	            </s:if>
          	</s:iterator>
          </ul>

          <hr class="divider">

        </div>
      </aside>
    </div>
    <div class="col-xs-12  col-sm-9">
      <div class="grid">
        <ul class="pagination  shop__amount-filter">
          <li>
            <a class="shop__amount-filter__link  hidden-xs" href="beers-list"><span class="glyphicon glyphicon-th"></span></a>
          </li>
          <li>
              <a class="shop__amount-filter__link  hidden-xs" href="beers-list-view"><span class="glyphicon glyphicon-th-list"></span></a>
          </li>
        </ul>
        <div class="shop__sort-filter">
          <select class="js--isotope-sorting  btn  btn-shop">
              <option value='{"sortBy":"price", "sortAscending":"true"}'>By Price &nbsp; &#x21e7;</option>
              <option value='{"sortBy":"price", "sortAscending":"false"}'>By Price &nbsp; &#x21e9;</option>
              <option value='{"sortBy":"name", "sortAscending":"true"}'>By Name &nbsp; &#x21e7;</option>
              <option value='{"sortBy":"name", "sortAscending":"false"}'>By Name &nbsp; &#x21e9;</option>
          </select>
        </div>
        <hr class="shop__divider">
        <div class="row  js--isotope-container">
          
            
        <s:iterator value="#request.productList">    
        	<s:if test="%{type.typeId == 3}">
              <div class="col-xs-6 prod_list col-sm-3 js--isotope-target  js--cat-${category.categoryId}" data-price="${priceBottle}" data-rating="5">
			  <div class="products__single">
			    <figure class="products__image">
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
			    </figure>
			    <div class="row">
			      <div class="col-xs-9">
			        <h5 class="products__title">
			          <a class="products__link  js--isotope-title" href="product-detail?id=${productId}">${shortName}</a>
			        </h5>
			      </div>
			    </div>
			    <div class="products__category">
			    	btl&nbsp;<div class="products__price">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${priceBottle}</fmt:formatNumber></div><br>
			    	crt&nbsp;<div class="products__price">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${priceBox}</fmt:formatNumber></div>
			    </div>
			  </div>
			</div>
          </s:if>
        </s:iterator>
          
        </div>
        <hr class="shop__divider">
      </div>
    </div>
  </div>
</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/shop.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:04:59 GMT -->
</html>