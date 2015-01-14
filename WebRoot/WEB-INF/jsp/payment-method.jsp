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
            
            <li class="active">Payment Method</li>
            
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
		    	<h2 class="blog-title"><span class="light">BCA</span> Transfer</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>Pembayaran ditransfer ke rekening berikut:</p>
		    	<p>Rekening BCA: 8710085669 </p>
		    	<p>a/n : ANDREW GOTAMA</p>
		    	<p>Setelah pembayaran terkonfirmasi, status pemesanan anda akan berubah dari <font style="color:red;"><strong>UNPAID</strong></font> menjadi <font style="color:green;"><strong>PAID</strong></font>.</p>
		    </div>
	    </div>
    </div>
    
    
    <div class="row">
	    <div class="col-xs-8 ">
		    <header>
		    	<h2 class="blog-title"><span class="light">Credit</span> Card</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>Pembayaran bisa dilakukan menggunakan <strong>VISA / Master Card</strong> dan akan dikenai charge sebagai berikut:</p>
		    	<p>Pembayaran dilakukan melalui <a target="_blank" href="http://www.paypal.com">Paypal Gateway</a> dan akan di convert menjadi <strong>USD</strong>.</p>
		    	<p>Charge sesuai dengan ketentuan resmi dari Paypal sebesar <strong>3.9%</strong> dari total pembelian + <strong>$0.30 USD</strong> untuk setiap transaksi.</p>
		    </div>
	    </div>
    </div>
    
    
    <div class="row">
	    <div class="col-xs-8 ">
		    <header>
		    	<h2 class="blog-title"><span class="light">Cash on Delivery</span> CoD</h2>
		    </header>
		    <div class="blog-content__text">
		    	<p>Cara pembayaran yang paling mudah dan aman.</p>
		    	<p>Pembeli dikenakan admin fee sebesar IDR 10,000.</p>
		    	<p>Pembayaran langsung kepada kurir kami pada saat barang sampai di tujuan.</p>
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