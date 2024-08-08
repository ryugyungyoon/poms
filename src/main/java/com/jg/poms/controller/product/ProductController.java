package com.jg.poms.controller.product;

import com.jg.poms.core.http.HttpBuilder;
import com.jg.poms.core.http.ResponseVO;
import com.jg.poms.dto.product.response.ProductResponse;
import com.jg.poms.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

	private final HttpBuilder httpBuilder;

	@PostMapping("all/list")
	@ResponseBody
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

	/**
	 * [상세 페이지 이동]
	 *
	 * @author ryugyunguoon
	 */
	@GetMapping("view-form")
	public String veiwForm(Model model, @RequestParam("productIdx") Long productIdx){
		model.addAttribute("product", productService.view(productIdx));
		return "product/product_view";
	}

	/**
	 * [상세 조회]
	 *
	 * @author ryugyunguoon
	 */
	@GetMapping("view")
	@ResponseBody
	public ResponseVO view(@RequestParam("productIdx") Long productIdx){
		return httpBuilder.resultForObject("view" ,productService.view(productIdx));
	}

}
