<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>Spinach Store Liquor Indonesia | Contact Us</title>
	<meta name="description" content="Online shop Indonesia spesial menjual berbagai macam liquor seperti wine, spirits dan beer." />    
    <meta name="keywords" content="jual, miras, liquor, indonesia, jakarta, wine, spirits, beer,spinach, spinachstore, store, online, shop, murah, harga, berkualitas" />  
    <meta name="robots" content="INDEX,FOLLOW" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
	<link rel="shortcut icon" href="images/favicon.png.pagespeed.ce.jZBcI7cfio.png" type="image/x-icon" />
</head>
<jsp:include page="header.jsp" />


<body>

<div class="breadcrumbs  no-margin">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index">Home</a></li>
            
            <li class="active">Contact</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>

<div class="simple-map  js--where-we-are" data-latlng="-6.2295119,106.6587923" data-markers="[{lat: -6.229763,lng: 106.658800,title: 'ProteusThemes Senovo'}]" data-zoom="17"></div>
<div class="container  push-down-30">
  <div class="row">
    <div class="col-xs-12">
      <h1 class="center"><span class="light">Send</span> Us an Message</h1>
      <hr class="divider">
      <div class="text-shrink">
        <p class="text-highlight">Silahkan isi form dengan lengkap dan tulis pesan anda kepada kami.</p>
      </div>
      <hr class="divider  divider-about">
      <div class="push-down-30"></div>
      <div class="row">
        <div class="col-xs-12 col-sm-9  push-down-30">
          <form validate action="send-message">
            <div class="row">
              <div class="col-xs-12  col-sm-4">
                <div class="form-group">
                  <label class="text-dark" for="name">Name <span class="warning">*</span></label>
                  <input name="name" type="text" id="name" class="name form-control  form-control--contact" required>
                </div>
                <div class="form-group">
                  <label class="text-dark" for="email">E-mail <span class="warning">*</span></label>
                  <input name="email" type="text" id="email" class="email form-control  form-control--contact" required>
                </div>
                <div class="form-group">
                  <label class="text-dark" for="subject">Subject <span class="warning">*</span></label>
                  <input name="subject" type="text" id="subject" class="subject form-control  form-control--contact" required>
                </div>
                <span class="hidden-xs">Fields marked with <span class="warning">*</span> are obligatory</span>
              </div>
              <div class="col-xs-12  col-sm-8">
                <div class="form-group">
                  <label class="text-dark" for="message">Message <span class="warning">*</span></label>
                  <textarea name="content" class="message form-control  form-control--contact  form-control--big" id="message" rows="12" required></textarea>
                </div>
                <div class="right">
                  <button type="submit" id="btn" class="btn  btn-warning">Send now</button>
                </div>
              </div>
            </div>
          </form>
        </div>
        <div class="col-xs-12 col-sm-3">
          <h2 class="no-margin">Spinachstore</h2><br/>
          <p><strong>Alam Sutera,<br>
          Tangerang, Indonesia</strong></p>
          <span class="glyphicon  glyphicon-earphone"></span> <span class="text-dark">+62 813 1547 6688 </span><br>
          <span class="glyphicon  glyphicon-envelope"></span> <a class="secondary-link" href="http://www.gmail.com" target="_blank"><strong>spinachstore@gmail.com</strong></a>
        </div>
      </div>
    </div>
  </div>
</div>
  <jsp:include page="footer.jsp"></jsp:include>
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  <script type="text/javascript">
/* <![CDATA[ */
(function(){try{var s,a,i,j,r,c,l=document.getElementsByTagName("a"),t=document.createElement("textarea");for(i=0;l.length-i;i++){try{a=l[i].getAttribute("href");if(a&&"/cdn-cgi/l/email-protection"==a.substr(0 ,27)){s='';j=28;r=parseInt(a.substr(j,2),16);for(j+=2;a.length-j&&a.substr(j,1)!='X';j+=2){c=parseInt(a.substr(j,2),16)^r;s+=String.fromCharCode(c);}j+=1;s+=a.substr(j,a.length-j);t.innerHTML=s.replace(/</g,"&lt;").replace(/>/g,"&gt;");l[i].setAttribute("href","mailto:"+t.value);}}catch(e){}}}catch(e){}})();
/* ]]> */
</script>
</body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/contact-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:44 GMT -->
</html>