package com.jg.poms.dto.category.response;

import com.jg.poms.domain.category.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryResponse {

	private Long categoryIdx;
	private int depth;
	private String depthName;
	private String categoryName;
	private Category parentCategory;
	private List<Category> childCategoryList;

	public CategoryResponse(Category category) {
		this.categoryIdx = category.getCategoryIdx();
		this.depth = category.getDepth();
		this.depthName = category.getDepthName();
		this.categoryName = category.getCategoryName();
		this.parentCategory = category.getParentCategory();
		this.childCategoryList = category.getChildCategoryList();
	}
}
