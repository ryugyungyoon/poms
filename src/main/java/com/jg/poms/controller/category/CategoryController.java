package com.jg.poms.controller.category;

import com.jg.poms.core.http.HttpBuilder;
import com.jg.poms.core.http.ResponseVO;
import com.jg.poms.domain.category.Category;
import com.jg.poms.dto.category.request.CategoryRequest;
import com.jg.poms.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@Controller
public class CategoryController {

	private final HttpBuilder httpBuilder;
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService, HttpBuilder httpBuilder) {
		this.categoryService = categoryService;
		this.httpBuilder = httpBuilder;
	}

	/**
	 * [리스트 페이지 이동]
	 *
	 * @author zisooya
	 */
	@GetMapping("woman/list-form")
	public String listForm(Model model) {
		//검색 조건
		//model.addAttribute("searchForm", searchForm);

		return "menu/category/woman/category_woman_list";
	}

	@PostMapping("woman/listd")
	@ResponseBody
	public ResponseVO getCategoryList() {
		//return httpBuilder.resultForPagingList(categoryService.getCategoryList(), reqVO);
		return httpBuilder.resultForObjectList(categoryService.getCategoryList());
	}

	@PostMapping("woman/list")
	@ResponseBody
	public ResponseVO getSubCategoryList(@RequestParam("categoryIdx") Long categoryIdx) {
		System.out.println("categoryIdx: "+ categoryIdx);
		//return httpBuilder.resultForPagingList(categoryService.getCategoryList(), reqVO);
		return httpBuilder.resultForObjectList(categoryService.getSubCategoryList(categoryIdx));
	}


	/**
	 * [리스트 url]
	 *
	 * @author zisooya
	 */
	/*
	@GetMapping("list-form/{gender}/{depth}")
	public String listForm(Model model
			, @PathVariable("gender") String gender
			, @PathVariable("depth") String depth){
		return "";
	}
	*/

}
