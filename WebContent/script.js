function processClick(id) {
	var quantity = prompt('Please enter the quantity you want to buy');
	if (quantity.length > 0) {
		$.get('addToShoppingCart.do', {
			itemID : id,
			quantity : quantity
		}, function(data) {
		}).done(function() {
			$('#addToCartRecord' + id).css("color", 'green');
			$('#addToCartRecord' + id).slideUp(300).fadeIn(500);
			$('#addToCartRecord' + id).html(quantity + " added");
			$('#cart').slideUp(300).fadeIn(500);
			$('#cart_index').slideUp(300).fadeIn(500);
		}).fail(function() {
			$('#addToCartRecord' + id).css("color", 'red');
			$('#addToCartRecord' + id).html("ERROR");
		}).beforeSend(
				function() {
					$('#addToCartRecord' + id).html('<img id="img" src="images/processing.gif"/>');
				});
	}
}

function hideProcessing() {
	$('.processing').hide();
}

function confirmCheckingOut() {
	var confirmCheckOut = confirm('Are you sure to place the order?\nAll the items will be charged from your personal information from your profile.');
	if(confirmCheckOut) {
		gotoPage('pay.do');
	}
}

function roundTwoFixed(number) {
	return number.toFixed(2);
}

function gotoPage(url) {
	window.location=url;
}

function logout() {
	var confirmLogOut = confirm('Are you sure to logout?\nYou shopping cart will be automatically saved.');
	if(confirmLogOut) {
		gotoPage('logout.do');
	}
}

function changeLang(lang) {
		$.get('lang.do?lang='+lang, {
			language : lang
		}, function(data) {
		}).done(function(){alert('yes');})
		
		;
}