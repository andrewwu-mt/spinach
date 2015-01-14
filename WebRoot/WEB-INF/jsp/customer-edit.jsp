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
<script src="js/form-check.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	$("#email-edit").blur(function(){
		var email = $("#email-edit").val();
		var id = $("#customerId").val();
		
		$.post( "json-customer-email", { email: email, customerId: id }, function( data ) {
			if(data.jsonResult.value != 0){
				alert("This email is already used");
				$("#email-edit").val('');
			}
        });
	});
});

	function checkForm(form){
		var newPwd = $("#newPwd").val();
		var chkPwd = $("#chkPwd").val();
		
		if(newPwd.length < 8){
			alert("Password must be at least 8 characters!");
			return false;
		}
		
		if(newPwd != chkPwd){
			alert("Please check that you've entered and confirmed your password!");
			return false;
		} else {
			return true;
		}
	}

</script>
<s:action name="ship-type-all" executeResult="false" />
<s:action name="provinsi-all" executeResult="false" />
<s:action name="kabupaten-get" executeResult="false" >
	<s:param name="provinsiId" value="#parameters.provinsiId"/>
</s:action>

<div class="breadcrumbs  no-margin">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
        <nav>
          <ol class="breadcrumb">
            
            <li><a href="index-2.html">Home</a></li>
            
            <li class="active">My Account</li>
            
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<div class="woocommerce  push-down-30">
  <div class="container">
    <div class="row">
     <form action="customer-update" id="form" validate>
      <s:hidden id="customerId" value="%{#request.customer.customerId}"/>
      <div class="col-xs-12">
        <h3>Account Information</h3>
        <hr>
      </div>
      <div class="col-xs-12  col-sm-6">
        <div class="row" id="billAddr">
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                First Name
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text req" value="${request.customer.name}" required name="name">
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Last Name
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text" value="${request.customer.last}" name="last">
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Address
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text  push-down-10 req" placeholder="Street address 1" required value="${request.customer.address}" name="address">
              <input class="input-text" placeholder="Street address 2" value="${request.customer.address2}" name="address2">
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Postcode / Zip
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text  push-down-10 req" placeholder="Postcode / Zip" value="${request.customer.post}" name="post" required>
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Province
                <abbr class="required">
                  *
                </abbr>
              </label>
              <s:select id="provinsiList" name="provinsiId" list="#request.provinsiList" listKey="provinsiId" listValue="name" cssClass="input-text"  value="%{#request.customer.kabupaten.provinsi.provinsiId}"/>
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                City / District
                <abbr class="required">
                  *
                </abbr>
              </label>
              <s:hidden id="kabId" value="%{#request.customer.kabupaten.kabupatenId}" />
              <s:select id="kabupatenList" name="kabupatenId" list="#request.kabupatenList" listKey="kabupatenId" listValue="name" cssClass="input-text"  value="%{#request.customer.kabupaten.kabupatenId}" />
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Email Address
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input id="email-edit" class="input-text req" required value="${request.customer.email}" name="email">
            </p>
          </div>
          <div class="col-xs-12  col-sm-6  push-down-10">
            <p>
              <label>
                Phone
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input class="input-text req" required value="${request.customer.phone}" name="phone">
            </p>
          </div>
        </div>
        <input type="hidden" id="chkbox">
        <s:hidden name="customerId" value="%{#request.customer.customerId}" />
        <button type="submit" class="btn btn-warning pull-right">Update</button>
      </div>
     </form>
     
     <form action="customer-password-update" onsubmit="return checkForm(this);" validate >
      <div class="col-xs-12  col-sm-6">
        <div class="row">
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                Current Password
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input type="password" class="input-text  push-down-10 req" placeholder="Current Password" name="oldPwd" required>
            </p>
          </div>
          <div class="col-xs-12  col-sm-12  push-down-10">
            <p>
              <label>
                New Password
                <abbr class="required">
                  *
                </abbr>
              </label>
              <input type="password" class="input-text  push-down-10 req" placeholder="New Password" id="newPwd" name="newPwd" required>
              <input type="password" class="input-text" placeholder="Confirm Password" name="chkPwd" id="chkPwd" required>
            </p>
          </div>
        </div>
        <input type="hidden" id="chkbox">
        <s:hidden name="customerId" value="%{#request.customer.customerId}" />
        <button type="submit" class="btn btn-warning pull-right">Save Changes</button>
      </div>
     </form>
    </div>
    <hr class="divider">
  </div>
</div>
  
  <jsp:include page="footer.jsp" />
  <div class="search-mode__overlay"></div>

    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create','UA-33538073-8','proteusthemes.com');ga('send','pageview');</script>
  </body>

<!-- Mirrored from www.proteusthemes.com/themes/organique-html/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Sep 2014 16:05:31 GMT -->
</html>