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
	<title>Spinach Store Liquor Indonesia | Jual Miras</title>
	<meta name="description" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer. Kami juga menyediakan jasa pengiriman untuk seluruh Indonesia." />    
    <meta name="keywords" content="jual, miras, liquor, indonesia, jakarta, wine, spirits, beer,spinach, spinachstore, store, online, shop, murah, harga, berkualitas" />  
    <meta name="robots" content="INDEX,FOLLOW" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


<jsp:include page="header.jsp" />
<body>

<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<s:action name="product-home" executeResult="false"/> 
<s:action name="best-seller-all" executeResult="false"/> 
<s:action name="top-rated-all" executeResult="false"/> 

<div id="carousel-example-generic" class="carousel  slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item  active">
      <img src="images/slide2.jpg" alt="" width="1920" height="420">
      <div class="carousel-caption">
        <div class="jumbotron__container">
	        <h2 class="jumbotron__subtitle">
	        	New arrival for Japanese Beers
	        </h2>
	        <h1 class="jumbotron__title">
	        	Hitachino & Baird Beers
	        </h1>
	     	<a class="btn  btn-warning" href="beers-list">See More</a> &nbsp;
        </div>
      </div>
    </div>
    <div class="item">
      <img src="images/slide1.jpg" alt="" width="1920" height="420">
      <div class="carousel-caption">
         <div class="jumbotron__container">
          <h2 class="jumbotron__subtitle">
            The Largest and Cheapest Liquor Store
          </h2>
          <h1 class="jumbotron__title">
            INDONESIA
          </h1>
	      <a class="btn  btn-warning" href="spirits-list">Start Shopping</a> &nbsp;
        </div>
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left  carousel-control" href="#carousel-example-generic" data-slide="prev">
    <span class="glyphicon  glyphicon-chevron-left"></span>
  </a>
  <a class="right  carousel-control" href="#carousel-example-generic" data-slide="next">
    <span class="glyphicon  glyphicon-chevron-right"></span>
  </a>
</div>
<div class="banners  push-down-30">
  <div class="container">
    <div class="row">
      <div class="col-xs-12  col-sm-6  col-md-3">
        <div class="banners-box">
          <span class="glyphicon glyphicon-earphone glyphicon--banners"></span>
          <b class="banners__title">CALL US ANYTIME</b>
          +62 813 1547 6688
        </div>
      </div>
      <div class="col-xs-12  col-sm-6  col-md-3">
        <div class="banners-box">
          <span class="glyphicon glyphicon-road glyphicon--banners"></span>
          <b class="banners__title">SHIPPING DESTINATION</b>
          All of Indonesia
        </div>
      </div>
      <div class="col-xs-12  col-sm-6  col-md-3">
        <div class="banners-box">
          <span class="glyphicon glyphicon-credit-card glyphicon--banners"></span>
          <b class="banners__title">PAYMENT METHODS</b>
          BCA, Credit Cards, CoD
        </div>
      </div>
      <div class="col-xs-12  col-sm-6  col-md-3">
        <div class="banners-box">
          <span class="glyphicon glyphicon-heart glyphicon--banners"></span>
          <b class="banners__title">TRUSTED SELLER</b>
          100% Original
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container">

  
<!-- Navigation -->
<div class="products-navigation  push-down-15">
  <div class="products-navigation__title">
    <h3><span class="light">Featured</span> Items</h3>
  </div>
</div>

<!-- Products -->
<div class="row">
   
	<s:iterator value="#request.productList1">
  
		<div class="col-xs-6 col-sm-3  js--isotope-target  js--cat-2" data-price="14.36" data-rating="4">
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
  
	</s:iterator>
  
  
  
  
  
</div>

<!-- Banners medium -->
<div class="row">
  <div class="col-xs-12 col-sm-6">
    <a href="spirits-list">
      <div class="banners--medium">
        <span class="banners-text">Up to 15% off in <strong>Spirits</strong> category</span>
        <span class="glyphicon  glyphicon-circle  glyphicon-chevron-right"></span>
      </div>
    </a>
  </div>
  <div class="col-xs-12 col-sm-6">
    <a href="beers-list">
      <div class="banners--medium">
        <span class="banners-text">New arrivals in <strong>Beers</strong> category</span>
        <span class="glyphicon  glyphicon-circle  glyphicon-chevron-right"></span>
      </div>
    </a>
  </div>
