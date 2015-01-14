$(document).ready(function(){
	$(".addToCart").click(function(){
		var status = $(this).find('.stat').val();
		
		if(status == 1){
			var productId = $(this).find(".productId").val();
			var amount = 1;
			var type = 1;
			var total = $(this).find(".priceBottle").val();
			
			$.post( "cart-add", { productId: productId, amount: amount, type: type, total: total }, function( data ) {
				alert("Add successful");
	            location.href="cart-list";
            });
		} else {
			alert("Stok barang tidak cukup");
		}			
	});
});