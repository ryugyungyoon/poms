package com.jg.poms.controller.category;

import com.jg.poms.controller.base.BaseController;
import com.jg.poms.core.http.HttpBuilder;
import com.jg.poms.core.http.ResponseVO;
import com.jg.poms.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@Controller
public class CategoryController {

	private final CategoryService categoryService;
	private final HttpBuilder httpBuilder;

	public CategoryController(CategoryService categoryService, HttpBuilder httpBuilder) {
		this.categoryService = categoryService;
		this.httpBuilder = httpBuilder;
	}

	/**
	 * [리스트 페이지 이동]
	 *
	 * @author zisooya
	 */
	@GetMapping("women/list-form")
	public String listForm(Model model) {
		//검색 조건
		//model.addAttribute("searchForm", searchForm);

		return "/menu/category/women/category_women_list";
	}
	/**
	 * [카테고리 전체 리스트 조회]
	 *
	 * @author zisooya
	 */
	@PostMapping("women/listd")
	@ResponseBody
	public ResponseVO getCategoryList() {
		//return httpBuilder.resultForPagingList(categoryService.getCategoryList(), reqVO);
		return httpBuilder.resultForObjectList(categoryService.getCategoryList());
	}
	/**
	 * [현재 카테고리의 하위 카테고리 리스트 조회]
	 *
	 * @author zisooya
	 * @param  categoryIdx 현재 페이지 카테고리 순번
	 */
	@PostMapping("sub/list")
	@ResponseBody
	public ResponseVO getSubCategoryList(@RequestParam("categoryIdx") Long categoryIdx) {
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
