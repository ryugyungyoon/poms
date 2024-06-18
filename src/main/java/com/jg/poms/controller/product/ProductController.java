package com.jg.poms.controller.product;

import com.jg.poms.dto.product.response.ProductResponse;
import com.jg.poms.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<ProductResponse> getProducts(){
		return productService.getProducts();
	}
}