</div>


  <div class="row">
  <div class="col-xs-12 col-sm-4">
    <div class="widgets__navigation">
      <div class="widgets__heading--line">
        <h4 class="widgets__heading">Top Rated Products</h4>
      </div>
      
  
  <s:iterator value="#request.topRatedList">
	  <div class="push-down-20  clearfix">
	    <a href="product-detail?id=${id.product.productId}">
	      <img alt="" class="widgets__products" width="78" height="78" src="${id.product.src}">
	    </a>
	    <h5 class="products__title">
	    <a class="products__link" href="product-detail?id=${id.product.productId}">${id.product.shortName}</a>
	    </h5>
	    <span class="products__price--widgets">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${id.product.priceBottle}</fmt:formatNumber></span>
	    <br><br>
	
		<s:iterator value="onList">
    		<span class="glyphicon glyphicon-star  star-on"></span>
		</s:iterator>
		
		<s:iterator value="offList">
    		<span class="glyphicon glyphicon-star  star-off"></span>
		</s:iterator>
		
	  </div>
  </s:iterator>
  
  </div>
  
  </div>
  <div class="col-xs-12 col-sm-4">
    <div class="widgets__navigation">
      <div class="widgets__heading--line">
        <h4 class="widgets__heading">Bestsellers</h4>
      </div>
      
  <s:iterator value="#request.bestSellerList">
	  <div class="clearfix  push-down-15">
	    <a href="product-detail?id=${id.product.productId}">
	      <img alt="" class="widgets__products" width="78" height="78" src="${id.product.src}">
	    </a>
	    <div class="products__title">
	    <a class="products__link" href="product-detail?id=${id.product.productId}">${id.product.shortName}</a>
	    </div>
	    <span class="products__price--widgets">IDR&nbsp;<fmt:formatNumber groupingUsed="true">${id.product.priceBottle}</fmt:formatNumber></span>
	    <br><br>
	    <div class="products__category">
	      ${id.product.type.name}
	    </div>
	  </div>
  </s:iterator>
  
    </div>
  </div>
  <div class="col-xs-12 col-sm-4">
    <div class="widgets__navigation">
      <div class="widgets__heading--line">
        <h4 class="widgets__heading">Related Website</h4>
      </div>
	  <div class="fb-like-box" data-href="https://www.facebook.com/spinachstoreindonesia" data-colorscheme="light" data-show-faces="true" data-header="false" data-stream="false" data-show-border="true"></div>
    </div>
  </div>
</div>
</div>

<div class="testimonials  light-paper-pattern">
  <div class="container">
    <div class="row">
      <div class="col-sm-3  hidden-xs">
        <div class="testimonials__quotes">
          <img alt="#" class="testimonials__quotes--img" src="images/quotes.png.pagespeed.ce.Lcb0QkNZLt.png" width="224" height="175">
        </div>
      </div>
      <div class="col-xs-12  col-sm-6">
        <a href="#js--testimonails-carousel" data-slide="prev"><span class="glyphicon  glyphicon-circle  glyphicon-chevron-left"></span></a>
        <h4 class="testimonials__title"><span class="light">Others</span> About Us</h4>
        <a href="#js--testimonails-carousel" data-slide="next"><span class="glyphicon  glyphicon-circle  glyphicon-chevron-right"></span></a>
        <hr class="divider-dark">
        <div id="js--testimonails-carousel" class="carousel  slide" data-ride="carousel" data-interval="5000">
          <div class="carousel-inner">
            <div class="item  active">
              <q class="testimonials__text">A top quality product delivered super quick! Thank you so much Spinach Store,<br>I shall definitely be using you guys again!</q><br><br>
              <cite><b>Andrew</b></cite>
            </div>
            <div class="item">
              <q class="testimonials__text">What a fast shipping!! Really Really Happy with the service! Thanks again.</q><br><br>
              <cite><b>Hendro</b></cite>
            </div>
            <div class="item">
              <q class="testimonials__text">Perfect for any alcoholic lovers!!! I love it so muchhh...</q><br><br>
              <cite><b>Marshella</b></cite>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-3  hidden-xs">
        <div class="testimonials__quotes--rotate">
          <img alt="#" class="testimonials__quotes--img" src="images/quotes.png.pagespeed.ce.Lcb0QkNZLt.png" width="224" height="175">
        </div>
      </div>
    </div>
  </div>
</div>
  
  <jsp:include page="footer.jsp"></jsp:include>
  <div class="search-mode__overlay"></div>
    
    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:04:18 GMT -->
</html>
