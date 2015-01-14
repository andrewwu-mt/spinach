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
            
            <li class="active">About Us</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="container  push-down-30">
	
  <!-- Display -->
  <div class="row">
    <div class="col-xs-12  push-down-20">
      <div class="banners--big  banners--big--left">
        <span class="banners-text"><span class="bold">Display Cabinet</span></span>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-xs-12  blog-alternative">
		<section>
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/1.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/2.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/3.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/4.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/5.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/6.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/display/7.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		</section>
    </div>
  </div>
	
	
  <!-- Banners big -->
  <div class="row">
    <div class="col-xs-12  push-down-20">
      <div class="banners--big  banners--big--left">
        <span class="banners-text">Our <span class="bold">Warehouse</span></span>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-xs-12  blog-alternative">
		<section>
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/1.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/2.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/3.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/4.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/5.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/6.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/7.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/warehouse/8.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		</section>
    </div>
  </div>
  
  <!-- Testi -->
  <div class="row">
    <div class="col-xs-12  push-down-20">
      <div class="banners--big  banners--big--left">
        <span class="banners-text"><span class="bold">Testimonial</span></span>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-xs-12  blog-alternative">
		<section>
		  
		  <article>
		    <a href="#"><img class="wp-post-image" alt="Blog featured image" src="images/testi/1.jpg" width="747" height="284"></a>
		  </article>
		  <hr class="divider">
		</section>
    </div>
  </div>
  
</div>
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>
    
    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/blog.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:40 GMT -->
</html>