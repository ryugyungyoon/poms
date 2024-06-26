package com.jg.poms.controller.category;

import com.jg.poms.core.http.HttpBuilder;
import com.jg.poms.core.http.ResponseVO;
import com.jg.poms.dto.category.response.CategoryResponse;
import com.jg.poms.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@Controller
@RequiredArgsConstructor
public class CategoryController{

	private final CategoryService categoryService;

	private final HttpBuilder httpBuilder;

	/**
	 * [리스트 페이지 이동]
	 *
	 * @author zisooya
	 */
	@GetMapping("{categoryIdx}/list-form")
	public String listForm(Model model, @PathVariable(value="categoryIdx") Long categoryIdx) {
		List<CategoryResponse> subCategoryList;
		String pageUrl = "";

		//카테고리 별 페이지 반환
		if(categoryIdx == 4){
			subCategoryList = categoryService.getSubCategoryList(categoryIdx);
			model.addAttribute("subCategoryList", subCategoryList);
			pageUrl = "/menu/category/women/category_women_list";
		}

		//model.addAttribute("searchForm", searchForm);
		return pageUrl;
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

}
