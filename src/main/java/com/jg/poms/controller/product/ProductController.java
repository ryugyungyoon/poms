package com.jg.poms.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

	@GetMapping("/list-form")
	public String listFrom(){

		return "product_detail";
	}
}
