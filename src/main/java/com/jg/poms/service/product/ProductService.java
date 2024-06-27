package com.jg.poms.service.product;

import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.category.CategoryRepository;
import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.ProductRepository;
import com.jg.poms.domain.product.productimage.ProductImage;
import com.jg.poms.domain.product.productimage.ProductImageRepository;
import com.jg.poms.domain.review.Review;
import com.jg.poms.domain.review.ReviewImage;
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
	private final ProductImageRepository productImageRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductImageRepository productImageRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.productImageRepository = productImageRepository;
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
		List<Product> productList =  productRepository.findByCategory_CategoryIdxInOrderByRegistrationDateDesc(categoryIdxList);

		List<ProductImage> productImageList;

		if(productList != null) {
			for (Product product : productList) {
				//상품 이미지 조회
				productImageList = productImageRepository.findByProduct_ProductIdx(product.getProductIdx());
				product.setProductImageList(productImageList);
			}
		}

		return productList.stream()
				.map(ProductResponse::new)
				.filter(product -> !product.isDeleteYn())
				.collect(Collectors.toList());
	}

	@Transactional
	public ProductResponse view(Long productIdx){
		return new ProductResponse(productRepository.findById(productIdx).get());
	}
}
