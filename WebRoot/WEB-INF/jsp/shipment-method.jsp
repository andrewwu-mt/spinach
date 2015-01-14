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
            
            <li class="active">Shipment</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="container  push-down-30">

  <div class="row">
    <div class="col-xs-12">
    
    <div class="row">
	    <div class="col-xs-8 ">
		    <header>
		    	<h2 class="blog-title"><span class="light">Jabodetabek</span> Standard</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>1-3 botol IDR 50,000</p>
		    	<p>4-6 botol IDR 70,000</p>
		    	<p>7-12 botol IDR 100,000</p>
		    	<p>Selebihnya IDR 150,000</p>
		    	<p>Lama pengiriman antara 1 sampai 2 hari kerja.</p>
		    </div>
	    </div>
    </div>
    
    
    <div class="row">
	    <div class="col-xs-8 ">
		    <header>
		    	<h2 class="blog-title"><span class="light">Jabodetabek</span> Priority</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>1-3 botol IDR 100,000</p>
		    	<p>4-6 botol IDR 120,000</p>
		    	<p>7-12 botol IDR 150,000</p>
		    	<p>Selebihnya IDR 200,000</p>
		    	<p>Barang sampai pada hari yang sama.</p>
		    </div>
	    </div>
    </div>
    
    
    <div class="row">
	    <div class="col-xs-8 ">
		    <header>
		    	<h2 class="blog-title"><span class="light">JNE Express</span> (Dalam Jawa)</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>1-3 botol IDR 55,000 + packing IDR 5,000 = IDR 60,000</p>
				<p>4-6 botol IDR 70,000 + packing IDR 20,000 = IDR 90,000</p>
				<p>7-12 botol IDR 100,000 + packing IDR 40,000 = IDR 140,000</p>
				<p>Selebihnya IDR 120,000 + packing IDR 50,000 = IDR 170,000</p>
				<p>Lama pengiriman antara 3 sampai 7 hari kerja</p>
		    </div>
	    </div>
    </div>
    
    <div class="row">
	    <div class="col-xs-8 ">
		    <header>
		    	<h2 class="blog-title"><span class="light">JNE Express</span> (Luar Jawa)</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>1-3 botol IDR 65,000 + packing IDR 5,000 = IDR 70,000</p>
				<p>4-6 botol IDR 80,000 + packing IDR 20,000 = IDR 100,000</p>
				<p>7-12 botol IDR 110,000 + packing IDR 40,000 = IDR 150,000</p>
				<p>Selebihnya IDR 130,000 + packing IDR 50,000 = IDR 180,000</p>
				<p>Lama pengiriman antara 3 sampai 7 hari kerja</p>
		    </div>
	    </div>
    </div>
    
    
  <hr class="divider">
    </div>
  </div>
</div>
  
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/blog.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:40 GMT -->
</html>