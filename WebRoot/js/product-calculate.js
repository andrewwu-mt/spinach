$(document).ready(function(){
	var remainder = $("#remainder").val();
	var multi = $("#desc").text();
	multi = multi.split("x")[0];
	var priceBottle = $("#priceBottle").text();
	priceBottle = priceBottle.replace(/,/g , "");
	var priceBox = $("#priceBox").text();
	priceBox = priceBox.replace(/,/g , "");

	function changeAmount(){
		var amount = $("#amount").val();
		
		if($("#type").val() == "1"){
			var total = parseInt(amount) * parseInt(priceBottle);
			$("#total").val(total);
		} else if($("#type").val() == "2"){
			var total = parseInt(amount) * parseInt(priceBox);
		
			$("#total").val(total);
		} else {
			$("#total").val("");
		}
	}
	
	changeAmount();		
	
	$("#amount").change(function(){
		changeAmount();		
	});
	
	$("#inc").click(function(){
		var amount = $("#amount").val();
		amount++;
		
		if($("#type").val() == "1"){
			var total = parseInt(amount) * parseInt(priceBottle);
			$("#total").val(total);
		} else if($("#type").val() == "2"){
			var total = parseInt(amount) * parseInt(priceBox);
		
			$("#total").val(total);
		} else {
			$("#total").val("");
		}
	});

	$("#dec").click(function(){
		var amount = $("#amount").val();
		amount--;
		
		if(amount != 0){
			if($("#type").val() == "1"){
				var total = parseInt(amount) * parseInt(priceBottle);
				$("#total").val(total);
			} else if($("#type").val() == "2"){
				var total = parseInt(amount) * parseInt(priceBox);
			
				$("#total").val(total);
			} else {
				$("#total").val("");
			}
		}
	});
	
	$("#type").change(function(){
		var amount = $("#amount").val();
		
		if($(this).val() == "1"){
			var total = parseInt(amount) * parseInt(priceBottle);
			$("#total").val(total);
		} else if($(this).val() == "2"){
			var total = parseInt(amount) * parseInt(priceBox);
		
			$("#total").val(total);
		} else {
			$("#total").val("");
		}

		
	});
	
	$("#btn").click(function(){
		if($("#total").val() == "" || $("#amount").val() == ""){
			alert("Masukkan jumlah barang");
		} else {
			var total = "";
			if($("#type").val() == "1"){
				total = $("#amount").val();
			} else {
				total = parseInt($("#amount").val()) * parseInt(multi);
			}
			
			if(parseInt(total) <= parseInt(remainder)){
//				$("#form").submit();
				var productId = $("#productId").val();
				var amount = $("#amount").val();
				var type = $("#type").val();
				var total = $("#total").val();
				
				$.post( "cart-add", { productId: productId, amount: amount, type: type, total: total }, function( data ) {
	            });
				alert("Add successful");
				location.href="cart-list";
			} else {
				alert("Stok barang tidak cukup");
			}			
			
		}
	
	});
	

});
