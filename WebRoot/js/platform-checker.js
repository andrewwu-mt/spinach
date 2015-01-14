$(document).ready(function(){
	
	
	if(navigator.platform == 'iPhone' || navigator.platform == 'iPad' || navigator.platform == 'Android' || navigator.platform == 'Blackberry'  ){
		$(".products__price").each(function(){
			var val = $(this).text();
			
//			var newVal = val.substr(val.length-4, val.length-1);
//			
//			if(newVal == ',000'){
//				$(this).text(val.substr(0, val.length-4) + ' K');
//			}
			
			$(this).text(val.replace('IDR', ''));
		});
		
		$(".prod_list").each(function(){
			$(this).removeClass('col-sm-3').addClass('col-sm-4');
		});
	} else {
		$(".prod_list").each(function(){
			$(this).addClass('col-sm-3');
		});
	}
	
});