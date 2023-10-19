package com.sa.lab4.webshop.shoppingcart.service;

import com.sa.lab4.webshop.product.service.ProductService;
import com.sa.lab4.webshop.shoppingcart.dao.ShoppingCartRepository;
import com.sa.lab4.webshop.shoppingcart.domain.Product;
import com.sa.lab4.webshop.shoppingcart.domain.ShoppingCart;
import com.sa.lab4.webshop.shoppingcart.domain.dto.AddToCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
	@Autowired
	ProductService productService;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	public void addToCart(AddToCartDto addToCartDto) {
		com.sa.lab4.webshop.product.domian.Product productDto = productService
				.getProduct(addToCartDto.getProductNumber());
		Product product = new Product(productDto.getProductNumber(), productDto.getName(), productDto.getPrice(),
				productDto.getDescription());
		ShoppingCart cart = shoppingCartRepository.findById(addToCartDto.getCartId()).orElse(new ShoppingCart());
		if (cart.getCartId() == 0)
			cart.setCartId(addToCartDto.getCartId());
		cart.addToCart(product, addToCartDto.getQuantity());
		shoppingCartRepository.save(cart);
	}

	public ShoppingCart getCart(int cartId) {
		return shoppingCartRepository.findById(cartId).orElse(null);
	}
}
