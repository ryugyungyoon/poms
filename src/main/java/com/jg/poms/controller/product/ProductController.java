package com.jg.poms.controller.product;

import com.jg.poms.controller.base.BaseController;
import com.jg.poms.core.http.HttpBuilder;
import com.jg.poms.core.http.ResponseVO;
import com.jg.poms.dto.product.response.ProductResponse;
import com.jg.poms.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController extends BaseController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/all/list")
	public List<ProductResponse> getProductList(){
		return productService.getProductList();
	}

	/**
	 * [현재 카테고리에 해당하는 상품 리스트 조회(최신순)]
	 *
	 * @author zisooya
	 * @param  categoryIdx 현재 페이지 카테고리 순번
	 */
	@PostMapping("list")
	@ResponseBody
	public ResponseVO getCategoryProductList(@RequestParam("categoryIdx") Long categoryIdx) {
		return httpBuilder.resultForObjectList(productService.getCategoryProductList(categoryIdx));
	}


}
