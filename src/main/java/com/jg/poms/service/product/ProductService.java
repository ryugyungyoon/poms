package com.jg.poms.service.product;

import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.category.CategoryRepository;
import com.jg.poms.domain.product.ProductRepository;
import com.jg.poms.dto.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Transactional(readOnly = true)
	//전체 상품 조회(select)
	public List<ProductResponse> getProductList() {
		return productRepository.findAll().stream()
				.map(ProductResponse::new)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	//현재 카테고리에 해당하는 상품 리스트 조회(select)
	public List<ProductResponse> getCategoryProductList(Long categoryIdx) {
		//현재 카테고리의 하위 카테고리 리스트 조회
		List<Category> categoryList = categoryRepository.findByParentCategory_CategoryIdx(categoryIdx);

		List<Long> categoryIdxList = new ArrayList<>();

		if(categoryList != null){
			for(Category category : categoryList) {
				categoryIdxList.add(category.getCategoryIdx());
			}
		}

		//하위 카테고리에 해당하는 상품 리스트 조회
		return productRepository.findByCategory_CategoryIdxInOrderByRegistrationDateDesc(categoryIdxList).stream()
				.map(ProductResponse::new)
				.collect(Collectors.toList());
	}
}
