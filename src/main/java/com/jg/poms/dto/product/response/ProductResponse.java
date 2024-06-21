package com.jg.poms.dto.product.response;

import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.productimage.ProductImage;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponse {

	private Long productIdx;
	private Long brandIdx;
	private Category category;
	private String name;
	private String code;
	private String price;
	private List<ProductImage> productImageList;

	public ProductResponse(Long productIdx, Long brand_idx, Category category, String name, String code, List<ProductImage> productImageList) {
		this.productIdx = productIdx;
		this.brandIdx = brand_idx;
		this.category = category;
		this.name = name;
		this.code = code;
		this.productImageList = productImageList;
	}

	public ProductResponse(Product product){
		this.productIdx = product.getProductIdx();
        this.brandIdx = product.getBrandIdx();
        this.category = product.getCategory();
        this.name = product.getName();
        this.code = product.getCode();
        this.price = product.getPrice();
        this.productImageList = product.getProductImageList();
	}
}
