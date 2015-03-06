<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>Spinach Store Liquor Indonesia | Order Cancel</title>
	<meta name="description" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer." />    
    <meta name="keywords" content="jual, miras, liquor, indonesia, jakarta, wine, spirits, beer,spinach, spinachstore, store, online, shop, murah, harga, berkualitas" />  
    <meta name="robots" content="INDEX,FOLLOW" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
	<link rel="shortcut icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
</head>

<jsp:include page="header.jsp" />
<body>

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
            
            <li class="active">Order Cancel</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="page-not-found">
        <div class="page-not-found__background">
          <img alt="404" src="images/404.png.pagespeed.ce.q9My-N-zKW.png" width="217" height="222">
        </div>
        <h1><span class="light">Error.</span> Your order cannot be processed!</h1>
        <hr class="divider">
        <span class="page-not-found__text">Please try again. Return to <a class="page-not-found__link" href="index">Home</a>.</span>
      </div>
    </div>
  </div>
</div>
  
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/404.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:45 GMT -->
</html>