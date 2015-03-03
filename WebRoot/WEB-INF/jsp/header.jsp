<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/ by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:03:54 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Andrew Wu">
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/list-add.js"></script>
	<script src="js/spin.js"></script>
	<script src="js/platform-checker.js"></script>

    <title>Spinach Store Indonesia | Jual Miras | Spirits & Wine</title>
    <meta name="description" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer. Kami juga menyediakan jasa pengiriman untuk seluruh Indonesia." />    
    <meta name="keywords" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer. Kami juga menyediakan jasa pengiriman untuk seluruh Indonesia. Jual Miras." />   
    <meta name="generator" content="PrestaShop" />
    <meta name="robots" content="index,follow" />
    <meta name="author" content="Andrew Gotama">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="stylesheets/A.b9575786.main.css.pagespeed.cf.KV29qTgDkf.css"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <!-- Google fonts -->
    <script type="text/javascript">WebFontConfig={google:{families:['Arvo:700:latin','Open+Sans:400,600,700:latin']}};(function(){var wf=document.createElement('script');wf.src=('https:'==document.location.protocol?'https':'http')+'://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';wf.type='text/javascript';wf.async='true';var s=document.getElementsByTagName('script')[0];s.parentNode.insertBefore(wf,s);})();</script>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-50983431-1', 'spinachstore.com');
	  ga('send', 'pageview');
	
	</script>

	<script type="text/javascript">
	    function downloadJSAtOnload(){
	    	var element=document.createElement("script");
	    	element.src="js/main.js";
	    	document.body.appendChild(element);
	    	(function () { var done = false;var script = document.createElement('script');script.async = true;script.type = 'text/javascript';script.src = 'https://app.purechat.com/VisitorWidget/WidgetScript';document.getElementsByTagName('HEAD').item(0).appendChild(script);script.onreadystatechange = script.onload = function (e) {if (!done && (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete')) {var w = new PCWidget({ c: '5ef0bbee-ef49-4d46-b8b3-7e84d26327b9', f: true });done = true;}};})();
	   	}
		
		if(window.addEventListener)
		window.addEventListener("load",downloadJSAtOnload,false);
		else if(window.attachEvent)
		window.attachEvent("onload",downloadJSAtOnload);
		else window.onload=downloadJSAtOnload;
		
		
		
	</script>
	
  </head>
  
<s:action name="cart-all" executeResult="false" />
<s:action name="customer-get-session" executeResult="false" />

  <div class="top  js--fixed-header-offset">
  <div class="container">
    <div class="row">
      <div class="col-xs-12  col-sm-6">
        <div class="top__slogan">
          Aneka Miras | Spirits & Wine | <img alt="Logo" src="images/flag.png" width="13" height="13">
        </div>
      </div>
      <div class="col-xs-12  col-sm-6">
        <div class="top__menu">
          <ul class="nav  nav-pills">
            <s:if test="%{#request.customer == null}">
            	<li><a href="#registerModal" role="button" data-toggle="modal">Register</a></li>
            	<li class="dropdown  js--mobile-dropdown"><a href="#loginModal" role="button" data-toggle="modal">Login</a></li>
            </s:if>
            <s:else>
            	<li class="dropdown  js--mobile-dropdown">Hi, ${request.customer.name}</li>
            	<li><a href="customer-edit" >My account</a></li>
            	<li><a href="customer-logout">Logout</a></li>
            </s:else>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Modal register-->
<script type="text/javascript">
  $(document).ready(function(){
	  $("#reg").click(function(){
		    if($("#name").val() == '' || $("#email").val() == '' || $("#subject").val() == ''){
		    	alert("Please fill the form correctly");
		    } else {
				var email = $("#email").val();
				var chkMail = false;
				var chkPwd = false;
				
				$.post( "json-customer-email", { email: email }, function( data ) {
					if(data.jsonResult.value != 0){
						alert("This email is already used");
					} else {
						chkMail = true;
					}
					
					if($("#subject").val().length < 8){
						alert("Password must be at least 8 characters!");
					} else {
						chkPwd = true;
					}
					
					if(chkMail && chkPwd){
						$("#reg-form").submit();
					}
		        });
		    }
	  });
  });
</script>
  
<div class="modal  fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content  center">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3><span class="light">Register</span> to Spinachstore</h3>
        <hr class="divider">
      </div>
      <div class="modal-body">
        <form action="customer-save" class="push-down-15" id="reg-form">
          <div class="form-group">
            <input type="text" id="name" class="form-control  form-control--contact" placeholder="First Name" name="name">
          </div>
          <div class="form-group">
            <input type="text" id="email" class="form-control  form-control--contact" placeholder="Email" name="email">
          </div>
          <div class="form-group">
            <input type="password" id="subject" class="form-control  form-control--contact" placeholder="Password" name="password">
          </div>
          <button type="button" id="reg" class="btn  btn-primary">REGISTER</button>
        </form>
        <a data-toggle="modal" role="button" href="#loginModal" data-dismiss="modal">Already Registered?</a>
      </div>
    </div>
  </div>
</div>

<!-- Modal login-->
<div class="modal  fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content  center">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3><span class="light">Login</span> to Spinachstore</h3>
        <hr class="divider">
      </div>
      <div class="modal-body">
        <form action="customer-login" class="push-down-15" validate>
          <div class="form-group">
            <input type="text" id="email" class="form-control  form-control--contact" placeholder="Email" name="email" required>
          </div>
          <div class="form-group">
            <input type="password" id="subject" class="form-control  form-control--contact" placeholder="Password" name="password" required>
          </div>
          <button type="submit" class="btn  btn-primary">SIGN IN</button>
        </form>
        <a data-toggle="modal" role="button" href="#registerModal" data-dismiss="modal">Create new account</a><br>
        <a data-toggle="modal" role="button" href="#forgetModal" data-dismiss="modal">Forget password</a>
      </div>
    </div>
  </div>
</div>

<!-- Modal order -->
<div class="modal  fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content  center">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3><span class="light">Order</span> Inquiry</h3>
        <hr class="divider">
      </div>
      <div class="modal-body">
        <form action="order-received" method="get" class="push-down-15" validate>
          <div class="form-group">
            <input type="text" class="form-control  form-control--contact" placeholder="Order ID" name="id" required>
          </div>
          <button type="submit" class="btn  btn-primary">SEARCH</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Modal forget -->
<div class="modal  fade" id="forgetModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content  center">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3><span class="light">Forget</span> Password</h3>
        <hr class="divider">
      </div>
      <div class="modal-body">
        <form action="customer-forget" method="get" class="push-down-15" validate>
          <div class="form-group">
            <input type="text" class="form-control  form-control--contact" placeholder="Email" name="email" required>
          </div>
          <button type="submit" class="btn  btn-primary">SEND</button>
        </form>
        <a data-toggle="modal" role="button" href="#loginModal" data-dismiss="modal">Already Registered?</a>
      </div>
    </div>
  </div>
</div>

<header class="header js--navbar">
  <div class="container">
    <div class="row">
      <div class="col-xs-10  col-md-3">
        <div class="header-logo">
          <a href="index"><img alt="Logo" src="images/logo.png.pagespeed.ce.m478RzMLoo.png" width="200" height="90"></a>
        </div>
      </div>
      <div class="col-xs-2  visible-sm  visible-xs">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle  collapsed" data-toggle="collapse" data-target="#collapsible-navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
      </div>
      <div class="col-xs-12  col-md-7">
        <nav class="navbar  navbar-default" role="navigation">
  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse  navbar-collapse" id="collapsible-navbar">
    <ul class="nav  navbar-nav">
      <li class="dropdown">
        <a href="index" >HOME</a>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle">PRODUCTS<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="spirits-list" >Spirit Collections</a></li>
          <li><a href="wine-list">Wine Collections</a></li>
          <li><a href="beers-list">Beers Collections</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle">SHOP<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="cart-list">Cart</a></li>
          <li>
	          <s:if test="%{#request.customer != null}">
	          	<a href="checkout">Checkout</a>
	          </s:if>
	          <s:else>
	          	<a href="#loginModal" role="button" data-toggle="modal">Checkout</a>
	          </s:else>
          </li>
          <li><a href="#orderModal" role="button" data-toggle="modal">Order Inquiry</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle">HELP<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="payment-method">How to Pay</a></li>
          <li><a href="shipment-method">Shipment</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="about-us">ABOUT US</a>
      </li>
      <li class="dropdown">
        <a href="contact">CONTACT US</a>
      </li>
      <li class="hidden-xs  hidden-sm">
        <a href="#" class="js--toggle-search-mode"><span class="glyphicon  glyphicon-search  glyphicon-search--nav"></span></a>
      </li>
      
      
    </ul>
    <!-- search for mobile devices -->
    <form action="product-search" method="post" class="visible-xs  visible-sm  mobile-navbar-form" role="form">
      <div class="input-group">
        <input name="searchKeyword" type="text" class="form-control" placeholder="Search">
        <span class="input-group-addon">
          <button type="submit" class="mobile-navbar-form__appended-btn"><span class="glyphicon  glyphicon-search  glyphicon-search--nav"></span></button>
        </span>
      </div>
    </form>
    
    
    <div class="mobile-cart  visible-xs  visible-sm  push-down-15">
        <span class="header-cart__text--price">IDR <fmt:formatNumber groupingUsed="true">${request.cartTotal}</fmt:formatNumber></span>
      <a href="cart-list" class="header-cart__items">
        <span class="header-cart__items-num"><s:property value="#request.cartSize" /></span>
      </a>
    </div>
  </div><!-- /.navbar-collapse -->
</nav>
      </div>
      <div class="col-xs-12  col-md-2  hidden-sm  hidden-xs">
        <!-- Cart in header -->
<div class="header-cart">
  <span class="header-cart__text--price">IDR <fmt:formatNumber groupingUsed="true">${request.cartTotal}</fmt:formatNumber></span>
  <a href="#" class="header-cart__items">
    <span class="header-cart__items-num"><s:property value="#request.cartSize" /></span>
  </a>
  
  
  <script type="text/javascript">
  $(document).ready(function(){
		$(".deleteItemCart").click(function(){
			var productId = $(this).find(".prodId").val();
			$.post( "cart-del", { productId: productId }, function( data ) {
	            location.reload();
            });
		}); 
		
		$(".deleteItemCartList").click(function(){
			var productId = $(this).find(".prodId").val();
			$.post( "cart-del", { productId: productId }, function( data ) {
	            location.reload();
            });
		}); 
  });
  </script>
  
  
  <!-- Open cart panel -->
  <div class="header-cart__open-cart">
  	<s:iterator value="#request.cartList">
	    <div class="header-cart__product  clearfix  js--cart-remove-target">
	      <div class="header-cart__product-image">
	        <img alt="Product in the cart" src="${value[5]}" width="40" height="50">
	      </div>
	      <div class="header-cart__product-image--hover">
	        <a href="cart-del?productId=${key}" class="js--remove-item" data-target=".js--cart-remove-target"><span class="deleteItemCart glyphicon  glyphicon-circle  glyphicon-remove"><s:hidden cssClass="prodId" value="%{key}" /></span></a>
	      </div>
	      <div class="header-cart__product-title">
	        <a class="header-cart__link" href="single-product.html"><s:property value="value[0]"/></a>
	        <span class="header-cart__qty">Qty: <s:property value="value[1]"/> <s:if test="%{value[2] == 1}">Bottle</s:if><s:else>Carton</s:else></span>
	      </div>
	      <div class="header-cart__price">
	      	<fmt:formatNumber groupingUsed="true">${value[3]}</fmt:formatNumber>
	      </div>
	    </div>
  	</s:iterator>
  
    <hr class="header-cart__divider">
    <div class="header-cart__subtotal-box">
      <span class="header-cart__subtotal">CART SUBTOTAL:</span>
      <span class="header-cart__subtotal-price">
     	IDR <s:if test="%{#request.cartTotal == null}">0</s:if><s:else><fmt:formatNumber groupingUsed="true"><s:property value="#request.cartTotal"/></fmt:formatNumber></s:else>
      </span>
    </div>
    <a class="btn btn-darker" href="cart-list">Procced to checkout</a>
  </div>
</div>
      </div>
    </div>
  </div>

  <!--Search open pannel-->
  <div class="search-panel">
    <div class="container">
      <div class="row">
        <div class="col-sm-11">
          <form class="search-panel__form" action="product-search">
            <button type="submit"><span class="glyphicon  glyphicon-search"></span></button>
            <input type="text" name="searchKeyword" class="form-control" placeholder="Enter your search keyword">
          </form>
        </div>
        <div class="col-sm-1">
          <div class="search-panel__close  pull-right">
            <a href="#" class="js--toggle-search-mode"><span class="glyphicon  glyphicon-circle  glyphicon-remove"></span></a>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>