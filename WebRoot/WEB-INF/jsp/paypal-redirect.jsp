<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/spin.js"></script>

<script>
$(document).ready(function() {
	$('body').bind('contextmenu', function(e) {
	    return false;
	});
	
	// ==================== LOADING ====================== //

	var opts = {
	  lines: 15, // The number of lines to draw
	  length: 0, // The length of each line
	  width: 5, // The line thickness
	  radius: 25, // The radius of the inner circle
	  corners: 1, // Corner roundness (0..1)
	  rotate: 0, // The rotation offset
	  direction: 1, // 1: clockwise, -1: counterclockwise
	  color: '#000', // #rgb or #rrggbb or array of colors
	  speed: 1, // Rounds per second
	  trail: 100, // Afterglow percentage
	  shadow: false, // Whether to render a shadow
	  hwaccel: false, // Whether to use hardware acceleration
	  className: 'spinner', // The CSS class to assign to the spinner
	  zIndex: 2e9, // The z-index (defaults to 2000000000)
	  top: '50%', // Top position relative to parent
	  left: '50%' // Left position relative to parent
	};
	var target = document.getElementById('loading');
	var spinner = new Spinner(opts);
	var $loadingBg = $('#loading_wrapper');

	function loading_show(){
        spinner.spin(target);
    	$loadingBg.show();
	}

	function loading_hide(){
        spinner.spin();
    	$loadingBg.hide();
	}
	
	loading_show();
	
	$("#form").submit();
	
});
</script> 

<div id="loading"></div>
<div id="loading_wrapper"></div>

<s:form name="_xclick" method="post" action="https://www.paypal.com/cgi-bin/webscr" id="form">
<%-- <s:form name="_xclick" method="post" action="https://www.sandbox.paypal.com/cgi-bin/webscr" id="form"> --%>
	<input type="hidden" name="cmd" value="_xclick">
    <input type="hidden" name="business" value="spinachstore@gmail.com">
<!--     <input type="hidden" name="business" value="seller@spinach.com"> -->
    <input type="hidden" name="currency_code" value="USD">
    <input type="hidden" name="item_name" value="Spinach Order #<s:property value="#request.shipId" />">
    <input type="hidden" id="paypal_total" name="amount" value="${request.amount}">
    
	<input type="hidden" name="rm" value="2">
    <input type="hidden" name="src" value="1">                          
    
 	<input name="notify_url" value="${request.host}/payment-success?cert=${request.cert}" type="hidden">
	<input name="return" value="${request.host}/order-received?id=${request.shipId}" type="hidden">
	<input name="cancel_return" value="${request.host}/order-cancel?id=${request.shipId}" type="hidden">

</s:form>