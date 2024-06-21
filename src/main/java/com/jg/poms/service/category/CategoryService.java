package com.jg.poms.service.category;

import com.jg.poms.domain.category.CategoryRepository;
import com.jg.poms.dto.category.response.CategoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

	@Transactional(readOnly = true)
	//전체 카테고리 조회(select)
	public List<CategoryResponse> getCategoryList() {
		return categoryRepository.findAll().stream()
				.map(CategoryResponse::new)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	//현재 카테고리의 하위 카테고리 리스트 조회(select)
	public List<CategoryResponse> getSubCategoryList(Long categoryIdx) {
		return categoryRepository.findByParentCategory_CategoryIdx(categoryIdx).stream()
				.map(CategoryResponse::new)
				.collect(Collectors.toList());
	}

}
