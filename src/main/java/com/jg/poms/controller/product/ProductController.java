package com.jg.poms.controller.product;

import com.jg.poms.dto.product.response.ProductResponse;
import com.jg.poms.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("list")
	public List<ProductResponse> getProductList(){
		return productService.getProductList();
	}
}
