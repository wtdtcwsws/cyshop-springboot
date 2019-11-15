/* -------------------------------------------------------------------------------- /
	
	Magentech jQuery
	Created by Magentech
	v1.0 - 20.9.2016
	All rights reserved.
	
/ -------------------------------------------------------------------------------- */

"use strict"

	// Cart add remove functions
	var cart = {
		'add': function(product_id, quantity) {
			addProductNotice('商品添加到购物车', '<img src="img/demo/shop/product/e11.jpg" alt="">', '<h3><a href="javascript:;">商品</a> 添加<a href="/cart">购物车</a>！</h3>', '成功');
		}
	}

	var wishlist = {
		'add': function(product_id) {
			addProductNotice('Product added to Wishlist', '<img src="img/demo/shop/product/e11.jpg" alt="">', '<h3>You must <a href="login.html">login</a>  to save <a href="goods.html">Apple Cinema 30"</a> to your <a href="wishlist.html">wish list</a>!</h3>', 'success');
		}
	}
	var compare = {
		'add': function(product_id) {
			addProductNotice('Product added to compare', '<img src="img/demo/shop/product/e11.jpg" alt="">', '<h3>Success: You have added <a href="goods.html">Apple Cinema 30"</a> to your <a href="compare.html">product comparison</a>!</h3>', 'success');
		}
	}

	/* ---------------------------------------------------
		jGrowl – jQuery alerts and message box
	-------------------------------------------------- */
	function addProductNotice(title, thumb, text, type) {
		$.jGrowl.defaults.closer = false;
		//Stop jGrowl
		//$.jGrowl.defaults.sticky = true;
		var tpl = thumb + '<h3>'+text+'</h3>';
		$.jGrowl(tpl, {		
			life: 4000,
			header: title,
			speed: 'slow',
			theme: type
		});
	}

